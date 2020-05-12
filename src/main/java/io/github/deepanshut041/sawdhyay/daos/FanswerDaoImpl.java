package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Fanswer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("fanswerDao")
public class FanswerDaoImpl implements FanswerDao {

    private static final Logger logger = LoggerFactory.getLogger(FanswerDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveFanswer(Fanswer fanswer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(fanswer);
        logger.info("Fanswer saved successfully, Fanswer Details=" + fanswer);
    }

    @Override
    public Fanswer getFanswer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Fanswer fanswer = (Fanswer) session.load(Fanswer.class, new Integer(id));
        logger.info("Fanswer loaded successfully, Fanswer details=" + fanswer);
        return fanswer;
    }

    @Override
    public List<Fanswer> listFanswers() {
        Session session = sessionFactory.getCurrentSession();
        List<Fanswer> fanswerList = session.createQuery("from Fanswer").list();
        for(Fanswer fanswer : fanswerList){
            logger.info("Fanswer List::" + fanswer);
        }
        return fanswerList;
    }

    @Override
    public void updateFanswer(Fanswer fanswer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(fanswer);
        logger.info("Fanswer updated successfully, Fanswer Details="+fanswer);
    }

    @Override
    public void deleteFanswer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Fanswer fanswer = (Fanswer) session.load(Fanswer.class, new Integer(id));
        if(null != fanswer){
            session.delete(fanswer);
        }
        logger.info("Fanswer deleted successfully, fanswer details=" + fanswer);
    }
}
