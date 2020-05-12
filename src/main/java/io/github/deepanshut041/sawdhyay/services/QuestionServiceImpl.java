package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.daos.QuestionDao;
import io.github.deepanshut041.sawdhyay.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionDao questionDao;

    @Override
    @Transactional
    public void addQuestion(Question question) {
        this.questionDao.saveQuestion(question);
    }

    @Override
    @Transactional
    public void updateQuestion(Question question) {
        this.questionDao.updateQuestion(question);
    }

    @Override
    @Transactional
    public void deleteQuestionById(int id) {
        this.questionDao.deleteQuestion(id);
    }

    @Override
    @Transactional
    public List<Question> findAllQuestions() {
        return this.questionDao.listQuestions();
    }

    @Override
    @Transactional
    public Question getQuestionById(int id) {
        return this.questionDao.getQuestion(id);
    }
}
