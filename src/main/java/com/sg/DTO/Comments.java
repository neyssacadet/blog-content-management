package com.sg.DTO;

public class Comments {
    private int commentsID;
    private String text;
    private String user;
    private String userEmail;
    private String addedOn;
    private int articleID;

    public int getCommentsID() {
        return commentsID;
    }

    public void setCommentsID(int commentsID) {
        this.commentsID = commentsID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }
}
