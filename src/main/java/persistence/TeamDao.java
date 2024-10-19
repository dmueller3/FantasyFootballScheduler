package persistence;

import entity.TeamNames;
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

    public TeamNames getById(int id) {
        Session session = sessionFactory.openSession();
        TeamNames teamNames = session.get( TeamNames.class, id );
        session.close();
        return teamNames;
    }

    public void update(TeamNames teamNames) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(teamNames);
        transaction.commit();
        session.close();
    }

    public int insert(TeamNames teamNames) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(teamNames);
        transaction.commit();
        id = teamNames.getId();
        session.close();
        return id;
    }

    public void delete(TeamNames teamNames) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(teamNames);
        transaction.commit();
        session.close();
    }


    /** Return a list of all teamNames
     *
     * @return All teamNames
     */
    public static List<TeamNames> getAll() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TeamNames> query = builder.createQuery(TeamNames.class);
        Root<TeamNames> root = query.from(TeamNames.class);
        List<TeamNames> teamNames = session.createSelectionQuery( query ).getResultList();

        logger.debug("The list of teamNames " + teamNames);
        session.close();

        return teamNames;
    }

    /**
     * Get teamNames by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<TeamNames> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for teamNames with " + propertyName + " = " + value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TeamNames> query = builder.createQuery(TeamNames.class);
        Root<TeamNames> root = query.from(TeamNames.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<TeamNames> teamNames = session.createSelectionQuery( query ).getResultList();

        session.close();
        return teamNames;
    }

    /**
     * Get teamNames by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<TeamNames> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for teamNames with {} = {}",  propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TeamNames> query = builder.createQuery(TeamNames.class);
        Root<TeamNames> root = query.from( TeamNames.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<TeamNames> teamNames = session.createQuery( query ).getResultList();
        session.close();
        return teamNames;
    }

}