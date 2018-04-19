package com.example.sawdhyay.daos;


import com.example.sawdhyay.models.Fanswer;

import java.util.List;

public interface FanswerDao {

    void saveFanswer(Fanswer fanswer);
    Fanswer getFanswer(int id);
    List<Fanswer> listFanswers();
    void updateFanswer(Fanswer fanswer);
    void deleteFanswer(int id);

}
