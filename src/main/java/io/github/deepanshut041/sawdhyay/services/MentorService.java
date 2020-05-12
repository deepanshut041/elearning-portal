package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.models.Mentor;

import java.util.List;

public interface MentorService {

    void addMentor(Mentor mentor);

    void updateMentor(Mentor mentor);

    void deleteMentorById(int id);

    List<Mentor> findAllMentors();

    Mentor getMentorById(int id);

    Mentor getMentorByUserId(int id);
}
