package com.jjis.example.entity;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String fullName;
    private String mobile;
    private String memberType;

    // Instead of the following, we can use Lombok to generate getters and setters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFullName() { return fullName; }
    public String getMobile() { return mobile; }
    public String getMemberType() { return memberType; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public void setMemberType(String memberType) { this.memberType = memberType; }
}