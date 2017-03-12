package com.oleg.first;

import java.util.Date;

public class News extends Model {

    private String header;
    private String text;
    private Date date;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "News{" + "id=" + id + ", header= " + header + ", text= " + text + ", date= " + date + "}";
    }
}
