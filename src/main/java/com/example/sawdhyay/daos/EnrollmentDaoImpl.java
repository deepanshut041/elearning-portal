package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Enrollment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("enrollmentDao")
public class EnrollmentDaoImpl implements EnrollmentDao {
    private static final Logger logger = LoggerFactory.getLogger(EnrollmentDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveEnrollment(Enrollment enrollment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(enrollment);
        logger.info("Enrollment saved successfully, Enrollment Details=" + enrollment);
    }

    @Override
    public Enrollment getEnrollment(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Enrollment enrollment = (Enrollment) session.get(Enrollment.class, id);
        logger.info("Enrollment loaded successfully, Enrollment details=" + enrollment);
        return enrollment;
    }

    @Override
    public List<Enrollment> listEnrollments() {
        Session session = sessionFactory.getCurrentSession();
        List<Enrollment> enrollmentList = session.createQuery("from Enrollment").list();
        for(Enrollment enrollment : enrollmentList){
            logger.info("Enrollment List::" + enrollment);
        }
        return enrollmentList;
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Integer Id = new Integer(id);
        List<Enrollment> enrollmentList = this.sessionFactory.getCurrentSession()
                .createQuery("from Enrollment where student.id=?")
                .setParameter(0, id).list();
        for(Enrollment enrollment : enrollmentList){
            logger.info("Enrollment List::" + enrollment);
        }
        return enrollmentList;
    }

    @Override
    public Enrollment getEnrollmentsByStudentAndCourse(int student_id, int course_id) {
        Session session = sessionFactory.getCurrentSession();
        List<Enrollment> enrollmentList = this.sessionFactory.getCurrentSession()
                .createQuery("from Enrollment where student.id=? and course.id=?")
                .setParameter(0, student_id)
                .setParameter(1, course_id)
                .list();
        for(Enrollment enrollment : enrollmentList){
            logger.info("Enrollment List::" + enrollment);
        }
        if (enrollmentList.size()>0){
            return enrollmentList.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public void updateEnrollment(Enrollment enrollment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(enrollment);
        logger.info("Enrollment updated successfully, Enrollment Details="+enrollment);
    }

    @Override
    public void deleteEnrollment(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Enrollment enrollment = (Enrollment) session.load(Enrollment.class, new Integer(id));
        if(null != enrollment){
            session.delete(enrollment);
        }
        logger.info("Enrollment deleted successfully, enrollment details=" + enrollment);
    }
    
}
