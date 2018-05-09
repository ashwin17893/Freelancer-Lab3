package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private integer proj_id;

    private String proj_title;

    private String username;

    private integer bidamount;

    public String getProject() {
        return project;
    }

    public void set(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.proj_id = proj_id;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.proj_title = proj_title;
    }




}