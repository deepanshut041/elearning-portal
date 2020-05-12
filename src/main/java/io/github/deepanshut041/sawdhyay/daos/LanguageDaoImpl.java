package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("languageDao")
public class LanguageDaoImpl implements LanguageDao {

    private static final Logger logger = LoggerFactory.getLogger(LanguageDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveLanguage(Language language) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(language);
        logger.info("Language saved successfully, Language Details=" + language);
    }

    @Override
    public Language getLanguage(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Language language = (Language) session.load(Language.class, new Integer(id));
        logger.info("Language loaded successfully, Language details=" + language);
        return language;
    }

    @Override
    public List<Language> listLanguages() {
        Session session = sessionFactory.getCurrentSession();
        List<Language> languageList = session.createQuery("from Language").list();
        for(Language language : languageList){
            logger.info("Language List::" + language);
        }
        return languageList;
    }

    @Override
    public void updateLanguage(Language language) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(language);
        logger.info("Language updated successfully, Language Details="+language);
    }

    @Override
    public void deleteLanguage(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Language language = (Language) session.load(Language.class, new Integer(id));
        if(null != language){
            session.delete(language);
        }
        logger.info("Language deleted successfully, language details=" + language);
    }
}
