package com.flex.domain;


import java.util.Date;

public class RegisterReport {
    private Integer reportId;
    private String report;
    private Date reportTime;
    private Integer reportState;
    private String reportScore;
    private Integer reportMark;

    @Override
    public String toString() {
        return "RegisterReport{" +
                "reportId=" + reportId +
                ", report='" + report + '\'' +
                ", reportTime=" + reportTime +
                ", reportState=" + reportState +
                ", reportScore='" + reportScore + '\'' +
                ", reportMark=" + reportMark +
                '}';
    }

    public RegisterReport() {
    }

    public RegisterReport( Integer reportId, String report, Date reportTime, Integer reportState, String reportScore, Integer reportMark) {
        this.reportId = reportId;
        this.report = report;
        this.reportTime = reportTime;
        this.reportState = reportState;
        this.reportScore = reportScore;
        this.reportMark = reportMark;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Integer getReportState() {
        return reportState;
    }

    public void setReportState(Integer reportState) {
        this.reportState = reportState;
    }

    public String getReportScore() {
        return reportScore;
    }

    public void setReportScore(String reportScore) {
        this.reportScore = reportScore;
    }

    public Integer getReportMark() {
        return reportMark;
    }

    public void setReportMark(Integer reportMark) {
        this.reportMark = reportMark;
    }


}
