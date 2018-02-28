package com.example.sawdhyay.services;

import com.example.sawdhyay.models.Language;

import java.util.List;

public interface LanguageService {

    void addLanguage(Language language);

    void updateLanguage(Language language);

    void deleteLanguageById(int id);

    List<Language> findAllLanguages();

    Language getLanguageById(int id);
    
}
