package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.daos.CategoryDao;
import io.github.deepanshut041.sawdhyay.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public void addCategory(Category category) {
        this.categoryDao.saveCategory(category);
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        this.categoryDao.updateCategory(category);
    }

    @Override
    @Transactional
    public void deleteCategoryById(int id) {
        this.categoryDao.deleteCategory(id);
    }

    @Override
    @Transactional
    public List<Category> findAllCategorys() {
        return this.categoryDao.listCategorys();
    }

    @Override
    @Transactional
    public Category getCategoryById(int id) {
        return this.categoryDao.getCategory(id);
    }
}
