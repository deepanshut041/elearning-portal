package com.example.sawdhyay.services;

import com.example.sawdhyay.models.Fanswer;

import java.util.List;

public interface FanswerService {

    void addFanswer(Fanswer fanswer);

    void updateFanswer(Fanswer fanswer);

    void deleteFanswerById(int id);

    List<Fanswer> findAllFanswers();

    Fanswer getFanswerById(int id);
    
}
