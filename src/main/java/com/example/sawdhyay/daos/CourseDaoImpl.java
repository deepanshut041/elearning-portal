package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    private static final Logger logger = LoggerFactory.getLogger(CourseDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void save(Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(course);
        logger.info("Course saved successfully, Course Details=" + course);
    }

    @Override
    public Course get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Course course = (Course) session.load(Course.class, new Integer(id));
        logger.info("Course loaded successfully, Course details=" + course);
        return course;
    }

    @Override
    public List<Course> list() {
        Session session = sessionFactory.getCurrentSession();
        List<Course> courseList = session.createQuery("from Course").list();
        for(Course course : courseList){
            logger.info("Course List::" + course);
        }
        return courseList;
    }

    @Override
    public void update(int id, Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(course);
        logger.info("Course updated successfully, Course Details="+course);
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Course course = (Course) session.load(Course.class, new Integer(id));
        if(null != course){
            session.delete(course);
        }
        logger.info("Course deleted successfully, course details=" + course);
    }
}
