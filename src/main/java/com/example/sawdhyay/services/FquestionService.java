package com.example.sawdhyay.services;

import com.example.sawdhyay.models.Fquestion;

import java.util.List;

public interface FquestionService {

    void addFquestion(Fquestion fquestion);

    void updateFquestion(Fquestion fquestion);

    void deleteFquestionById(int id);

    List<Fquestion> findAllFquestions();

    Fquestion getFquestionById(int id);
    
}
