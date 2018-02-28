package com.example.sawdhyay.services;

import com.example.sawdhyay.models.Category;

import java.util.List;

public interface CategoryService {

    void addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategoryById(int id);

    List<Category> findAllCategorys();

    Category getCategoryById(int id);
    
}
