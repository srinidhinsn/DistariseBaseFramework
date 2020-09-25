package com.distarise.base.entity.amruthhani;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable {
    @Id
    @SequenceGenerator(name = "orderId", initialValue = 1000, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderId")
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRODUCTID")
    private String productId;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "ORDEREDDATE")
    private Date orderedDate;

    @Column(name = "DELIVEREDDATE")
    private Date deliveredDate;

    @Column(name = "DELIVERYDATE")
    private Date deliveryDate;

    @Column(name = "DELIVERYCHARGES")
    private BigDecimal deliveryCharges;

    @Column(name = "TOTALGST")
    private BigDecimal totalGst;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "FINALPRICE")
    private BigDecimal finalPrice;

    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    @Column(name = "CUSTOMERID")
    private Long customerId;

    @Column(name = "PAYMENTID")
    private String paymentId;

    @Column(name = "SIGNATURE")
    private String signature;

    @Column(name = "RECEIPTID")
    private String receiptId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public BigDecimal getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(BigDecimal deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public BigDecimal getTotalGst() {
        return totalGst;
    }

    public void setTotalGst(BigDecimal totalGst) {
        this.totalGst = totalGst;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }
}
