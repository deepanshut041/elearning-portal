package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.models.Fanswer;

import java.util.List;

public interface FanswerService {

    void addFanswer(Fanswer fanswer);

    void updateFanswer(Fanswer fanswer);

    void deleteFanswerById(int id);

    List<Fanswer> findAllFanswers();

    Fanswer getFanswerById(int id);
    
}
