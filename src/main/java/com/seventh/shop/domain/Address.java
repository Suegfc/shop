package com.seventh.shop.domain;

import javax.persistence.*;

@Entity
@Table(name = "readdress")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20,nullable = true)
    private String rname;
    private String rphone;
    @Column(length = 150)
    private String address;
    @Column(length = 20)
    private int uid;
    private int detype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRphone() {
        return rphone;
    }

    public void setRphone(String rphone) {
        this.rphone = rphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        
        this.address = address;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getDetype() {
        return detype;
    }

    public void setDetype(int detype) {
        this.detype = detype;
    }

}
