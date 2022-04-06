package com.distarise.distabank.deposit.model;

import javax.servlet.http.HttpServletRequest;

public class DistabankContext {
    public static final String DISTABANK_CONTEXT = "distabankContext";
    private Long customerId;
    private String customerName;
    private String clientId;
    private String fdAccountNo;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFdAccountNo() {
        return fdAccountNo;
    }

    public void setFdAccountNo(String fdAccountNo) {
        this.fdAccountNo = fdAccountNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    private DistabankContext() {
        this.customerId = 0L;
        this.clientId = "";
        this.fdAccountNo = "";
        this.customerName = "";
    }

    public static DistabankContext getDistabankContext(HttpServletRequest request, String clientId) {
        String customerId = request.getParameter("customerId");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String fdAccountNo = request.getParameter("fdAccountNo");
        DistabankContext context = (DistabankContext) request.getSession().getAttribute(DistabankContext.DISTABANK_CONTEXT);

        if (null != context){
            if (null != customerId){
                context.setCustomerId(Long.parseLong(customerId));
            }
            if (null != fdAccountNo){
                context.setFdAccountNo(fdAccountNo);
            }
            if (null != firstName){
                if (null != lastName){
                    context.setCustomerName(firstName + " "+ lastName);
                } else {
                    context.setCustomerName(firstName);
                }
            }
        } else if (null == context && null != customerId){
            context = new DistabankContext();
            context.setCustomerId(Long.parseLong(customerId));
            request.getSession().setAttribute(DistabankContext.DISTABANK_CONTEXT, context);
        } else {
            context = new DistabankContext();
            request.getSession().setAttribute(DistabankContext.DISTABANK_CONTEXT, context);
        }

        context.setClientId(clientId);
        return context;
    }
}
