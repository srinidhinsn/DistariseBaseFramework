package com.distarise.distabank.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.model.CustomerDto;
import com.distarise.distabank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private CustomerService customerService;

    public void executeAction(){
        String searchKey = request.getParameter("searchKey");
        List<CustomerDto> customerDtoList = customerService.searchCustomer(searchKey);
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("searchresult")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if(targetComponentDto.getId().equalsIgnoreCase("customergrid")){
                                loadCustomerDataToGrid(targetComponentDto, customerDtoList);
                            }
                        });
                    }
                });
            }
        });
    }

    private void loadCustomerDataToGrid(ComponentDto targetComponentDto, List<CustomerDto> customerDtoList) {
        List<Map<String, String>> gridMapList = new ArrayList<>();
        customerDtoList.forEach(customerDto -> {
            Map<String, String> gridMap = new HashMap<>();
            gridMap.put("customerId", customerDto.getId().toString());
            gridMap.put("firstname", customerDto.getFirstname());
            gridMap.put("lastname", customerDto.getLastname());
            gridMap.put("phone", customerDto.getPhone());
            gridMapList.add(gridMap);
        });
        targetComponentDto.setGridValues(gridMapList);
    }


}
