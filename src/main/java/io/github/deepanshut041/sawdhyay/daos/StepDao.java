package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Step;

import java.util.List;

public interface StepDao {

    void saveStep(Step step);
    Step getStep(int id);
    List<Step> listSteps();
    void updateStep(Step step);
    void deleteStep(int id);
    List<Step> listStepByModuleId(int id);
}
