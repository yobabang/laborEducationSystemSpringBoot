package com.flex.domain;

public class Assessment {
    private Integer assId;
    private String assName;
    private String assNumber;
    private String assClasses;
    private String assMajor;
    private String assUnit;
    private String assInstructor;
    private String assDep;
    private Integer assGrade;
    private String assOpi;

    public Assessment(Integer assId, String assName, String assNumber, String assClasses, String assMajor, String assUnit, String assInstructor, String assDep, Integer assGrade, String assOpi) {
        this.assId = assId;
        this.assName = assName;
        this.assNumber = assNumber;
        this.assClasses = assClasses;
        this.assMajor = assMajor;
        this.assUnit = assUnit;
        this.assInstructor = assInstructor;
        this.assDep = assDep;
        this.assGrade = assGrade;
        this.assOpi = assOpi;
    }

    public Integer getAssId() {
        return assId;
    }

    public void setAssId(Integer assId) {
        this.assId = assId;
    }

    public String getAssName() {
        return assName;
    }

    public void setAssName(String assName) {
        this.assName = assName;
    }

    public String getAssNumber() {
        return assNumber;
    }

    public void setAssNumber(String assNumber) {
        this.assNumber = assNumber;
    }

    public String getAssClasses() {
        return assClasses;
    }

    public void setAssClasses(String assClasses) {
        this.assClasses = assClasses;
    }

    public String getAssMajor() {
        return assMajor;
    }

    public void setAssMajor(String assMajor) {
        this.assMajor = assMajor;
    }

    public String getAssUnit() {
        return assUnit;
    }

    public void setAssUnit(String assUnit) {
        this.assUnit = assUnit;
    }

    public String getAssInstructor() {
        return assInstructor;
    }

    public void setAssInstructor(String assInstructor) {
        this.assInstructor = assInstructor;
    }

    public String getAssDep() {
        return assDep;
    }

    public void setAssDep(String assDep) {
        this.assDep = assDep;
    }

    public Integer getAssGrade() {
        return assGrade;
    }

    public void setAssGrade(Integer assGrade) {
        this.assGrade = assGrade;
    }

    public String getAssOpi() {
        return assOpi;
    }

    public void setAssOpi(String assOpi) {
        this.assOpi = assOpi;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "assId=" + assId +
                ", assName='" + assName + '\'' +
                ", assNumber='" + assNumber + '\'' +
                ", assClasses='" + assClasses + '\'' +
                ", assMajor='" + assMajor + '\'' +
                ", assUnit='" + assUnit + '\'' +
                ", assInstructor='" + assInstructor + '\'' +
                ", assDep='" + assDep + '\'' +
                ", assGrade=" + assGrade +
                ", assOpi='" + assOpi + '\'' +
                '}';
    }

    public Assessment() {
    }



}
