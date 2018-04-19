package com.example.sawdhyay.services;

import com.example.sawdhyay.daos.FquestionDao;
import com.example.sawdhyay.models.Fquestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("fquestionService")
public class FquestionServiceImpl implements FquestionService{

    @Autowired
    private FquestionDao fquestionDao;

    @Override
    @Transactional
    public void addFquestion(Fquestion fquestion) {
        this.fquestionDao.saveFquestion(fquestion);
    }

    @Override
    @Transactional
    public void updateFquestion(Fquestion fquestion) {
        this.fquestionDao.updateFquestion(fquestion);
    }

    @Override
    @Transactional
    public void deleteFquestionById(int id) {
        this.fquestionDao.deleteFquestion(id);
    }

    @Override
    @Transactional
    public List<Fquestion> findAllFquestions() {
        return this.fquestionDao.listFquestions();
    }

    @Override
    @Transactional
    public Fquestion getFquestionById(int id) {
        return this.fquestionDao.getFquestion(id);
    }
}
