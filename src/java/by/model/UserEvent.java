package by.model;

import javax.persistence.*;


@Entity
@Table(name = "user_event", schema = "first_project")
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    @Column(name = "userId")
    private int userId;

    @Basic
    @Column(name = "eventId")
    private int eventId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEvent userEvent = (UserEvent) o;

        if (id != userEvent.id) return false;
        if (userId != userEvent.userId) return false;
        if (eventId != userEvent.eventId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + eventId;
        return result;
    }
}
