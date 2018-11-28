package com.seventh.shop.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int tid;
    @Column(name = "proName",length = 100)
    private String proName;
    @Column(length = 10)
    private String unit;
    @Column(length = 20)
    private String price;
    @Column(name = "proDetail")
    private String proDetail;
    @Column
    private String text;
    @Column(name = "proCount")
    private int proCount;
    @Column
    private int shopid;

    @OneToMany(mappedBy = "product",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Proimage> proimage;

    public Product() {
    }

    public List<Proimage> getProimage() {
        return proimage;
    }

    public void setProimage(List<Proimage> proimage) {
        this.proimage = proimage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProDetail() {
        return proDetail;
    }

    public void setProDetail(String proDetail) {
        this.proDetail = proDetail;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getProCount() {
        return proCount;
    }

    public void setProCount(int proCount) {
        this.proCount = proCount;
    }

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }
}
