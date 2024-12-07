package entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

/**
 * The type Matchup.
 */
@Entity
@Table(name = "matchups")
public class Matchup {
    @Column(name = "team_1")
    private int team1;
    @Column(name = "team_2")
    private int team2;
    @Column(name = "week_number")
    private int weekNumber;
    @Column(name = "schedule_id")
    private int scheduleID;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int id;

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
     * Instantiates a new Matchup.
     */
    public Matchup() {

    }

    /**
     * Instantiates a new Matchup.
     *
     * @param team1      the team 1
     * @param team2      the team 2
     * @param weekNumber the week number
     * @param scheduleID the schedule id
     */
    public Matchup(int team1, int team2, int weekNumber, int scheduleID) {
        this.team1 = team1;
        this.team2 = team2;
        this.weekNumber = weekNumber;
        this.scheduleID = scheduleID;
    }

    /**
     * Gets team 1.
     *
     * @return the team 1
     */
    public int getTeam1() {
        return team1;
    }

    /**
     * Sets team 1.
     *
     * @param team1 the team 1
     */
    public void setTeam1(int team1) {
        this.team1 = team1;
    }

    /**
     * Gets team 2.
     *
     * @return the team 2
     */
    public int getTeam2() {
        return team2;
    }

    /**
     * Sets team 2.
     *
     * @param team2 the team 2
     */
    public void setTeam2(int team2) {
        this.team2 = team2;
    }

    /**
     * Gets week number.
     *
     * @return the week number
     */
    public int getWeekNumber() {
        return weekNumber;
    }

    /**
     * Sets week number.
     *
     * @param weekNumber the week number
     */
    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    /**
     * Gets schedule id.
     *
     * @return the schedule id
     */
    public int getScheduleID() {
        return scheduleID;
    }

    /**
     * Sets schedule id.
     *
     * @param scheduleID the schedule id
     */
    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

}
