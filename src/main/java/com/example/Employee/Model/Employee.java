package com.example.Employee.Model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Employee {



        @Id//idd
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        private String emailId;


        private String name;


        private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Version // ✅ This field tracks changes
    private int version;





    }

