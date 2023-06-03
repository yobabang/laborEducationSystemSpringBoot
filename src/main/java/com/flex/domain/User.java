package com.flex.domain;

public class User {
    private Integer userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private Integer obj;
    private Integer alterSign;
    private String idNumber;
    private String unit;
    private String grade;
    private String major;
    private String classes;
    private String phone;
    private String email;
    private String remark;

    public User() {
    }

    public User(Integer userId, String userName, String userAccount, String userPassword, Integer obj, Integer alterSign, String idNumber, String unit, String grade, String major, String classes, String phone, String email, String remark) {
        this.userId = userId;
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.obj = obj;
        this.alterSign = alterSign;
        this.idNumber = idNumber;
        this.unit = unit;
        this.grade = grade;
        this.major = major;
        this.classes = classes;
        this.phone = phone;
        this.email = email;
        this.remark = remark;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getObj() {
        return obj;
    }

    public void setObj(Integer obj) {
        this.obj = obj;
    }

    public Integer getAlterSign() {
        return alterSign;
    }

    public void setAlterSign(Integer alterSign) {
        this.alterSign = alterSign;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", obj=" + obj +
                ", alterSign=" + alterSign +
                ", idNumber='" + idNumber + '\'' +
                ", unit='" + unit + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", classes='" + classes + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
