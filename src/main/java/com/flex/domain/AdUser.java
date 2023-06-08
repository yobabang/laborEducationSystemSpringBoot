package com.flex.domain;

public class AdUser {
    private String adName;
    private String adAccount;
    private String adPassword;
    private Integer obj;
    private Integer alterSign;
    private String adNumber;
    private String adClasses;
    private String adPhone;
    private String adEmail;
    private String remark;

    public AdUser() {
    }

    public AdUser(String adName, String adAccount, String adPassword, Integer obj, Integer alterSign, String adNumber, String adClasses, String adPhone, String adEmail, String remark) {
        this.adName = adName;
        this.adAccount = adAccount;
        this.adPassword = adPassword;
        this.obj = obj;
        this.alterSign = alterSign;
        this.adNumber = adNumber;
        this.adClasses = adClasses;
        this.adPhone = adPhone;
        this.adEmail = adEmail;
        this.remark = remark;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdAccount() {
        return adAccount;
    }

    public void setAdAccount(String adAccount) {
        this.adAccount = adAccount;
    }

    public String getAdPassword() {
        return adPassword;
    }

    public void setAdPassword(String adPassword) {
        this.adPassword = adPassword;
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

    public String getAdNumber() {
        return adNumber;
    }

    public void setAdNumber(String adNumber) {
        this.adNumber = adNumber;
    }

    public String getAdClasses() {
        return adClasses;
    }

    public void setAdClasses(String adClasses) {
        this.adClasses = adClasses;
    }

    public String getAdPhone() {
        return adPhone;
    }

    public void setAdPhone(String adPhone) {
        this.adPhone = adPhone;
    }

    public String getAdEmail() {
        return adEmail;
    }

    public void setAdEmail(String adEmail) {
        this.adEmail = adEmail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AdUser{" +
                "adName='" + adName + '\'' +
                ", adAccount='" + adAccount + '\'' +
                ", adPassword='" + adPassword + '\'' +
                ", obj=" + obj +
                ", alterSign=" + alterSign +
                ", adNumber='" + adNumber + '\'' +
                ", adClasses='" + adClasses + '\'' +
                ", adPhone='" + adPhone + '\'' +
                ", adEmail='" + adEmail + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
