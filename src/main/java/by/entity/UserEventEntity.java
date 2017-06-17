package by.entity;

public class UserEventEntity extends ModelEntity {

    private int userId;
    private int eventId;

    public UserEventEntity(int userId, int eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    public UserEventEntity() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "UserEventEntity{" + "id= " + id + ", userId=" + userId + ", eventId= " + eventId + "}";
    }
}
