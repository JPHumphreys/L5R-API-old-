package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    String userid;

    String password;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
