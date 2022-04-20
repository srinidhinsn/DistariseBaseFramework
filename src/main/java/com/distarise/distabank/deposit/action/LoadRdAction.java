package com.distarise.distabank.deposit.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.deposit.model.DistabankContext;
import com.distarise.distabank.deposit.model.RecurringDepositConfigDto;
import com.distarise.distabank.deposit.model.RecurringDepositDto;
import com.distarise.distabank.deposit.service.RecurringDepositConfigService;
import com.distarise.distabank.deposit.service.RecurringDepositService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoadRdAction extends AbstractBaseAction {

    private static final Logger logger = LoggerFactory.getLogger(LoadRdAction.class);

    @Autowired
    private RecurringDepositConfigService rdConfigService;

    @Autowired
    private RecurringDepositService rdService;

    public void executeAction() {
        DistabankContext distabankContext = DistabankContext.getDistabankContext(request, getClientId());
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        RecurringDepositConfigDto rdConfig = rdConfigService.getRdConfig(distabankContext.getClientId(), new Date(), null);
        String selectedRd = request.getParameter("fdlist");
        List<RecurringDepositDto> rdDtoList = rdService.findAllByClientIdAndCustomerId(distabankContext.getClientId(), distabankContext.getCustomerId());
        RecurringDepositDto fd = rdDtoList.stream().filter(rdDto ->
                rdDto.getId().toString().equals(selectedRd)).findFirst().orElse(null);
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()) {
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("rd") && null != fd) {
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if (targetComponentDto.getId().equalsIgnoreCase("customerid")) {
                                targetComponentDto.setValue(fd.getCustomerId().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("customername")){
                                targetComponentDto.setValue(fd.getCustomerName());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("startdate")){
                                targetComponentDto.setValue(fd.getEffectiveDate().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("maturitydate")){
                                targetComponentDto.setValue(fd.getMaturityDate().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("withdrawaldate")){
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
                                if (null != rdDtoList){
                                   convertToComponentItem(targetComponentDto.getComponentItemDtos(), distabankContext.getClientId(),
                                           rdDtoList, selectedRd);
                                }
                            }
                        });
                    } else if (targetWidgetDto.getId().equalsIgnoreCase("rd") && null != rdConfig) {
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if (targetComponentDto.getId().equalsIgnoreCase("customerid")) {
                                targetComponentDto.setValue(distabankContext.getCustomerId().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("customername")){
                                targetComponentDto.setValue(distabankContext.getCustomerName());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("roi")){
                                targetComponentDto.setValue(rdConfig.getRoi().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("calcmethod")){
                                targetComponentDto.setValue(rdConfig.getCalcMethod());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("calcfrequency")){
                                targetComponentDto.setValue(rdConfig.getCalcFrequency());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("fdlist")){
                                if (null != rdDtoList){
                                    convertToComponentItem(targetComponentDto.getComponentItemDtos(), distabankContext.getClientId(),
                                            rdDtoList, selectedRd);
                                }
                            }
                        });
                    }
                });
            }
        });


    }

    private void convertToComponentItem(List<ComponentItemDto> componentItemDtos, String clientId,
                                                          List<RecurringDepositDto> fdDtoList, String selectedRd) {
        for (int i=0;i<fdDtoList.size();i++){
            ComponentItemDto item = new ComponentItemDto(400L * ComponentItemDto.ID_MULTIPLIER+i, "fdlist", clientId, 3600+i, fdDtoList.get(i).getId().toString(),
                    fdDtoList.get(i).getAccountNo(), false, true);
            if (item.getValue().equals(selectedRd)){
                item.setSelected(true);
            }
            componentItemDtos.add(item);
        }

    }

}
