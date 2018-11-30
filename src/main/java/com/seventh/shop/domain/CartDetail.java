package com.seventh.shop.domain;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class CartDetail {
    private String shopName;//店铺名字
    private String proName;//商品标题
    private int productId;//商品id
    //private String宝贝规格
    private String price;//商品价格
    private String productAmount;//商品数量

    public CartDetail() {

    }

    public CartDetail(String shopName, String proName, int productId, String price, String productAmount) {
        this.shopName = shopName;
        this.proName = proName;
        this.productId = productId;
        this.price = price;
        this.productAmount = productAmount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(String productAmount) {
        this.productAmount = productAmount;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProduct_amount() {
        return productAmount;
    }

    public void setProduct_amount(String product_amount) {
        this.productAmount = product_amount;
    }
}
