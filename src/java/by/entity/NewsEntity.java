package by.entity;

import java.util.Date;

public class NewsEntity extends ModelEntity {

    private String header;
    private String text;
    private Date date;

    public NewsEntity(String header, String text, Date date) {
        this.header = header;
        this.text = text;
        this.date = date;
    }

    public NewsEntity() {
    }

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
        return "NewsEntity{" + "id=" + id + ", header= " + header + ", text= " + text + ", date= " + date + "}";
    }
}
