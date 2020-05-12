package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.daos.ExamDao;
import io.github.deepanshut041.sawdhyay.models.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("examService")
public class ExamServiceImpl implements ExamService{

    @Autowired
    private ExamDao examDao;

    @Override
    @Transactional
    public void addExam(Exam exam) {
        this.examDao.saveExam(exam);
    }

    @Override
    @Transactional
    public void updateExam(Exam exam) {
        this.examDao.updateExam(exam);
    }

    @Override
    @Transactional
    public void deleteExamById(int id) {
        this.examDao.deleteExam(id);
    }

    @Override
    @Transactional
    public List<Exam> findAllExams() {
        return this.examDao.listExams();
    }

    @Override
    @Transactional
    public Exam getExamById(int id) {
        return this.examDao.getExam(id);
    }
}
