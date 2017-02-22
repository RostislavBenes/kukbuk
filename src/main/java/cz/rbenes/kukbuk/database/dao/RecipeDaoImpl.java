package cz.rbenes.kukbuk.database.dao;

import cz.rbenes.kukbuk.database.entity.Recipe;

import java.util.LongSummaryStatistics;

/**
 * Created by rostik on 22.2.17.
 */
public class RecipeDaoImpl extends GenericDaoImpl<Recipe, Long> implements RecipeDao {

    public RecipeDaoImpl() {
        super(Recipe.class);
    }
}
