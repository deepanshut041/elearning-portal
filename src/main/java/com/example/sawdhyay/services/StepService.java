package com.example.sawdhyay.services;

import com.example.sawdhyay.models.Step;

import java.util.List;

public interface StepService {

    void addStep(Step step);

    void updateStep(Step step);

    void deleteStepById(int id);

    List<Step> findAllSteps();

    Step getStepById(int id);
    
}
