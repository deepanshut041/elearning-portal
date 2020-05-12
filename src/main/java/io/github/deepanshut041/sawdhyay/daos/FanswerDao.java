package io.github.deepanshut041.sawdhyay.daos;


import io.github.deepanshut041.sawdhyay.models.Fanswer;

import java.util.List;

public interface FanswerDao {

    void saveFanswer(Fanswer fanswer);
    Fanswer getFanswer(int id);
    List<Fanswer> listFanswers();
    void updateFanswer(Fanswer fanswer);
    void deleteFanswer(int id);

}
