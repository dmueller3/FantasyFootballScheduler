package persistence;

import entity.Team;

import testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeamDaoTest {
    private static final Dao<Team> TEAM_DAO = new Dao<>(Team.class);

    @BeforeEach
    public void setUp() throws Exception {
        Database db = new Database();
        db.runSQL("clean.sql");
    }

    @Test
    public void getById() {
        Team team = TEAM_DAO.getById(1);
        assertNotNull(team);
    }

    @Test
    public void update() {
        Team team = TEAM_DAO.getById(1);
        team.setTeamName("Patriots");
        TEAM_DAO.update(team);

        Team actualName = TEAM_DAO.getById(1);
        assertEquals("Patriots", actualName.getTeamName());
    }

    @Test
    public void insert() {
        Team team = new Team("New Team", "Billy Bob");
        int insertedId = TEAM_DAO.insert(team);
        assertNotEquals(0, insertedId);
        Team insertedTeam = TEAM_DAO.getById(insertedId);
        assertEquals("New Team", insertedTeam.getTeamName());
    }

    @Test
    public void delete() {
        TEAM_DAO.delete(TEAM_DAO.getById(2));
        assertNull(TEAM_DAO.getById(2));
    }

    @Test
    public void getAll() {
        List<Team> teams = TEAM_DAO.getAll();
        assertEquals(8, teams.size());
    }

    @Test
    public void getByPropertyEqual() {
        List<Team> teams = TEAM_DAO.findByPropertyEqual("teamName", "Team 1");
        assertEquals(1, teams.size());
        assertEquals(1, teams.get(0).getId());
    }
}