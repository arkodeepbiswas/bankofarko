package models;

import io.ebean.Finder;

import javax.persistence.*;

@Entity(name = "user_password")
public class UserPassword {

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }


    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

    @Column(name = "pswd")
    private String pswd;


    public static final Finder<Integer, UserPassword> find = new Finder<>(UserPassword.class);

}
