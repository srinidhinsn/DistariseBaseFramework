package com.distarise.distabank.deposit.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.deposit.model.DistabankContext;
import com.distarise.distabank.deposit.model.FixedDepositConfigDto;
import com.distarise.distabank.deposit.model.FixedDepositDto;
import com.distarise.distabank.deposit.service.FixedDepositConfigService;
import com.distarise.distabank.deposit.service.FixedDepositService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoadFdAction extends AbstractBaseAction implements BaseAction {

    private static final Logger logger = LoggerFactory.getLogger(LoadFdAction.class);

    @Autowired
    private FixedDepositConfigService fdConfigService;

    @Autowired
    private FixedDepositService fdService;

    public void executeAction() {
        DistabankContext distabankContext = DistabankContext.getDistabankContext(request, getClientId());
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        FixedDepositConfigDto fdConfig = fdConfigService.getFdConfig(distabankContext.getClientId(), new Date(), null);
        String selectedFd = request.getParameter("fdlist");
        List<FixedDepositDto> fdDtoList = fdService.findAllByClientId(distabankContext.getClientId());
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()) {
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("fd")) {
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if (targetComponentDto.getId().equalsIgnoreCase("customerid")) {
                                targetComponentDto.setValue(distabankContext.getCustomerId().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("customername")){
                                targetComponentDto.setValue(distabankContext.getCustomerName());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("startdate")){
                                targetComponentDto.setValue(new Date().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("roi") && null != fdConfig){
                                targetComponentDto.setValue(fdConfig.getRoi().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("calcmethod") && null != fdConfig){
                                targetComponentDto.setValue(fdConfig.getCalcMethod());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("fdlist")){
                                if (null != fdDtoList){
                                   convertToComponentItem(targetComponentDto.getComponentItemDtos(), distabankContext.getClientId(),
                                           fdDtoList, selectedFd);
                                }
                            }
                        });
                    }
                });
            }
        });


    }

    private void convertToComponentItem(List<ComponentItemDto> componentItemDtos, String clientId,
                                                          List<FixedDepositDto> fdDtoList, String selectedFd) {
        for (int i=0;i<fdDtoList.size();i++){
            ComponentItemDto item = new ComponentItemDto(3600L+i, "fdlist", clientId, 3600+i, fdDtoList.get(i).getId().toString(),
                    fdDtoList.get(i).getAccountNo(), false, true);
            if (item.getValue().equals(selectedFd)){
                item.setSelected(true);
            }
            componentItemDtos.add(item);
        }

    }

}
