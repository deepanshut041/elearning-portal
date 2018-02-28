package com.example.sawdhyay.services;

import com.example.sawdhyay.daos.LanguageDao;
import com.example.sawdhyay.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("languageService")
public class LanguageServiceImpl implements LanguageService{

    @Autowired
    private LanguageDao languageDao;

    @Override
    @Transactional
    public void addLanguage(Language language) {
        this.languageDao.saveLanguage(language);
    }

    @Override
    @Transactional
    public void updateLanguage(Language language) {
        this.languageDao.updateLanguage(language);
    }

    @Override
    @Transactional
    public void deleteLanguageById(int id) {
        this.languageDao.deleteLanguage(id);
    }

    @Override
    @Transactional
    public List<Language> findAllLanguages() {
        return this.languageDao.listLanguages();
    }

    @Override
    @Transactional
    public Language getLanguageById(int id) {
        return this.languageDao.getLanguage(id);
    }
}
