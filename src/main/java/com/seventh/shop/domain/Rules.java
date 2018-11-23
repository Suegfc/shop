package com.seventh.shop.domain;

import javax.persistence.*;

/**
 * @author gfc
 * 2018年11月23日 下午 8:24
 */
@Entity
@Table(name = "rules")
public class Rules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int aid;

    @Column(length = 100)
    private String rule;

    public Rules() {
    }

    public Rules(int aid, String rule) {
        this.aid = aid;
        this.rule = rule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
