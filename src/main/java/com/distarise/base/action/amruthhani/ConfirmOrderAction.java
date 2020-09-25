package com.distarise.base.action.amruthhani;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.model.amruthhani.CustomerDto;
import com.distarise.base.model.amruthhani.OrdersDto;
import com.distarise.base.model.amruthhani.ProductDto;
import com.distarise.base.service.amruthhani.CustomerService;
import com.distarise.base.service.amruthhani.OrdersService;
import com.distarise.base.service.amruthhani.ProductService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Service
public class ConfirmOrderAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    ProductService productService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    CustomerService customerService;

    @Override
    public void executeAction() {
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        WidgetDto sourceWidgetDto = super.executeAction(new WidgetDto());
        CustomerDto customerDto = new CustomerDto();
        CustomerDto savedCustomerDto;
        String orderId = request.getParameter("orderId");
        String productId = request.getParameter("productId");
        String customerId = request.getParameter("customerId");
        String otpMatched = request.getParameter("otpMatched");
        String otpSessionId = request.getParameter("otpSessionId");
        String sendMail = request.getParameter("sendMail");
        sendMail = "true";
        otpMatched = "true";
        ProductDto productDto = productService.findById(productId);
        OrdersDto ordersDto = ordersService.findById(Long.parseLong(orderId));
        Map<String, Object> orderMap = oMapper.convertValue(ordersDto, Map.class);
        List<Map<String, Object>> objectList = new ArrayList<>();
        Map<String, Object> productMap = oMapper.convertValue(productDto, Map.class);
        productMap.put("smsApiKey", ConfirmProductAction.smsApiKey);
        productMap.put("sendMail", sendMail);
        productMap.put("otpSessionId", otpSessionId);
        objectList.add(productMap);
        objectList.add(orderMap);


        sourceWidgetDto.getComponentDtos().forEach(sourceComponentDto -> {
            if(sourceComponentDto.getId().equalsIgnoreCase("customerId")){
                customerDto.setId(sourceComponentDto.getValue());
            } else if(sourceComponentDto.getId().equalsIgnoreCase("firstname")){
                customerDto.setFirstName(sourceComponentDto.getValue());
            } else if(sourceComponentDto.getId().equalsIgnoreCase("lastname")){
                customerDto.setLastName(sourceComponentDto.getValue());
            } else if(sourceComponentDto.getId().equalsIgnoreCase("addressline1")){
                customerDto.setAddressLine1(sourceComponentDto.getValue());
            } else if(sourceComponentDto.getId().equalsIgnoreCase("houseno")){
                customerDto.setHouseNo(sourceComponentDto.getValue());
            } else if(sourceComponentDto.getId().equalsIgnoreCase("addressline2")){
                customerDto.setAddressLine2(sourceComponentDto.getValue());
            } else if(sourceComponentDto.getId().equalsIgnoreCase("country")){
                customerDto.setCountry(sourceComponentDto.getValue());
            } else if(sourceComponentDto.getId().equalsIgnoreCase("state")){
                customerDto.setState(sourceComponentDto.getValue());
            } else if(sourceComponentDto.getId().equalsIgnoreCase("city")){
                customerDto.setCity(sourceComponentDto.getValue());
            } else if(sourceComponentDto.getId().equalsIgnoreCase("pincode")){
                customerDto.setPincode(sourceComponentDto.getValue());
            } else if(sourceComponentDto.getId().equalsIgnoreCase("phone1")){
                customerDto.setPhone1(sourceComponentDto.getValue());
            } else if(sourceComponentDto.getId().equalsIgnoreCase("email")){
                customerDto.setEmail(sourceComponentDto.getValue());
            }
        });

        if (customerId.isEmpty()){
            savedCustomerDto = customerService.save(customerDto);
        } else {
            savedCustomerDto = customerService.findById(Long.parseLong(customerId));
        }

        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("payment")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if (targetComponentDto.getId().equalsIgnoreCase("payment")){
                                targetComponentDto.setObjectList(objectList);
                            } else if(targetComponentDto.getId().equalsIgnoreCase("customerId")){
                                targetComponentDto.setValue(savedCustomerDto.getId());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("firstname")){
                                targetComponentDto.setValue(savedCustomerDto.getFirstName());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("lastname")){
                                targetComponentDto.setValue(savedCustomerDto.getLastName());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("addressline1")){
                                targetComponentDto.setValue(savedCustomerDto.getAddressLine1());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("houseno")){
                                targetComponentDto.setValue(savedCustomerDto.getHouseNo());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("addressline2")){
                                targetComponentDto.setValue(savedCustomerDto.getAddressLine2());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("country")){
                                targetComponentDto.setValue(savedCustomerDto.getCountry());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("state")){
                                targetComponentDto.setValue(savedCustomerDto.getState());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("city")){
                                targetComponentDto.setValue(savedCustomerDto.getCity());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("pincode")){
                                targetComponentDto.setValue(savedCustomerDto.getPincode());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("phone1")){
                                targetComponentDto.setValue(savedCustomerDto.getPhone1());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("email")){
                                targetComponentDto.setValue(savedCustomerDto.getEmail());
                            }
                        });
                    }
                });
            }
        });

        Map<String, Object> customerMap = oMapper.convertValue(savedCustomerDto, Map.class);
        if (otpMatched.equalsIgnoreCase("true")) {
            objectList.add(createPaymentOption(ordersDto));
            objectList.add(customerMap);
        } if (sendMail.equalsIgnoreCase("true")){
            sendMail(ordersDto, orderMap, productDto, productMap, savedCustomerDto, customerMap);
        }
    }

    public static void main(String args[]){
        //sendMail(ordersDto, orderMap, productDto, productMap, savedCustomerDto, customerMap);
    }

    private void sendMail(OrdersDto ordersDto, Map<String, Object> orderMap,
                          ProductDto productDto, Map<String, Object> productMap,
                          CustomerDto customerDto, Map<String, Object> customerMap){
        String host="smtp.gmail.com";
        final String user="srinidhinsn@gmail.com";//change accordingly
        final String password="nsnmay.12345";//change accordingly

        String to=customerDto.getEmail();//change accordingly

        //Get the session object
        Properties properties = new Properties();
        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Order confirmation#"+ordersDto.getId());
            message.setText(orderMap.entrySet().toString());

            //send the message
            // Used to debug SMTP issues
            session.setDebug(true);
            Transport.send(message);

            System.out.println("message sent successfully...");

        } catch (Exception e) {e.printStackTrace();}
    }

    private Map<String, Object> createPaymentOption(OrdersDto orders){
        JSONObject options = new JSONObject();
        options.put("amount", orders.getFinalPrice().multiply(new BigDecimal(100)) .intValue()); // Note: The amount should be in paise.
        options.put("currency", "INR");
        options.put("receipt", orders.getId().toString());
        options.put("payment_capture", 1);
        Map<String, Object> map = new HashMap<>();
        map.put("amount", orders.getFinalPrice().intValue());
        map.put("currency", "INR");
        map.put("receipt", orders.getId().toString());

        map.put("payment_capture", 1);
        map.put("apiKey", ConfirmProductAction.apiKey);
        map.put("secretKey", ConfirmProductAction.secretKey);
        map.put("smsApiKey", ConfirmProductAction.smsApiKey);
        try {
            RazorpayClient razorpayClient = new RazorpayClient(ConfirmProductAction.apiKey,
                    ConfirmProductAction.secretKey);
            Order order = razorpayClient.Orders.create(options);
            map.put("orderId", (String) order.get("id"));
        } catch (RazorpayException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }
}
