package DTO;

import java.util.Date;
import java.util.Objects;

public class Article {
    private int articleID;
    private String title;
    private String body;
    private String author;
    private Date createdOn;
    private Date postOn;
    private Date expiredOn;

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getPostOn() {
        return postOn;
    }

    public void setPostOn(Date postOn) {
        this.postOn = postOn;
    }

    public Date getExpiredOn() {
        return expiredOn;
    }

    public void setExpiredOn(Date expiredOn) {
        this.expiredOn = expiredOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return articleID == article.articleID && title.equals(article.title) && body.equals(article.body) && author.equals(article.author) && createdOn.equals(article.createdOn) && postOn.equals(article.postOn) && expiredOn.equals(article.expiredOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleID, title, body, author, createdOn, postOn, expiredOn);
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleID=" + articleID +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", createdOn=" + createdOn +
                ", postOn=" + postOn +
                ", expiredOn=" + expiredOn +
                '}';
    }
}
