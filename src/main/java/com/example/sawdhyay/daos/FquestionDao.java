package com.example.sawdhyay.daos;


import com.example.sawdhyay.models.Fquestion;

import java.util.List;

public interface FquestionDao {

    void saveFquestion(Fquestion fquestion);
    Fquestion getFquestion(int id);
    List<Fquestion> listFquestions();
    void updateFquestion(Fquestion fquestion);
    void deleteFquestion(int id);

}
