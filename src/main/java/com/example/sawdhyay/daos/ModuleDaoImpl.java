package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Module;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("moduleDao")
public class ModuleDaoImpl implements ModuleDao {

    private static final Logger logger = LoggerFactory.getLogger(ModuleDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveModule(Module module) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(module);
        logger.info("Module saved successfully, Module Details=" + module);
    }

    @Override
    public Module getModule(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Module module = (Module) session.load(Module.class, new Integer(id));
        logger.info("Module loaded successfully, Module details=" + module);
        return module;
    }

    @Override
    public List<Module> listModuleByCourseId(int id) {
        Session session = sessionFactory.getCurrentSession();
        List<Module> moduleList = session.createQuery("from Module where course.id=:c_id").setParameter("c_id", id).list();
        for(Module module : moduleList){
            logger.info("Module List::" + module);
        }
        return moduleList;
    }

    @Override
    public List<Module> listModules() {
        Session session = sessionFactory.getCurrentSession();
        List<Module> moduleList = session.createQuery("from Module").list();
        for(Module module : moduleList){
            logger.info("Module List::" + module);
        }
        return moduleList;
    }

    @Override
    public void updateModule(Module module) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(module);
        logger.info("Module updated successfully, Module Details="+module);
    }

    @Override
    public void deleteModule(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Module module = (Module) session.load(Module.class, new Integer(id));
        if(null != module){
            session.delete(module);
        }
        logger.info("Module deleted successfully, module details=" + module);
    }
}
