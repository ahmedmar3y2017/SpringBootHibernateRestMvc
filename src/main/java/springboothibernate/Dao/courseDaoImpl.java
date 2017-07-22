package springboothibernate.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springboothibernate.Entities.Course;
import springboothibernate.Entities.Topics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmed on 7/22/2017.
 */
@Transactional
@Component
public class courseDaoImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public void insert(Course course) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(course);
        transaction.commit();
        session.flush(); //address will not get saved without this

    }

    public void update(Course course) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(course);
        transaction.commit();
        session.flush(); //address will not get saved without this

    }

    public void Delete(String courseId) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Course where id=:id");
        query.setParameter("id", courseId);
        query.executeUpdate();
        transaction.commit();
        session.flush(); //address will not get saved without this

    }



    public List<Course> getAll(String id) {


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Course> courses = session.createCriteria(Course.class).add(Restrictions.eq("topicId", id)).list();

        transaction.commit();
        session.flush(); //address will not get saved without this

        return courses;

    }
    public Course getSpecific(String id) {


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Course courses = (Course) session.createCriteria(Course.class).add(Restrictions.eq("id", id)).uniqueResult();

        transaction.commit();
        session.flush(); //address will not get saved without this

        return courses;

    }
}
