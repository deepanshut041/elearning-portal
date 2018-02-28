package com.example.sawdhyay.services;

import com.example.sawdhyay.daos.MentorDao;
import com.example.sawdhyay.models.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("mentorService")
public class MentorServiceImpl implements MentorService{

    @Autowired
    private MentorDao mentorDao;

    @Override
    @Transactional
    public void addMentor(Mentor mentor) {
        this.mentorDao.saveMentor(mentor);
    }

    @Override
    @Transactional
    public void updateMentor(Mentor mentor) {
        this.mentorDao.updateMentor(mentor);
    }

    @Override
    @Transactional
    public void deleteMentorById(int id) {
        this.mentorDao.deleteMentor(id);
    }

    @Override
    @Transactional
    public List<Mentor> findAllMentors() {
        return this.mentorDao.listMentors();
    }

    @Override
    @Transactional
    public Mentor getMentorById(int id) {
        return this.mentorDao.getMentor(id);
    }
}
