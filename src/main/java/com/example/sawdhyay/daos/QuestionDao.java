package com.example.sawdhyay.daos;


import com.example.sawdhyay.models.Question;

import java.util.List;

public interface QuestionDao {

    void saveQuestion(Question question);
    Question getQuestion(int id);
    List<Question> listQuestions();
    void updateQuestion(Question question);
    void deleteQuestion(int id);

}
