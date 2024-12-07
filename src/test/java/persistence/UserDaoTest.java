package persistence;

import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {
    private static final Dao<User> USER_DAO = new Dao<>(User.class);

    @BeforeEach
    public void setUp() throws Exception {
        Database db = new Database();
        db.runSQL("clean.sql");
    }

    @Test
    public void getById() {
        User user = USER_DAO.getById(1);
        assertNotNull(user);
    }

    @Test
    public void update() {
        User user = USER_DAO.getById(1);
        user.setUserName("Tom123");
        USER_DAO.update(user);

        User actualName = USER_DAO.getById(1);
        assertEquals("Tom123", actualName.getUserName());
    }

    @Test
    public void insert() {
        User user = new User("Frank");
        int insertedId = USER_DAO.insert(user);
        assertNotEquals(0, insertedId);
        User insertedUSER = USER_DAO.getById(insertedId);
        assertEquals("Frank", insertedUSER.getUserName());
    }

    @Test
    public void delete() {
        USER_DAO.delete(USER_DAO.getById(1));
        assertNull(USER_DAO.getById(1));
    }

    @Test
    public void getAll() {
        List<User> users = USER_DAO.getAll();
        assertEquals(2, users.size());
    }

    @Test
    public void getByPropertyEqual() {
        List<User> users = USER_DAO.findByPropertyEqual("userName", "dmueller3");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getUser_id());
    }
}