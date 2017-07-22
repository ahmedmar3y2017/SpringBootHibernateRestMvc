package springboothibernate.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springboothibernate.Entities.Topics;

import java.util.List;

/**
 * Created by ahmed on 7/22/2017.
 */
@Transactional
@Component
public class topicDaoImpl implements topicDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void Insert(Topics topics) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(topics);
        transaction.commit();
        session.flush(); //address will not get saved without this

    }

    @Override
    public List<Topics> GetAll() {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Topics> list = session.createCriteria(Topics.class).list();
        transaction.commit();
        session.flush(); //address will not get saved without this

        return list;

    }

    @Override
    public Topics GetSpecific(String id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Topics topics = (Topics) session.createCriteria(Topics.class).add(Restrictions.eq("id", id)).uniqueResult();
        transaction.commit();
        session.flush(); //address will not get saved without this


        return topics;
    }


    @Override
    public void Update(Topics topics) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(topics);
        transaction.commit();

        session.flush(); //address will not get saved without this
    }

    @Override
    public void deleteTopic(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Topics  where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();

        session.flush(); //address will not get saved without this
    }
}
