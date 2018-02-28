package com.example.sawdhyay.daos;


import com.example.sawdhyay.models.Category;

import java.util.List;

public interface CategoryDao {

    void saveCategory(Category category);
    Category getCategory(int id);
    List<Category> listCategorys();
    void updateCategory(Category category);
    void deleteCategory(int id);

}
