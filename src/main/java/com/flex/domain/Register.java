package com.flex.domain;


import java.util.Date;

public class Register {
    private Integer registerId;
    private Integer uType;
    private String registerName;
    private String registerClasses;
    private String registerUnit;
    private String registerNumber;
    private String politics;
    private Date startTime;
    private Date endTime;
    private Integer form;
    private String instructor;
    private String project;
    private String praUnit;
    private String registerLocation;
    private String unitAttribute;
    private String head;
    private String headPhone;
    private String headEmail;
    private String item;
    private String registerStatus;
    private String unitMajor;
    private String objIntro;
    private Date registerLogTime;
    private String registerLog;
    private Integer registerState;
    private Integer registerMark;

    public Register() {
    }

    public Register(Integer registerId, Integer uType, String registerName, String registerClasses, String registerUnit, String registerNumber, String politics, Date startTime, Date endTime, Integer form, String instructor, String project, String praUnit, String registerLocation, String unitAttribute, String head, String headPhone, String headEmail, String item, String registerStatus, String unitMajor, String objIntro, Date registerLogTime, String registerLog, Integer registerState, Integer registerMark) {
        this.registerId = registerId;
        this.uType = uType;
        this.registerName = registerName;
        this.registerClasses = registerClasses;
        this.registerUnit = registerUnit;
        this.registerNumber = registerNumber;
        this.politics = politics;
        this.startTime = startTime;
        this.endTime = endTime;
        this.form = form;
        this.instructor = instructor;
        this.project = project;
        this.praUnit = praUnit;
        this.registerLocation = registerLocation;
        this.unitAttribute = unitAttribute;
        this.head = head;
        this.headPhone = headPhone;
        this.headEmail = headEmail;
        this.item = item;
        this.registerStatus = registerStatus;
        this.unitMajor = unitMajor;
        this.objIntro = objIntro;
        this.registerLogTime = registerLogTime;
        this.registerLog = registerLog;
        this.registerState = registerState;
        this.registerMark = registerMark;
    }

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public Integer getuType() {
        return uType;
    }

    public void setuType(Integer uType) {
        this.uType = uType;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getRegisterClasses() {
        return registerClasses;
    }

    public void setRegisterClasses(String registerClasses) {
        this.registerClasses = registerClasses;
    }

    public String getRegisterUnit() {
        return registerUnit;
    }

    public void setRegisterUnit(String registerUnit) {
        this.registerUnit = registerUnit;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getForm() {
        return form;
    }

    public void setForm(Integer form) {
        this.form = form;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getPraUnit() {
        return praUnit;
    }

    public void setPraUnit(String praUnit) {
        this.praUnit = praUnit;
    }

    public String getRegisterLocation() {
        return registerLocation;
    }

    public void setRegisterLocation(String registerLocation) {
        this.registerLocation = registerLocation;
    }

    public String getUnitAttribute() {
        return unitAttribute;
    }

    public void setUnitAttribute(String unitAttribute) {
        this.unitAttribute = unitAttribute;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHeadPhone() {
        return headPhone;
    }

    public void setHeadPhone(String headPhone) {
        this.headPhone = headPhone;
    }

    public String getHeadEmail() {
        return headEmail;
    }

    public void setHeadEmail(String headEmail) {
        this.headEmail = headEmail;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus;
    }

    public String getUnitMajor() {
        return unitMajor;
    }

    public void setUnitMajor(String unitMajor) {
        this.unitMajor = unitMajor;
    }

    public String getObjIntro() {
        return objIntro;
    }

    public void setObjIntro(String objIntro) {
        this.objIntro = objIntro;
    }

    public Date getRegisterLogTime() {
        return registerLogTime;
    }

    public void setRegisterLogTime(Date registerLogTime) {
        this.registerLogTime = registerLogTime;
    }

    public String getRegisterLog() {
        return registerLog;
    }

    public void setRegisterLog(String registerLog) {
        this.registerLog = registerLog;
    }

    public Integer getRegisterState() {
        return registerState;
    }

    public void setRegisterState(Integer registerState) {
        this.registerState = registerState;
    }

    public Integer getRegisterMark() {
        return registerMark;
    }

    public void setRegisterMark(Integer registerMark) {
        this.registerMark = registerMark;
    }

    @Override
    public String toString() {
        return "Register{" +
                "registerId=" + registerId +
                ", uType=" + uType +
                ", registerName='" + registerName + '\'' +
                ", registerClasses='" + registerClasses + '\'' +
                ", registerUnit='" + registerUnit + '\'' +
                ", registerNumber='" + registerNumber + '\'' +
                ", politics='" + politics + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", form=" + form +
                ", instructor='" + instructor + '\'' +
                ", project='" + project + '\'' +
                ", praUnit='" + praUnit + '\'' +
                ", registerLocation='" + registerLocation + '\'' +
                ", unitAttribute='" + unitAttribute + '\'' +
                ", head='" + head + '\'' +
                ", headPhone='" + headPhone + '\'' +
                ", headEmail='" + headEmail + '\'' +
                ", item='" + item + '\'' +
                ", registerStatus='" + registerStatus + '\'' +
                ", unitMajor='" + unitMajor + '\'' +
                ", objIntro='" + objIntro + '\'' +
                ", registerLogTime=" + registerLogTime +
                ", registerLog='" + registerLog + '\'' +
                ", registerState=" + registerState +
                ", registerMark=" + registerMark +
                '}';
    }
}
