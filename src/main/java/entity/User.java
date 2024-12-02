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
    @GenericGenerator(name = "native")
    private int id;

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
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return userName;
    }
}
