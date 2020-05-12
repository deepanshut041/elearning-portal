package io.github.deepanshut041.sawdhyay.daos;


import io.github.deepanshut041.sawdhyay.models.Exam;

import java.util.List;

public interface ExamDao {

    void saveExam(Exam exam);
    Exam getExam(int id);
    List<Exam> listExams();
    void updateExam(Exam exam);
    void deleteExam(int id);

}
