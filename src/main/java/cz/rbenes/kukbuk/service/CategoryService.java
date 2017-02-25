package cz.rbenes.kukbuk.service;

import cz.rbenes.kukbuk.database.entity.Category;

import java.util.List;

/**
 * Created by rostik on 23.2.17.
 */
public interface CategoryService {
    Category get(String name);
    List<Category> getAll();
    List<Category> getAllFetchRecipes();
    Category update(Category category);
    void remove(Category category);
}
