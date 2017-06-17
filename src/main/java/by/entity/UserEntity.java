package by.entity;

public class UserEntity extends ModelEntity {

    private String nickname;
    private String firstName;
    private String secondName;
    private String password;
    private String email;

    public UserEntity(String nickname, String firstName, String secondName, String password, String email) {
        this.nickname = nickname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.email = email;
    }

    public UserEntity() {
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id= " + id +
                ", nickname= " + nickname +
                ", firstName= " + firstName +
                ", secondName= " + secondName +
                ", password= " + password +
                ", email= " + email +
                "}";
    }
}
