package persistence;

import entity.TeamNames;

import testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeamDaoTest {
    TeamDao teamDao;

    @BeforeEach
    public void setUp() throws Exception {
        Database db = new Database();
        db.runSQL("cleandb.sql");
        teamDao = new TeamDao();
    }

    @Test
    public void getById() {
        TeamNames team = teamDao.getById(1);
        assertNotNull(team);
    }

    @Test
    public void update() {
        TeamNames team = teamDao.getById(1);
        team.setTeamName("Patriots");
        teamDao.update(team);

        TeamNames actualName = teamDao.getById(1);
        assertEquals("Patriots", actualName.getTeamName());
    }

    @Test
    public void insert() {
        TeamNames team = new TeamNames("New Team", "Billy Bob");
        int insertedId = teamDao.insert(team);
        assertNotEquals(0, insertedId);
        TeamNames insertedTeam = teamDao.getById(insertedId);
        assertEquals("New Team", insertedTeam.getTeamName());
    }

    @Test
    public void delete() {
        teamDao.delete(teamDao.getById(2));
        assertNull(teamDao.getById(2));
    }

    @Test
    public void getAll() {
        List<TeamNames> teams = teamDao.getAll();
        assertEquals(2, teams.size());
    }

    @Test
    public void getByPropertyEqual() {
        List<TeamNames> teams = teamDao.getByPropertyEqual("teamName", "Team 1");
        assertEquals(1, teams.size());
        assertEquals(1, teams.get(0).getId());
    }

    @Test
    public void getByPropertyLike() {
        List<TeamNames> teams = teamDao.getByPropertyLike("teamName", "Team");
        assertEquals(2, teams.size());
    }
}