package com.flex.domain;

import java.util.Date;

public class ListPlan {
    private Integer listId;
    private String listObj;
    private String listName;
    private Date listTime;
    private String listUnit;
    private String listGrade;

    public ListPlan(Integer listId, String listObj, String listName, Date listTime, String listUnit, String listGrade) {
        this.listId = listId;
        this.listObj = listObj;
        this.listName = listName;
        this.listTime = listTime;
        this.listUnit = listUnit;
        this.listGrade = listGrade;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public String getListObj() {
        return listObj;
    }

    public void setListObj(String listObj) {
        this.listObj = listObj;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public Date getListTime() {
        return listTime;
    }

    public void setListTime(Date listTime) {
        this.listTime = listTime;
    }

    public String getListUnit() {
        return listUnit;
    }

    public void setListUnit(String listUnit) {
        this.listUnit = listUnit;
    }

    public String getListGrade() {
        return listGrade;
    }

    public void setListGrade(String listGrade) {
        this.listGrade = listGrade;
    }

    @Override
    public String toString() {
        return "ListPlan{" +
                "listId=" + listId +
                ", listObj='" + listObj + '\'' +
                ", listName='" + listName + '\'' +
                ", listTime=" + listTime +
                ", listUnit='" + listUnit + '\'' +
                ", listGrade='" + listGrade + '\'' +
                '}';
    }

    public ListPlan() {
    }

}
