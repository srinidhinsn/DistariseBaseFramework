package com.distarise.distabank.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.model.CustomerDto;
import com.distarise.distabank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveCustomerAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private CustomerService customerService;

    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        String customerid = request.getParameter("customerid");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        String addressline1 = request.getParameter("addressline1");
        String addressline2 = request.getParameter("addressline2");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String pincode = request.getParameter("pincode");
        String phone = request.getParameter("phone");
        String active = request.getParameter("active");
        Boolean activeBoolean = false;
        Long customerIdLong = 0l;
        if (null != customerid){
            customerIdLong = Long.parseLong(customerid);
        }
        if (null != active){
            activeBoolean = Boolean.parseBoolean(active);
        }
        CustomerDto customerDto = new CustomerDto(customerIdLong, firstname, lastname, gender, addressline1, addressline2,
                city, state, country, activeBoolean, pincode, phone);
        customerService.saveCustomer(customerDto);
    }

}
