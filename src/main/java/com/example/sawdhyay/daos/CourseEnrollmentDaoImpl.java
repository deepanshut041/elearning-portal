package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.CourseEnrollment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseEnrollmentDao")
public class CourseEnrollmentDaoImpl implements CourseEnrollmentDao {
    private static final Logger logger = LoggerFactory.getLogger(CourseEnrollmentDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveCourseEnrollment(CourseEnrollment courseEnrollment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(courseEnrollment);
        logger.info("CourseEnrollment saved successfully, CourseEnrollment Details=" + courseEnrollment);
    }

    @Override
    public CourseEnrollment getCourseEnrollment(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CourseEnrollment courseEnrollment = (CourseEnrollment) session.get(CourseEnrollment.class, id);
        logger.info("CourseEnrollment loaded successfully, CourseEnrollment details=" + courseEnrollment);
        return courseEnrollment;
    }

    @Override
    public List<CourseEnrollment> listCourseEnrollments() {
        Session session = sessionFactory.getCurrentSession();
        List<CourseEnrollment> courseEnrollmentList = session.createQuery("from CourseEnrollment").list();
        for(CourseEnrollment courseEnrollment : courseEnrollmentList){
            logger.info("CourseEnrollment List::" + courseEnrollment);
        }
        return courseEnrollmentList;
    }

    @Override
    public void updateCourseEnrollment(CourseEnrollment courseEnrollment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(courseEnrollment);
        logger.info("CourseEnrollment updated successfully, CourseEnrollment Details="+courseEnrollment);
    }

    @Override
    public void deleteCourseEnrollment(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CourseEnrollment courseEnrollment = (CourseEnrollment) session.load(CourseEnrollment.class, new Integer(id));
        if(null != courseEnrollment){
            session.delete(courseEnrollment);
        }
        logger.info("CourseEnrollment deleted successfully, courseEnrollment details=" + courseEnrollment);
    }
    
}
