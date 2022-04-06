package com.distarise.distabank.customer.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.customer.model.CustomerDto;
import com.distarise.distabank.customer.service.CustomerService;
import com.distarise.distabank.deposit.model.DistabankContext;
import com.distarise.distabank.util.DistabankUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SaveCustomerAction extends AbstractBaseAction {

    private static final Logger logger = LoggerFactory.getLogger(SaveCustomerAction.class);

    @Autowired
    private CustomerService customerService;

    public void executeAction() {
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        DistabankContext context = DistabankContext.getDistabankContext(request, getClientId());
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
        String dob = request.getParameter("dob");
        Boolean activeBoolean = true;
        Long customerIdLong = 0l;
        Date dobDate = DistabankUtils.stringYYYYMMDDToDate(dob);

        if (null != customerid){
            customerIdLong = Long.parseLong(customerid);
            if (null != active){
                activeBoolean = true;
            } else {
                activeBoolean = false;
            }
        }

        CustomerDto customerDto = new CustomerDto(context.getClientId(), customerIdLong, firstname, lastname, gender, addressline1, addressline2,
                city, state, country, activeBoolean, pincode, phone, dobDate);
        customerService.saveCustomer(customerDto);
    }

}
