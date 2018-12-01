package com.seventh.shop.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "proimage")
public class Proimage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imgurl;
    private String imgdesc;
    private int pid;

    @ManyToOne
    @JoinColumn(name="pid",insertable = false,updatable = false)//设置在proimage表中的关联字段(外键)
    private Product product;

    public Proimage() {
    }

    @JsonBackReference
    public Product getProduct() {
        return product;
    }

    @JsonBackReference
    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getImgdesc() {
        return imgdesc;
    }

    public void setImgdesc(String imgdesc) {
        this.imgdesc = imgdesc;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
