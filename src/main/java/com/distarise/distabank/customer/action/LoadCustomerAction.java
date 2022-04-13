package com.distarise.distabank.customer.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.customer.model.CustomerDto;
import com.distarise.distabank.deposit.model.DistabankContext;
import com.distarise.distabank.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadCustomerAction extends AbstractBaseAction {

    @Autowired
    CustomerService customerService;

    public void executeAction() {
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        DistabankContext context = DistabankContext.getDistabankContext(request, getClientId());
        List<CustomerDto> customerDtoList = customerService.searchCustomerById(context.getClientId(), context.getCustomerId());
        if (null != customerDtoList) {
            CustomerDto customerDto = customerDtoList.get(0);
            context.setCustomerName(customerDto.getFirstname() + " " + customerDto.getLastname());
            targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
                if (!navigationItemDto.getWidgets().isEmpty()) {
                    navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                        if (targetWidgetDto.getId().equalsIgnoreCase("customer")) {
                            targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                                if (targetComponentDto.getId().equalsIgnoreCase("customerid")) {
                                    targetComponentDto.setValue(customerDto.getId().toString());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("firstname")) {
                                    targetComponentDto.setValue(customerDto.getFirstname());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("lastname")) {
                                    targetComponentDto.setValue(customerDto.getLastname());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("gender")) {
                                    targetComponentDto.setValue(customerDto.getGender());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("addressline1")) {
                                    targetComponentDto.setValue(customerDto.getAddressline1());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("addressline2")) {
                                    targetComponentDto.setValue(customerDto.getAddressline2());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("phone")) {
                                    targetComponentDto.setValue(customerDto.getPhone());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("pincode")) {
                                    targetComponentDto.setValue(customerDto.getPincode());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("city")) {
                                    targetComponentDto.setValue(customerDto.getCity());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("state")) {
                                    targetComponentDto.setValue(customerDto.getState());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("country")) {
                                    targetComponentDto.setValue(customerDto.getCountry());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("active")) {
                                    targetComponentDto.setValue(customerDto.getActive().toString());
                                } else if (targetComponentDto.getId().equalsIgnoreCase("dob")) {
                                    targetComponentDto.setValue(customerDto.getDob().toString());
                                }
                            });
                        }
                    });
                }
            });
        }
    }
}
