package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Module;

import java.util.List;

public interface ModuleDao {

    void saveModule(Module module);
    Module getModule(int id);
    List<Module> listModules();
    void updateModule(Module module);
    void deleteModule(int id);

}
