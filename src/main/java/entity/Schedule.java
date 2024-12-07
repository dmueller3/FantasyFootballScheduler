package entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

/**
 * The type Schedule.
 */
@Entity
@Table(name = "schedules")
public class Schedule {
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "date_of_creation")
    private String dateOfCreation;
    @Column(name = "number_of_weeks")
    private int numberOfWeeks;
    @Column(name = "number_of_teams")
    private int numberOfTeams;
    @Column(name = "matchup_frequency_limit")
    private int matchupFrequency;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int id;

    public Schedule(int userID, Object o) {
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

    /**
     * Instantiates a new Schedule.
     */
    public Schedule() {

    }

    public Schedule(int user_id, String dateOfCreation, int numberOfWeeks, int numberOfTeams, int matchupFrequency) {
        this.user_id = user_id;
        this.dateOfCreation = dateOfCreation;
        this.numberOfWeeks = numberOfWeeks;
        this.numberOfTeams = numberOfTeams;
        this.matchupFrequency = matchupFrequency;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Sets user id.
     *
     * @param user_id the user id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * Gets date of creation.
     *
     * @return the date of creation
     */
    public String getDateOfCreation() {
        return dateOfCreation;
    }

    /**
     * Sets date of creation.
     *
     * @param dateOfCreation the date of creation
     */
    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    /**
     * Gets number of weeks.
     *
     * @return the number of weeks
     */
    public int getNumberOfWeeks() {
        return numberOfWeeks;
    }

    /**
     * Sets number of weeks.
     *
     * @param numberOfWeeks the number of weeks
     */
    public void setNumberOfWeeks(int numberOfWeeks) {
        this.numberOfWeeks = numberOfWeeks;
    }

    /**
     * Gets number of teams.
     *
     * @return the number of teams
     */
    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    /**
     * Sets number of teams.
     *
     * @param numberOfTeams the number of teams
     */
    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    /**
     * Gets matchup frequency.
     *
     * @return the matchup frequency
     */
    public int getMatchupFrequency() {
        return matchupFrequency;
    }

    /**
     * Sets matchup frequency.
     *
     * @param matchupFrequency the matchup frequency
     */
    public void setMatchupFrequency(int matchupFrequency) {
        this.matchupFrequency = matchupFrequency;
    }
}
