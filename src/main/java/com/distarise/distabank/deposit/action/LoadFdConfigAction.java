package com.distarise.distabank.deposit.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.deposit.model.DistabankContext;
import com.distarise.distabank.deposit.model.FixedDepositConfigDto;
import com.distarise.distabank.deposit.service.FixedDepositConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoadFdConfigAction extends AbstractBaseAction{

    private static final Logger logger = LoggerFactory.getLogger(LoadFdConfigAction.class);


    @Autowired
    private FixedDepositConfigService fdConfigService;

    public void executeAction() {
        DistabankContext distabankContext = DistabankContext.getDistabankContext(request, getClientId());
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        String fdConfigId = request.getParameter("validfrom");
        Long fdConfigIdLong = null;
        if (null != fdConfigId && !fdConfigId.isEmpty() && !fdConfigId.equalsIgnoreCase("new")){
            fdConfigIdLong = Long.valueOf(fdConfigId);
        }

        FixedDepositConfigDto fdConfig = fdConfigService.getFdConfig(fdConfigIdLong);
            targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
                if (!navigationItemDto.getWidgets().isEmpty()) {
                    navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                        if (targetWidgetDto.getId().equalsIgnoreCase("fdconfig") && null != fdConfig) {
                            targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                                if (targetComponentDto.getId().equalsIgnoreCase("accountnoseq")) {
                                    targetComponentDto.setValue(fdConfig.getAccountNoSeq());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("minduration")) {
                                    targetComponentDto.setValue(fdConfig.getMinDuration().toString());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("effectivedate")) {
                                    targetComponentDto.setValue(fdConfig.getEffectiveDate().toString());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("enddate")) {
                                    targetComponentDto.setValue(fdConfig.getEndDate().toString());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("roi")) {
                                    targetComponentDto.setValue(fdConfig.getRoi().toString());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("calcmethod")) {
                                    targetComponentDto.setValue(fdConfig.getCalcMethod());
                                }  else if (targetComponentDto.getId().equalsIgnoreCase("fdconfigid")) {
                                    targetComponentDto.setValue(fdConfig.getId().toString());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("validfrom")) {
                                    List<FixedDepositConfigDto> validity = fdConfigService.getAllByClientId(distabankContext.getClientId());
                                    List<ComponentItemDto> componentItemDtoList = convertToComponentItems(validity, fdConfigId, distabankContext.getClientId());
                                    targetComponentDto.getComponentItemDtos().addAll(componentItemDtoList);
                                }
                            });
                        } else if (targetWidgetDto.getId().equalsIgnoreCase("fdconfig")){
                            targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                                if (targetComponentDto.getId().equalsIgnoreCase("validfrom")) {
                                    List<FixedDepositConfigDto> validity = fdConfigService.getAllByClientId(distabankContext.getClientId());
                                    List<ComponentItemDto> componentItemDtoList = convertToComponentItems(validity, fdConfigId, distabankContext.getClientId());
                                    targetComponentDto.getComponentItemDtos().addAll(componentItemDtoList);
                                }
                            });
                        }
                    });
                }
            });
    }


    private List<ComponentItemDto> convertToComponentItems(List<FixedDepositConfigDto> validity, String fdConfigId, String clientId) {
        List<ComponentItemDto> componentItemDtoList = new ArrayList<>();
        for (int i=0;i<validity.size();i++){
            String validFrom = validity.get(i).getEffectiveAndEndDateDropDown();
            ComponentItemDto componentItemDto = new ComponentItemDto(3600L+i, "validfrom", clientId, 3600+i,
                    validity.get(i).getId().toString(), validFrom, true, true );
            if (componentItemDto.getValue().equals(fdConfigId)){
                componentItemDto.setSelected(true);
            }

            componentItemDtoList.add(componentItemDto);
        }

        return componentItemDtoList;
    }
}
