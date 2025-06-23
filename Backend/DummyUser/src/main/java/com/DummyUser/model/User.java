package com.DummyUser.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "UserData")
public class User {
	@Id
    private Long id;

    private String firstName;
    private String lastName;
    private String maidenName;
    private Integer age;
    private String gender;
    private String email;
    private String phone;
    private String image;

    private String city;
    private String state;
    private String country;

    private String companyName;
    private String department;
    private String title;

    private String university;
    private String role;

}
