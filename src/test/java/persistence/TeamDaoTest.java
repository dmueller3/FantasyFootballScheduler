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
    }

    @Test
    public void insert() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getByPropertyEqual() {
    }

    @Test
    public void getByPropertyLike() {
    }
}