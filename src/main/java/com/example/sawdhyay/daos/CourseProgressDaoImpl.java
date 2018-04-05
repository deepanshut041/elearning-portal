package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.CourseProgress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseProgressDao")
public class CourseProgressDaoImpl implements CourseProgressDao {
    private static final Logger logger = LoggerFactory.getLogger(CourseProgressDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveCourseProgress(CourseProgress courseProgress) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(courseProgress);
        logger.info("CourseProgress saved successfully, CourseProgress Details=" + courseProgress);
    }

    @Override
    public CourseProgress getCourseProgress(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CourseProgress courseProgress = (CourseProgress) session.get(CourseProgress.class, id);
        logger.info("CourseProgress loaded successfully, CourseProgress details=" + courseProgress);
        return courseProgress;
    }

    @Override
    public List<CourseProgress> listCourseProgresss() {
        Session session = sessionFactory.getCurrentSession();
        List<CourseProgress> courseProgressList = session.createQuery("from CourseProgress").list();
        for(CourseProgress courseProgress : courseProgressList){
            logger.info("CourseProgress List::" + courseProgress);
        }
        return courseProgressList;
    }

    @Override
    public void updateCourseProgress(CourseProgress courseProgress) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(courseProgress);
        logger.info("CourseProgress updated successfully, CourseProgress Details="+courseProgress);
    }

    @Override
    public void deleteCourseProgress(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CourseProgress courseProgress = (CourseProgress) session.load(CourseProgress.class, new Integer(id));
        if(null != courseProgress){
            session.delete(courseProgress);
        }
        logger.info("CourseProgress deleted successfully, courseProgress details=" + courseProgress);
    }
}
