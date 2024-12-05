package persistence;

import entity.Team;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public class TeamDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public Team getById(int id) {
        Session session = sessionFactory.openSession();
        Team team = session.get( Team.class, id );
        session.close();
        return team;
    }

    public void update(Team team) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(team);
        transaction.commit();
        session.close();
    }

    public int insert(Team team) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(team);
        transaction.commit();
        id = team.getId();
        session.close();
        return id;
    }

    public void delete(Team team) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(team);
        transaction.commit();
        session.close();
    }


    /** Return a list of all teamNames
     *
     * @return All teamNames
     */
    public List<Team> getAll() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Team> query = builder.createQuery(Team.class);
        Root<Team> root = query.from(Team.class);
        List<Team> teamNames = session.createSelectionQuery( query ).getResultList();

        logger.debug("The list of teamNames " + teamNames);
        session.close();

        return teamNames;
    }

    /**
     * Get teamNames by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<Team> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for teamNames with " + propertyName + " = " + value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Team> query = builder.createQuery(Team.class);
        Root<Team> root = query.from(Team.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Team> teamNames = session.createSelectionQuery( query ).getResultList();

        session.close();
        return teamNames;
    }

    /**
     * Get teamNames by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<Team> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for teamNames with {} = {}",  propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Team> query = builder.createQuery(Team.class);
        Root<Team> root = query.from( Team.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Team> teamNames = session.createQuery( query ).getResultList();
        session.close();
        return teamNames;
    }

}