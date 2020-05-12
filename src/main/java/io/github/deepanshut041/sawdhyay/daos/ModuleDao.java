package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Module;

import java.util.List;

public interface ModuleDao {

    void saveModule(Module module);
    Module getModule(int id);
    List<Module> listModules();
    void updateModule(Module module);
    void deleteModule(int id);
    List<Module> listModuleByCourseId(int id);

}
