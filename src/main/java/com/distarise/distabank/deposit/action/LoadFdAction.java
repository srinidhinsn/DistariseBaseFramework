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
import com.distarise.distabank.util.DepositAccountStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoadFdAction extends AbstractBaseAction {

    private static final Logger logger = LoggerFactory.getLogger(LoadFdAction.class);

    @Autowired
    private FixedDepositConfigService fdConfigService;

    @Autowired
    private FixedDepositService fdService;

    public void executeAction() {
        DistabankContext distabankContext = DistabankContext.getDistabankContext(request, getClientId());
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        FixedDepositConfigDto fdConfig = fdConfigService.getFdConfig(distabankContext.getClientId(), new Date(), new Date());
        String selectedFd = request.getParameter("fdlist");
        List<FixedDepositDto> fdDtoList = fdService.findAllByClientIdAndCustomerId(distabankContext.getClientId(), distabankContext.getCustomerId());
        FixedDepositDto fd = fdDtoList.stream().filter(fixedDepositDto ->
                fixedDepositDto.getId().toString().equals(selectedFd)).findFirst().orElse(null);
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()) {
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("fd") && null != fd) {
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if (fd.getStatus().equals(DepositAccountStatus.Ended.name()) ||
                                    fd.getStatus().equals(DepositAccountStatus.PreMatured.name()) ){
                                targetComponentDto.setEditable(false);
                            }

                            if (targetComponentDto.getId().equalsIgnoreCase("customerid")) {
                                targetComponentDto.setValue(fd.getCustomerId().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("customername")){
                                targetComponentDto.setValue(fd.getCustomerName());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("startdate")){
                                targetComponentDto.setValue(fd.getEffectiveDate().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("maturitydate")){
                                targetComponentDto.setValue(fd.getMaturityDate().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("withdrawaldate")){
                                if (null != fd.getWithdrawalDate()){
                                    targetComponentDto.setValue(fd.getWithdrawalDate().toString());
                                }
                                targetComponentDto.setEditable(true);
                            } else if (targetComponentDto.getId().equalsIgnoreCase("accountno")){
                                targetComponentDto.setValue(fd.getAccountNo());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("amount")){
                                targetComponentDto.setValue(fd.getAmount().toString());
                                targetComponentDto.setEditable(false);
                            } else if (targetComponentDto.getId().equalsIgnoreCase("maturityvalue")){
                                targetComponentDto.setValue(fd.getMaturityValue().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("referencecode")){
                                targetComponentDto.setValue(fd.getReferenceCode());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("roi")){
                                targetComponentDto.setValue(fd.getRoi().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("calcmethod")){
                                targetComponentDto.setValue(fd.getCalcMethod());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("calcfrequency")){
                                targetComponentDto.setValue(fd.getCalcFrequency());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("fdlist")){
                                if (null != fdDtoList){
                                   convertToComponentItem(targetComponentDto.getComponentItemDtos(), distabankContext.getClientId(),
                                           fdDtoList, selectedFd);
                                }
                            }
                        });
                    } else if (targetWidgetDto.getId().equalsIgnoreCase("fd") && null != fdConfig) {
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if (targetComponentDto.getId().equalsIgnoreCase("customerid")) {
                                targetComponentDto.setValue(distabankContext.getCustomerId().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("customername")){
                                targetComponentDto.setValue(distabankContext.getCustomerName());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("roi")){
                                targetComponentDto.setValue(fdConfig.getRoi().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("calcmethod")){
                                targetComponentDto.setValue(fdConfig.getCalcMethod());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("calcfrequency")){
                                targetComponentDto.setValue(fdConfig.getCalcFrequency());
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
            ComponentItemDto item = new ComponentItemDto(400L * ComponentItemDto.ID_MULTIPLIER+i, "fdlist", clientId, 3600+i, fdDtoList.get(i).getId().toString(),
                    fdDtoList.get(i).getAccountNo(), false, true, "text");
            if (item.getValue().equals(selectedFd)){
                item.setSelected(true);
            }
            componentItemDtos.add(item);
        }

    }

}
