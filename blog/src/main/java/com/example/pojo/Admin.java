package com.example.pojo;

public class Admin {
    private String adminname;
    private String adminpassword;

    public Admin(String adminname) {
        this.adminname = adminname;
    }

    public Admin() {
    }

    public String getAdminname() {
        return adminname;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }
}
