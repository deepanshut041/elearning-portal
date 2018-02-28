package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

    private static final Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveCategory(Category category) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(category);
        logger.info("Category saved successfully, Category Details=" + category);
    }

    @Override
    public Category getCategory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Category category = (Category) session.load(Category.class, new Integer(id));
        logger.info("Category loaded successfully, Category details=" + category);
        return category;
    }

    @Override
    public List<Category> listCategorys() {
        Session session = sessionFactory.getCurrentSession();
        List<Category> categoryList = session.createQuery("from Category").list();
        for(Category category : categoryList){
            logger.info("Category List::" + category);
        }
        return categoryList;
    }

    @Override
    public void updateCategory(Category category) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(category);
        logger.info("Category updated successfully, Category Details="+category);
    }

    @Override
    public void deleteCategory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Category category = (Category) session.load(Category.class, new Integer(id));
        if(null != category){
            session.delete(category);
        }
        logger.info("Category deleted successfully, category details=" + category);
    }
}
