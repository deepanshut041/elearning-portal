package com.example.sawdhyay.services;

import com.example.sawdhyay.models.Module;

import java.util.List;

public interface ModuleService {

    void addModule(Module module);

    void updateModule(Module module);

    void deleteModuleById(int id);

    List<Module> findAllModules();

    Module getModuleById(int id);
    
}
