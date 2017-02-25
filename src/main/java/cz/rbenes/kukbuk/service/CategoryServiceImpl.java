package cz.rbenes.kukbuk.service;

import cz.rbenes.kukbuk.database.dao.CategoryDao;
import cz.rbenes.kukbuk.database.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;

/**
 * Created by rostik on 23.2.17.
 */
@org.springframework.stereotype.Service
public class CategoryServiceImpl implements CategoryService, KukbukService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public Category get(String name) {
        return categoryDao.find(name);
    }

    //TODO sort by name
    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    //TODO: sort by name
    @Override
    public List<Category> getAllFetchRecipes() {
        return categoryDao.getAllFetch();
    }

    @Override
    public Category update(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public void remove(Category category) {
        categoryDao.remove(category);
    }
}
