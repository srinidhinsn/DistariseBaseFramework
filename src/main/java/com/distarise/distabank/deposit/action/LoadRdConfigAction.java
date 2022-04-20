package com.distarise.distabank.deposit.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.deposit.model.DistabankContext;
import com.distarise.distabank.deposit.model.RecurringDepositConfigDto;
import com.distarise.distabank.deposit.service.RecurringDepositConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoadRdConfigAction extends AbstractBaseAction{

    private static final Logger logger = LoggerFactory.getLogger(LoadRdConfigAction.class);


    @Autowired
    private RecurringDepositConfigService rdConfigService;

    public void executeAction() {
        DistabankContext distabankContext = DistabankContext.getDistabankContext(request, getClientId());
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        String rdConfigId = request.getParameter("validfrom");
        Long rdConfigIdLong = null;
        if (null != rdConfigId && !rdConfigId.isEmpty() && !rdConfigId.equalsIgnoreCase("new")){
            rdConfigIdLong = Long.valueOf(rdConfigId);
        }

        RecurringDepositConfigDto rdConfig = rdConfigService.getRdConfig(rdConfigIdLong);
            targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
                if (!navigationItemDto.getWidgets().isEmpty()) {
                    navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                        if (targetWidgetDto.getId().equalsIgnoreCase("rdconfig") && null != rdConfig) {
                            targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                                if (targetComponentDto.getId().equalsIgnoreCase("minduration")) {
                                    targetComponentDto.setValue(rdConfig.getMinDuration().toString());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("effectivedate")) {
                                    targetComponentDto.setValue(rdConfig.getEffectiveDate().toString());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("enddate")) {
                                    targetComponentDto.setValue(rdConfig.getEndDate().toString());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("roi")) {
                                    targetComponentDto.setValue(rdConfig.getRoi().toString());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("calcmethod")) {
                                    targetComponentDto.setValue(rdConfig.getCalcMethod());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("calcfrequency")) {
                                    targetComponentDto.setValue(rdConfig.getCalcFrequency());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("fdconfigid")) {
                                    targetComponentDto.setValue(rdConfig.getId().toString());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("deviation")) {
                                    targetComponentDto.setValue(rdConfig.getMaturityValueDeviation().toString());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("validfrom")) {
                                    List<RecurringDepositConfigDto> validity = rdConfigService.getAllByClientId(distabankContext.getClientId());
                                    List<ComponentItemDto> componentItemDtoList = convertToComponentItems(validity, rdConfigId, distabankContext.getClientId());
                                    targetComponentDto.getComponentItemDtos().addAll(componentItemDtoList);
                                }
                            });
                        } else if (targetWidgetDto.getId().equalsIgnoreCase("rdconfig")){
                            targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                                if (targetComponentDto.getId().equalsIgnoreCase("validfrom")) {
                                    List<RecurringDepositConfigDto> validity = rdConfigService.getAllByClientId(distabankContext.getClientId());
                                    List<ComponentItemDto> componentItemDtoList = convertToComponentItems(validity, rdConfigId, distabankContext.getClientId());
                                    targetComponentDto.getComponentItemDtos().addAll(componentItemDtoList);
                                }
                            });
                        }
                    });
                }
            });
    }


    private List<ComponentItemDto> convertToComponentItems(List<RecurringDepositConfigDto> validity, String fdConfigId, String clientId) {
        List<ComponentItemDto> componentItemDtoList = new ArrayList<>();
        for (int i=0;i<validity.size();i++){
            String validFrom = validity.get(i).getEffectiveAndEndDateDropDown();
            ComponentItemDto componentItemDto = new ComponentItemDto(360L * ComponentItemDto.ID_MULTIPLIER+i, "validfrom", clientId, 3600+i,
                    validity.get(i).getId().toString(), validFrom, true, true );
            if (componentItemDto.getValue().equals(fdConfigId)){
                componentItemDto.setSelected(true);
            }

            componentItemDtoList.add(componentItemDto);
        }

        return componentItemDtoList;
    }
}
