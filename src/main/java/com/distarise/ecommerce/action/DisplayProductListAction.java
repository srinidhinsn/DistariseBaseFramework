package com.distarise.ecommerce.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.ecommerce.model.ProductDto;
import com.distarise.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DisplayProductListAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    ProductService productService;

    @Override
    public void executeAction() {
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        List<ProductDto> productDtoList = productService.findAll();
        List<Map<String, Object>> objectList = new ArrayList<>();
        productDtoList.forEach(productDto -> {
            objectList.add(oMapper.convertValue(productDto, Map.class));
        });

        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("productlist")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if (targetComponentDto.getId().equalsIgnoreCase("listproduct")){
                                targetComponentDto.setObjectList(objectList);
                            }
                        });
                    }
                });
            }
        });
    }
}
