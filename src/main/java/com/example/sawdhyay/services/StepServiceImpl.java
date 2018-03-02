package com.example.sawdhyay.services;

import com.example.sawdhyay.daos.StepDao;
import com.example.sawdhyay.models.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("stepService")
public class StepServiceImpl implements StepService{

    @Autowired
    private StepDao stepDao;

    @Override
    @Transactional
    public void addStep(Step step) {
        this.stepDao.saveStep(step);
    }

    @Override
    @Transactional
    public void updateStep(Step step) {
        this.stepDao.updateStep(step);
    }

    @Override
    @Transactional
    public void deleteStepById(int id) {
        this.stepDao.deleteStep(id);
    }

    @Override
    @Transactional
    public List<Step> findAllSteps() {
        return this.stepDao.listSteps();
    }

    @Override
    public List<Step> findAllStepsByModuleId(int id) {
        return this.stepDao.listStepByModuleId(id);
    }

    @Override
    @Transactional
    public Step getStepById(int id) {
        return this.stepDao.getStep(id);
    }
}
