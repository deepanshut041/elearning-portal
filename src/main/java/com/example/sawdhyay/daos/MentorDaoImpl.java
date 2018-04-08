package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Mentor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mentorDao")
public class MentorDaoImpl implements MentorDao {

    private static final Logger logger = LoggerFactory.getLogger(MentorDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveMentor(Mentor mentor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(mentor);
        logger.info("Mentor saved successfully, Mentor Details=" + mentor);
    }

    @Override
    public Mentor getMentor(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Mentor mentor = (Mentor) session.load(Mentor.class, new Integer(id));
        logger.info("Mentor loaded successfully, Mentor details=" + mentor);
        return mentor;
    }

    @Override
    public List<Mentor> listMentors() {
        Session session = sessionFactory.getCurrentSession();
        List<Mentor> mentorList = session.createQuery("from Mentor").list();
        for(Mentor mentor : mentorList){
            logger.info("Mentor List::" + mentor);
        }
        return mentorList;
    }

    @Override
    public void updateMentor(Mentor mentor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(mentor);
        logger.info("Mentor updated successfully, Mentor Details="+mentor);
    }

    @Override
    public void deleteMentor(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Mentor mentor = (Mentor) session.load(Mentor.class, new Integer(id));
        if(null != mentor){
            session.delete(mentor);
        }
        logger.info("Mentor deleted successfully, mentor details=" + mentor);
    }

    @Override
    public Mentor getMentorByUserId(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Mentor> mentorList = session.createQuery("from Mentor where course.id=:c_id").setParameter("c_id", id).list();
        for(Mentor mentor : mentorList){
            logger.info("Module List::" + mentor);
        }
        if (mentorList.size() > 0) {
            return mentorList.get(0);
        } else {
            return null;
        }
    }
}
