package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.daos.FanswerDao;
import io.github.deepanshut041.sawdhyay.models.Fanswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("fanswerService")
public class FanswerServiceImpl implements FanswerService{

    @Autowired
    private FanswerDao fanswerDao;

    @Override
    @Transactional
    public void addFanswer(Fanswer fanswer) {
        this.fanswerDao.saveFanswer(fanswer);
    }

    @Override
    @Transactional
    public void updateFanswer(Fanswer fanswer) {
        this.fanswerDao.updateFanswer(fanswer);
    }

    @Override
    @Transactional
    public void deleteFanswerById(int id) {
        this.fanswerDao.deleteFanswer(id);
    }

    @Override
    @Transactional
    public List<Fanswer> findAllFanswers() {
        return this.fanswerDao.listFanswers();
    }

    @Override
    @Transactional
    public Fanswer getFanswerById(int id) {
        return this.fanswerDao.getFanswer(id);
    }
}
