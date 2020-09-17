package com.distarise.base.action.amruthhani;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.amruthhani.ProductDto;
import com.distarise.base.service.amruthhani.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ViewProductDetailsAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    ProductService productService;

    @Override
    public void executeAction() {
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        ProductDto productDto = productService.findById(request.getParameter("productId"));
        List<Map<String, Object>> objectList = new ArrayList<>();
        objectList.add(oMapper.convertValue(productDto, Map.class));

        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("productlist")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            targetComponentDto.setObjectList(objectList);
                        });
                    }
                });
            }
        });
    }
}
