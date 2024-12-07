package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * Represents a user who is logged in
 */
@Entity
@Table(name = "users")
public class User {
    @Column(name = "user_name")
    private String userName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "user_id")
    private int user_id;

    /**
     * Empty constructor
     */
    public User() {

    }

    /**
     * Builds a new user
     *
     * @param userName the username
     */
    public User(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user_id.
     *
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Sets user_id.
     *
     * @param user_id the user_id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String toString() {
        return userName;
    }
}
