package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.daos.ModuleDao;
import io.github.deepanshut041.sawdhyay.models.Module;
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
    public List<Module> findAllModulesByCourseId(int id) {
        return this.moduleDao.listModuleByCourseId(id);
    }

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
