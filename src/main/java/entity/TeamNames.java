package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
     * @param teamName the name of the fantasy football team
     * @param teamOwner the owner of the fantasy football team
     */
    public TeamNames(String teamName, String teamOwner) {
        this.teamName = teamName;
        this.teamOwner = teamOwner;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamOwner() {
        return teamOwner;
    }

    public void setTeamOwner(String teamOwner) {
        this.teamOwner = teamOwner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TeamNames [teamName=" + teamName + ", teamOwner=" + teamOwner + "]";
    }
}
