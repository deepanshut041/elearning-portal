package com.example.sawdhyay.daos;



import com.example.sawdhyay.models.Language;

import java.util.List;

public interface LanguageDao {

    void saveLanguage(Language language);
    Language getLanguage(int id);
    List<Language> listLanguages();
    void updateLanguage(Language language);
    void deleteLanguage(int id);

}
