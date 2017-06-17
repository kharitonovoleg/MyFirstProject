package by.model;

import javax.persistence.*;


@Entity
@Table(name = "users_base", schema = "first_project")
public class UsersBase {
    private int id;
    private int userId;
    private int userEventId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "userEventId")
    public int getUserEventId() {
        return userEventId;
    }

    public void setUserEventId(int userEventId) {
        this.userEventId = userEventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersBase usersBase = (UsersBase) o;

        if (id != usersBase.id) return false;
        if (userId != usersBase.userId) return false;
        if (userEventId != usersBase.userEventId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + userEventId;
        return result;
    }
}
