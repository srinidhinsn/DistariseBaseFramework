package com.distarise.base.entity.amruthhani;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "HEADER")
    private String header;

    @Column(name = "SUBHEADER")
    private String subHeader;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "SUBCATEGORY")
    private String subCategory;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "SUBTYPE")
    private String subType;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "GST")
    private BigDecimal gst;

    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    @Column(name = "DELIVERYCHARGES", columnDefinition="Decimal(10,2) default '0.00'")
    private BigDecimal deliveryCharges;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getGst() {
        return gst;
    }

    public void setGst(BigDecimal gst) {
        this.gst = gst;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(BigDecimal deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public Product(String id, String header, String subHeader, String image, Integer quantity,
                   BigDecimal price, String category, String subCategory, String type,
                   String subType, String description, BigDecimal gst, BigDecimal discount,
                   BigDecimal deliveryCharges) {
        this.id = id;
        this.header = header;
        this.subHeader = subHeader;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.subCategory = subCategory;
        this.type = type;
        this.subType = subType;
        this.description = description;
        this.gst = gst;
        this.discount = discount;
        this.deliveryCharges = deliveryCharges;
    }

    public Product() {
    }
}
