package com.liwy.server.entity;

import javax.persistence.*;

/**
 * Created by admin on 2017/7/8.
 */
@Entity
@Table(name = "tb_people")
public class People {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(unique=true, nullable=false)
    public int id;

    @Column(name = "father")
    private String father;

    @Column(name = "mather")
    private String mather;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMather() {
        return mather;
    }

    public void setMather(String mather) {
        this.mather = mather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
