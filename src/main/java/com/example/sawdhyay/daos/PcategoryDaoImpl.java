package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Pcategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pcategoryDao")
public class PcategoryDaoImpl implements PcategoryDao {

    private static final Logger logger = LoggerFactory.getLogger(PcategoryDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void savePcategory(Pcategory pcategory) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(pcategory);
        logger.info("Pcategory saved successfully, Pcategory Details=" + pcategory);
    }

    @Override
    public Pcategory getPcategory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Pcategory pcategory = (Pcategory) session.load(Pcategory.class, new Integer(id));
        logger.info("Pcategory loaded successfully, Pcategory details=" + pcategory);
        return pcategory;
    }

    @Override
    public List<Pcategory> listPcategorys() {
        Session session = sessionFactory.getCurrentSession();
        List<Pcategory> pcategoryList = session.createQuery("from Pcategory").list();
        for(Pcategory pcategory : pcategoryList){
            logger.info("Pcategory List::" + pcategory);
        }
        return pcategoryList;
    }

    @Override
    public void updatePcategory(Pcategory pcategory) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(pcategory);
        logger.info("Pcategory updated successfully, Pcategory Details="+pcategory);
    }

    @Override
    public void deletePcategory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Pcategory pcategory = (Pcategory) session.load(Pcategory.class, new Integer(id));
        if(null != pcategory){
            session.delete(pcategory);
        }
        logger.info("Pcategory deleted successfully, pcategory details=" + pcategory);
    }
}
