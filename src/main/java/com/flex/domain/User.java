package com.flex.domain;


public class User {
    private Integer userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private Integer alterSign;
    private String unit;
    private String grade;
    private String major;
    private String classes;
    private String politics;
    private String type;
    private String user_ad_name;
    private String phone;
    private String email;
    private String remark;

    public User(Integer userId, String userName, String userAccount, String userPassword, Integer alterSign, String unit, String grade, String major, String classes, String politics, String type, String user_ad_name, String phone, String email, String remark) {
        this.userId = userId;
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.alterSign = alterSign;
        this.unit = unit;
        this.grade = grade;
        this.major = major;
        this.classes = classes;
        this.politics = politics;
        this.type = type;
        this.user_ad_name = user_ad_name;
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

    public Integer getAlterSign() {
        return alterSign;
    }

    public void setAlterSign(Integer alterSign) {
        this.alterSign = alterSign;
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

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_ad_name() {
        return user_ad_name;
    }

    public void setUser_ad_name(String user_ad_name) {
        this.user_ad_name = user_ad_name;
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
                ", alterSign=" + alterSign +
                ", unit='" + unit + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", classes='" + classes + '\'' +
                ", politics='" + politics + '\'' +
                ", type='" + type + '\'' +
                ", user_ad_name='" + user_ad_name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public User() {
    }


}
