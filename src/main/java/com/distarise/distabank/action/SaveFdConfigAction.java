package com.distarise.distabank.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.model.CustomerDto;
import com.distarise.distabank.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SaveFdConfigAction extends AbstractBaseAction implements BaseAction {

    private static final Logger logger = LoggerFactory.getLogger(SaveFdConfigAction.class);

    @Autowired
    private CustomerService customerService;

    public void executeAction() {
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
        String dob = request.getParameter("dob");
        Boolean activeBoolean = true;
        Long customerIdLong = 0l;

        Date dobDate = null;
        try{
            dobDate = new SimpleDateFormat(CustomerDto.DATE_YYYY_MM_DD).parse(dob);
        } catch (Exception e){
            logger.error(e.getMessage());
        }

        if (null != customerid){
            customerIdLong = Long.parseLong(customerid);
            if (null != active){
                activeBoolean = true;
            } else {
                activeBoolean = false;
            }
        }

        CustomerDto customerDto = new CustomerDto(customerIdLong, firstname, lastname, gender, addressline1, addressline2,
                city, state, country, activeBoolean, pincode, phone, dobDate);
        customerService.saveCustomer(customerDto);
    }

}
