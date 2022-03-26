package com.distarise.distabank.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.model.CustomerDto;
import com.distarise.distabank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadCustomerAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    CustomerService customerService;

    public void executeAction() {
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        String customerId = request.getParameter(CustomerDto.CUSTOMER_ID);
        Long customerIdLong = 0L;
        if (null != customerId){
            customerIdLong = Long.parseLong(customerId);
            request.getSession().setAttribute(CustomerDto.CUSTOMER_ID, customerIdLong);
        } else if (null != request.getSession().getAttribute(CustomerDto.CUSTOMER_ID)) {
            customerIdLong = (Long) request.getSession().getAttribute(CustomerDto.CUSTOMER_ID);
        }

        CustomerDto customerDto = customerService.searchCustomerById(customerIdLong).get(0);

        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()) {
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("customer")) {
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if (targetComponentDto.getId().equalsIgnoreCase("customerid")) {
                                targetComponentDto.setValue(customerDto.getId().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("firstname")){
                                targetComponentDto.setValue(customerDto.getFirstname());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("lastname")){
                                targetComponentDto.setValue(customerDto.getLastname());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("gender")){
                                targetComponentDto.setValue(customerDto.getGender());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("addressline1")){
                                targetComponentDto.setValue(customerDto.getAddressline1());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("addressline2")){
                                targetComponentDto.setValue(customerDto.getAddressline2());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("phone")){
                                targetComponentDto.setValue(customerDto.getPhone());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("pincode")){
                                targetComponentDto.setValue(customerDto.getPincode());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("city")){
                                targetComponentDto.setValue(customerDto.getCity());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("state")){
                                targetComponentDto.setValue(customerDto.getState());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("country")){
                                targetComponentDto.setValue(customerDto.getCountry());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("active")){
                                targetComponentDto.setValue(customerDto.getActive().toString());
                            } else if (targetComponentDto.getId().equalsIgnoreCase("dob")){
                                targetComponentDto.setValue(customerDto.getDob().toString());
                            }
                        });
                    }
                });
            }
        });
    }

}
