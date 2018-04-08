package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Mentor;

import java.util.List;

public interface MentorDao {

    void saveMentor(Mentor mentor);
    Mentor getMentor(int id);
    List<Mentor> listMentors();
    void updateMentor(Mentor mentor);
    void deleteMentor(int id);

    Mentor getMentorByUserId(int id);

}
