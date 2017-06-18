package com.example.comer.myproject.Models;

/**
 * Created by comer on 15.06.2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class retrofitnewsmodel {

    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("newsId")
    @Expose
    private Integer newsId;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

}