package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.models.Exam;

import java.util.List;

public interface ExamService {

    void addExam(Exam exam);

    void updateExam(Exam exam);

    void deleteExamById(int id);

    List<Exam> findAllExams();

    Exam getExamById(int id);
    
}
