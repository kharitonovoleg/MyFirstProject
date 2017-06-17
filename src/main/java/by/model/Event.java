package by.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;


@Entity
@Table(name = "event", schema = "first_project")
public class Event {
    private int id;
    private String eventName;
    private byte[] text;
    private String type;
    private String city;
    private String street;
    private int building;
    private String buildingIndex;
    private String mobilePhone;
    private String phone;
    private Time eventStartTime;
    private Date date;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "eventName")
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Basic
    @Column(name = "text")
    public byte[] getText() {
        return text;
    }

    public void setText(byte[] text) {
        this.text = text;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "building")
    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    @Basic
    @Column(name = "buildingIndex")
    public String getBuildingIndex() {
        return buildingIndex;
    }

    public void setBuildingIndex(String buildingIndex) {
        this.buildingIndex = buildingIndex;
    }

    @Basic
    @Column(name = "mobilePhone")
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "eventStartTime")
    public Time getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(Time eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (building != event.building) return false;
        if (eventName != null ? !eventName.equals(event.eventName) : event.eventName != null) return false;
        if (!Arrays.equals(text, event.text)) return false;
        if (type != null ? !type.equals(event.type) : event.type != null) return false;
        if (city != null ? !city.equals(event.city) : event.city != null) return false;
        if (street != null ? !street.equals(event.street) : event.street != null) return false;
        if (buildingIndex != null ? !buildingIndex.equals(event.buildingIndex) : event.buildingIndex != null)
            return false;
        if (mobilePhone != null ? !mobilePhone.equals(event.mobilePhone) : event.mobilePhone != null) return false;
        if (phone != null ? !phone.equals(event.phone) : event.phone != null) return false;
        if (eventStartTime != null ? !eventStartTime.equals(event.eventStartTime) : event.eventStartTime != null)
            return false;
        if (date != null ? !date.equals(event.date) : event.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(text);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + building;
        result = 31 * result + (buildingIndex != null ? buildingIndex.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (eventStartTime != null ? eventStartTime.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
