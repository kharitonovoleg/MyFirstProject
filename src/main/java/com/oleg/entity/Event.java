package com.oleg.entity;

import java.sql.Time;
import java.util.Date;

public class Event extends Model {

    private String eventName;
    private String text;
    private String type;
    private String city;
    private String street;
    private String mobilePhone;
    private String phone;
    private Time eventStartTime;
    private Date date;

    public Event(String eventName, String text, String type, String city, String street, String mobilePhone, String phone, Time eventStartTime, Date date) {
        this.eventName = eventName;
        this.text = text;
        this.type = type;
        this.city = city;
        this.street = street;
        this.mobilePhone = mobilePhone;
        this.phone = phone;
        this.eventStartTime = eventStartTime;
        this.date = date;
    }

    public Event() {
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Time getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(Time eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "com.oleg.Controller.EventController{" +
                "id=" + id +
                ", eventName= " + eventName +
                ", text= " + text +
                ", type= " + type +
                ", city= " + city +
                ", street= " + street +
                ", mobilePhone= " + mobilePhone +
                ", phone= " + phone +
                ", eventStartTime= " + eventStartTime +
                ", date= " + date +
                "}";
    }
}
