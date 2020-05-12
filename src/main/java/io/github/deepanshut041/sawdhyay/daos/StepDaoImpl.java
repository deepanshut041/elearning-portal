package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Step;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("stepDao")
public class StepDaoImpl implements StepDao {

    private static final Logger logger = LoggerFactory.getLogger(StepDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveStep(Step step) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(step);
        logger.info("Step saved successfully, Step Details=" + step);
    }

    @Override
    public List<Step> listStepByModuleId(int id) {
        Session session = sessionFactory.getCurrentSession();
        List<Step> stepList = session.createQuery("from Step where module=:m_id").setParameter("m_id", id).list();
        for(Step step : stepList){
            logger.info("Step List::" + step);
        }
        return stepList;
    }

    @Override
    public Step getStep(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Step step = (Step) session.load(Step.class, new Integer(id));
        logger.info("Step loaded successfully, Step details=" + step);
        return step;
    }

    @Override
    public List<Step> listSteps() {
        Session session = sessionFactory.getCurrentSession();
        List<Step> stepList = session.createQuery("from Step").list();
        for(Step step : stepList){
            logger.info("Step List::" + step);
        }
        return stepList;
    }

    @Override
    public void updateStep(Step step) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(step);
        logger.info("Step updated successfully, Step Details="+step);
    }

    @Override
    public void deleteStep(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Step step = (Step) session.load(Step.class, new Integer(id));
        if(null != step){
            session.delete(step);
        }
        logger.info("Step deleted successfully, step details=" + step);
    }
}
