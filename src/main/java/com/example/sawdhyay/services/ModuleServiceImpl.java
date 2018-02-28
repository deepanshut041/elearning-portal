package com.example.sawdhyay.services;

import com.example.sawdhyay.daos.ModuleDao;
import com.example.sawdhyay.models.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService{

    @Autowired
    private ModuleDao moduleDao;

    @Override
    @Transactional
    public void addModule(Module module) {
        this.moduleDao.saveModule(module);
    }

    @Override
    @Transactional
    public void updateModule(Module module) {
        this.moduleDao.updateModule(module);
    }

    @Override
    @Transactional
    public void deleteModuleById(int id) {
        this.moduleDao.deleteModule(id);
    }

    @Override
    @Transactional
    public List<Module> findAllModules() {
        return this.moduleDao.listModules();
    }

    @Override
    @Transactional
    public Module getModuleById(int id) {
        return this.moduleDao.getModule(id);
    }
}
