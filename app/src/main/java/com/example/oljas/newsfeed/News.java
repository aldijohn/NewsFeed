package com.example.oljas.newsfeed;

/**
 * Created by oljas on 29.05.2016.
 */
public class News {
    private int _id;
    private String title;
    private String date;
    private String text;
    private String sourceurl;
    private String category;

public News(){}
    public News(String title, String date, String text, String sourceurl, String category) {
        this.title = title;
        this.date = date;
        this.text = text;
        this.sourceurl = sourceurl;
        this.category= category;
    }


    public void set_id(int _id) {
        this._id = _id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getSourceurl() {
        return sourceurl;
    }

    public String getCategory() {
        return category;
    }
}
