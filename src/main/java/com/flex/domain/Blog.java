package com.flex.domain;

import java.util.Date;

public class Blog {
    private Integer blogId;
    private String blogTitle;
    private String blogContent;
    private String auName;
    private Date releaseTime;
    private String label;
    private Integer blogRead;
    private Integer likes;
    private Integer comments;
    private String fileAdd;
    private Integer blogState;
    private Date saveTime;

    public Blog() {
    }

    public Blog(Integer blogId, String blogTitle, String blogContent, String auName, Date releaseTime, String label, Integer blogRead, Integer likes, Integer comments, String fileAdd, Integer blogState, Date saveTime) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.auName = auName;
        this.releaseTime = releaseTime;
        this.label = label;
        this.blogRead = blogRead;
        this.likes = likes;
        this.comments = comments;
        this.fileAdd = fileAdd;
        this.blogState = blogState;
        this.saveTime = saveTime;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getAuName() {
        return auName;
    }

    public void setAuName(String auName) {
        this.auName = auName;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getBlogRead() {
        return blogRead;
    }

    public void setBlogRead(Integer blogRead) {
        this.blogRead = blogRead;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public String getFileAdd() {
        return fileAdd;
    }

    public void setFileAdd(String fileAdd) {
        this.fileAdd = fileAdd;
    }

    public Integer getBlogState() {
        return blogState;
    }

    public void setBlogState(Integer blogState) {
        this.blogState = blogState;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", auName='" + auName + '\'' +
                ", releaseTime=" + releaseTime +
                ", label='" + label + '\'' +
                ", blogRead=" + blogRead +
                ", likes=" + likes +
                ", comments=" + comments +
                ", fileAdd='" + fileAdd + '\'' +
                ", blogState=" + blogState +
                ", saveTime=" + saveTime +
                '}';
    }
}
