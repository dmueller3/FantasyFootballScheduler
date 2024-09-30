package entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

/**
 * Represents Fantasy Football Teams
 */
@Entity
@Table(name = "teams")
public class TeamNames {
    @Column(name = "team_name")
    private String teamName;
    @Column
    private String teamOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int id;

    /**
     * Empty constructor to instantiate a new team
     */
    public TeamNames() {

    }

    /**
     * Builds a new team
     *
     * @param teamName  the name of the fantasy football team
     * @param teamOwner the owner of the fantasy football team
     */
    public TeamNames(String teamName, String teamOwner) {
        this.teamName = teamName;
        this.teamOwner = teamOwner;
    }

    /**
     * Gets team name.
     *
     * @return the team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sets team name.
     *
     * @param teamName the team name
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Gets team owner.
     *
     * @return the team owner
     */
    public String getTeamOwner() {
        return teamOwner;
    }

    /**
     * Sets team owner.
     *
     * @param teamOwner the team owner
     */
    public void setTeamOwner(String teamOwner) {
        this.teamOwner = teamOwner;
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

    @Override
    public String toString() {
        return "TeamNames [teamName=" + teamName + ", teamOwner=" + teamOwner + "]";
    }
}
