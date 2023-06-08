package com.flex.domain;

import java.util.Date;

public class Log {
    private Integer logId;
    private Integer logType;
    private Integer userNumber;
    private Integer uType;
    private String logName;
    private String logUnit;
    private String logClasses;
    private String logContent;
    private String location;
    private String logProcess;
    private String effect;
    private String result;
    private Date logTime;
    private String logScore;
    private Integer logState;
    private Integer logMark;

    public Log(Integer logId, Integer logType, Integer userNumber, Integer uType, String logName, String logUnit, String logClasses, String logContent, String location, String logProcess, String effect, String result, Date logTime, String logScore, Integer logState, Integer logMark) {
        this.logId = logId;
        this.logType = logType;
        this.userNumber = userNumber;
        this.uType = uType;
        this.logName = logName;
        this.logUnit = logUnit;
        this.logClasses = logClasses;
        this.logContent = logContent;
        this.location = location;
        this.logProcess = logProcess;
        this.effect = effect;
        this.result = result;
        this.logTime = logTime;
        this.logScore = logScore;
        this.logState = logState;
        this.logMark = logMark;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public Integer getuType() {
        return uType;
    }

    public void setuType(Integer uType) {
        this.uType = uType;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogUnit() {
        return logUnit;
    }

    public void setLogUnit(String logUnit) {
        this.logUnit = logUnit;
    }

    public String getLogClasses() {
        return logClasses;
    }

    public void setLogClasses(String logClasses) {
        this.logClasses = logClasses;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLogProcess() {
        return logProcess;
    }

    public void setLogProcess(String logProcess) {
        this.logProcess = logProcess;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogScore() {
        return logScore;
    }

    public void setLogScore(String logScore) {
        this.logScore = logScore;
    }

    public Integer getLogState() {
        return logState;
    }

    public void setLogState(Integer logState) {
        this.logState = logState;
    }

    public Integer getLogMark() {
        return logMark;
    }

    public void setLogMark(Integer logMark) {
        this.logMark = logMark;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", logType=" + logType +
                ", userNumber=" + userNumber +
                ", uType=" + uType +
                ", logName='" + logName + '\'' +
                ", logUnit='" + logUnit + '\'' +
                ", logClasses='" + logClasses + '\'' +
                ", logContent='" + logContent + '\'' +
                ", location='" + location + '\'' +
                ", logProcess='" + logProcess + '\'' +
                ", effect='" + effect + '\'' +
                ", result='" + result + '\'' +
                ", logTime=" + logTime +
                ", logScore='" + logScore + '\'' +
                ", logState=" + logState +
                ", logMark=" + logMark +
                '}';
    }

    public Log() {
    }


}
