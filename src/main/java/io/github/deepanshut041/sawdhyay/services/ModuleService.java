package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.models.Module;

import java.util.List;

public interface ModuleService {

    void addModule(Module module);

    void updateModule(Module module);

    void deleteModuleById(int id);

    List<Module> findAllModules();

    List<Module> findAllModulesByCourseId(int id);

    Module getModuleById(int id);
    
}
