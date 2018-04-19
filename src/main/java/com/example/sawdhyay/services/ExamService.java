package com.example.sawdhyay.services;

import com.example.sawdhyay.models.Exam;

import java.util.List;

public interface ExamService {

    void addExam(Exam exam);

    void updateExam(Exam exam);

    void deleteExamById(int id);

    List<Exam> findAllExams();

    Exam getExamById(int id);
    
}
