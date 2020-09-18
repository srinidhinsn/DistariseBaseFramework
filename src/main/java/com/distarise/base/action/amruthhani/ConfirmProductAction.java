package com.distarise.base.action.amruthhani;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.model.amruthhani.OrdersDto;
import com.distarise.base.model.amruthhani.ProductDto;
import com.distarise.base.service.amruthhani.OrdersService;
import com.distarise.base.service.amruthhani.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ConfirmProductAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    ProductService productService;

    @Autowired
    OrdersService ordersService;

    @Override
    public void executeAction() {
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        WidgetDto sourceWidgetDto = super.executeAction(new WidgetDto());
        String productId = request.getParameter("productId");
        Integer quantity = Integer.parseInt(request.getParameter("qty"));
        BigDecimal shippingCharges = BigDecimal.valueOf(Long.parseLong(request.getParameter("shipping")));
        ProductDto productDto = productService.findById(productId);
        OrdersDto ordersDto = new OrdersDto();
        BigDecimal priceAfterDiscount = new BigDecimal(0);
        ordersDto.setProductId(productId);
        ordersDto.setQuantity(quantity);
        ordersDto.setPrice(productDto.getPrice().multiply(new BigDecimal(quantity)));
        ordersDto.setDeliveryCharges(shippingCharges);
        if (quantity < 10){
            ordersDto.setDiscount(new BigDecimal(0));
        }
        else if (quantity >= 10 && quantity < 20){
            ordersDto.setDiscount(new BigDecimal(200).multiply(new BigDecimal(quantity)));
        } else if (quantity >= 20 && quantity < 50){
            ordersDto.setDiscount(new BigDecimal(300).multiply(new BigDecimal(quantity)));
        } else {
            ordersDto.setDiscount(new BigDecimal(400).multiply(new BigDecimal(quantity)));
        }

        priceAfterDiscount = ordersDto.getPrice().subtract(ordersDto.getDiscount());
        ordersDto.setTotalGst(priceAfterDiscount.multiply(productDto.getGst()).divide(new BigDecimal(100)));
        ordersDto.setFinalPrice(priceAfterDiscount.add(ordersDto.getTotalGst()).add(ordersDto.getDeliveryCharges()));

        ordersDto = ordersService.save(ordersDto);

        List<Map<String, Object>> objectList = new ArrayList<>();
        objectList.add(oMapper.convertValue(productDto, Map.class));
        objectList.add(oMapper.convertValue(ordersDto, Map.class));

        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("cart")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if (targetComponentDto.getId().equalsIgnoreCase("cart")){
                                targetComponentDto.setObjectList(objectList);
                            }
                        });
                    }
                });
            }
        });
    }
}
