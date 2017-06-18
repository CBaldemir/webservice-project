package com.example.comer.myproject.Models;

import android.graphics.Bitmap;

/**
 * Created by comer on 15.06.2017.
 */
public class Items2 {
    private String header;
    private int newsId;
    private String content;
    private String tekrar;
    private Bitmap bitmap;
    private String author;
    private String photo;

    public void setheader(String header){

        this.header = header;
    }
    public String getheader(){

        return this.header;
    }
    public void setnewsId(int newsId){

        this.newsId = newsId;
    }
    public int getnewsId(){

        return this.newsId;
    }
    public void setcontent(String content){

        this.content = content;
    }
    public String getcontent(){

        return this.content;
    }
    public void setBitmap(Bitmap bitmap){

        this.bitmap = bitmap;
    }
    public Bitmap getBitmap(){

        return this.bitmap;
    }
    public void setauthor(String author){

        this.author = author;
    }
    public String getauthor(){

        return this.author;
    }

    public void setPhoto(String photo){
        this.photo = photo;
    }
    public String getPhoto(){

        return this.photo;
    }

}


