package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.models.Step;

import java.util.List;

public interface StepService {

    void addStep(Step step);

    void updateStep(Step step);

    void deleteStepById(int id);

    List<Step> findAllSteps();

    Step getStepById(int id);

    List<Step> findAllStepsByModuleId(int id);
    
}
