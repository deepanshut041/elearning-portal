package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.models.Fquestion;

import java.util.List;

public interface FquestionService {

    void addFquestion(Fquestion fquestion);

    void updateFquestion(Fquestion fquestion);

    void deleteFquestionById(int id);

    List<Fquestion> findAllFquestions();

    Fquestion getFquestionById(int id);
    
}
