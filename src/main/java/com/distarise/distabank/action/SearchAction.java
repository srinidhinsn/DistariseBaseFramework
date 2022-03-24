package com.distarise.distabank.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.model.CustomerDto;
import com.distarise.distabank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private CustomerService customerService;

    public void executeAction(){
        String searchKey = request.getParameter("searchKey");
        List<CustomerDto> customerDtoList = customerService.searchCustomer(searchKey);

    }

}
