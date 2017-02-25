package cz.rbenes.kukbuk.database.dao;

import cz.rbenes.kukbuk.database.entity.Recipe;

import java.util.List;

/**
 * Created by rostik on 22.2.17.
 */
public interface RecipeDao extends GenericDao<Recipe, Long> {
    List<Recipe> getAllFetch();
}
