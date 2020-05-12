package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Exam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("examDao")
public class ExamDaoImpl implements ExamDao {

    private static final Logger logger = LoggerFactory.getLogger(ExamDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveExam(Exam exam) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(exam);
        logger.info("Exam saved successfully, Exam Details=" + exam);
    }

    @Override
    public Exam getExam(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Exam exam = (Exam) session.load(Exam.class, new Integer(id));
        logger.info("Exam loaded successfully, Exam details=" + exam);
        return exam;
    }

    @Override
    public List<Exam> listExams() {
        Session session = sessionFactory.getCurrentSession();
        List<Exam> examList = session.createQuery("from Exam").list();
        for(Exam exam : examList){
            logger.info("Exam List::" + exam);
        }
        return examList;
    }

    @Override
    public void updateExam(Exam exam) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(exam);
        logger.info("Exam updated successfully, Exam Details="+exam);
    }

    @Override
    public void deleteExam(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Exam exam = (Exam) session.load(Exam.class, new Integer(id));
        if(null != exam){
            session.delete(exam);
        }
        logger.info("Exam deleted successfully, exam details=" + exam);
    }
}
