package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("questionDao")
public class QuestionDaoImpl implements QuestionDao {

    private static final Logger logger = LoggerFactory.getLogger(QuestionDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveQuestion(Question question) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(question);
        logger.info("Question saved successfully, Question Details=" + question);
    }

    @Override
    public Question getQuestion(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Question question = (Question) session.load(Question.class, new Integer(id));
        logger.info("Question loaded successfully, Question details=" + question);
        return question;
    }

    @Override
    public List<Question> listQuestions() {
        Session session = sessionFactory.getCurrentSession();
        List<Question> questionList = session.createQuery("from Question").list();
        for(Question question : questionList){
            logger.info("Question List::" + question);
        }
        return questionList;
    }

    @Override
    public void updateQuestion(Question question) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(question);
        logger.info("Question updated successfully, Question Details="+question);
    }

    @Override
    public void deleteQuestion(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Question question = (Question) session.load(Question.class, new Integer(id));
        if(null != question){
            session.delete(question);
        }
        logger.info("Question deleted successfully, question details=" + question);
    }
}
