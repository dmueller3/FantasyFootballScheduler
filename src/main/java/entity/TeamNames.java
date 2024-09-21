package entity;

import javax.persistence.*;

/**
 * Represents Fantasy Football Teams
 */
@Entity
@Table(name = "teams")
public class TeamNames {
    private String teamName;
    private String teamOwner;
    private int id;
}
