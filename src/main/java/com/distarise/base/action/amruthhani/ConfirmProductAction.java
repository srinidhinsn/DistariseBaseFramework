package com.distarise.base.action.amruthhani;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.model.amruthhani.OrdersDto;
import com.distarise.base.model.amruthhani.ProductDto;
import com.distarise.base.service.amruthhani.OrdersService;
import com.distarise.base.service.amruthhani.ProductService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConfirmProductAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    ProductService productService;

    @Autowired
    OrdersService ordersService;

    //Live mode
    protected static String apiKey = "rzp_live_VDRkjWUVL6XEzg";
    //String secretKey ="icegs4aLUdsnnTvEE4frB5TE";

    //Test mode
    //protected static final String apiKey = "rzp_test_caMHPnsa7yJSK3";
    protected static final String secretKey ="wqYpioxszfVb0z6bTE6SwEKo";
    protected static final String smsApiKey = "56cd1b28-fe50-11ea-9fa5-0200cd936042";

    @Override
    public void executeAction() {
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        WidgetDto sourceWidgetDto = super.executeAction(new WidgetDto());
        String productId = request.getParameter("productId");
        Integer quantity = Integer.parseInt(request.getParameter("qty"));
        BigDecimal shippingCharges = new BigDecimal(500);
        if(null != request.getParameter("shipping")){
            String shippingChargesString = request.getParameter("shipping");
            shippingCharges = BigDecimal.valueOf(Long.parseLong(shippingChargesString));
        }

        ProductDto productDto = productService.findById(productId);
        OrdersDto ordersDto = new OrdersDto();
        BigDecimal priceAfterDiscount = new BigDecimal(0);
        ordersDto.setProductId(productId);
        ordersDto.setQuantity(quantity);
        ordersDto.setPrice(productDto.getPrice().multiply(new BigDecimal(quantity)));
        ordersDto.setDeliveryCharges(shippingCharges.add(productDto.getDeliveryCharges()));
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
        Map<String, Object> productMap = oMapper.convertValue(productDto, Map.class);
        productMap.put("smsApiKey", ConfirmProductAction.smsApiKey);
        productMap.put("smsApiKey", ConfirmProductAction.smsApiKey);
        objectList.add(productMap);
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
