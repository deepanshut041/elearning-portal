package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Step;

import java.util.List;

public interface StepDao {

    void saveStep(Step step);
    Step getStep(int id);
    List<Step> listSteps();
    void updateStep(Step step);
    void deleteStep(int id);

}
