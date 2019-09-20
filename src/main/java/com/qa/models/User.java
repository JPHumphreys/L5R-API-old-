package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    String userid;

    String userpassword;
}
