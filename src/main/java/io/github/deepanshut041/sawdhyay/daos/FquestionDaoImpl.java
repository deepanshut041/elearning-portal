package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Fquestion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("fquestionDao")
public class FquestionDaoImpl implements FquestionDao {

    private static final Logger logger = LoggerFactory.getLogger(FquestionDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveFquestion(Fquestion fquestion) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(fquestion);
        logger.info("Fquestion saved successfully, Fquestion Details=" + fquestion);
    }

    @Override
    public Fquestion getFquestion(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Fquestion fquestion = (Fquestion) session.load(Fquestion.class, new Integer(id));
        logger.info("Fquestion loaded successfully, Fquestion details=" + fquestion);
        return fquestion;
    }

    @Override
    public List<Fquestion> listFquestions() {
        Session session = sessionFactory.getCurrentSession();
        List<Fquestion> fquestionList = session.createQuery("from Fquestion").list();
        for(Fquestion fquestion : fquestionList){
            logger.info("Fquestion List::" + fquestion);
        }
        return fquestionList;
    }

    @Override
    public void updateFquestion(Fquestion fquestion) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(fquestion);
        logger.info("Fquestion updated successfully, Fquestion Details="+fquestion);
    }

    @Override
    public void deleteFquestion(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Fquestion fquestion = (Fquestion) session.load(Fquestion.class, new Integer(id));
        if(null != fquestion){
            session.delete(fquestion);
        }
        logger.info("Fquestion deleted successfully, fquestion details=" + fquestion);
    }
}
