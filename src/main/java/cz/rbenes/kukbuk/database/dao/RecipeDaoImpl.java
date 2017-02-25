package cz.rbenes.kukbuk.database.dao;

import cz.rbenes.kukbuk.database.entity.Recipe;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.LongSummaryStatistics;

/**
 * Created by rostik on 22.2.17.
 */
@Repository
@Transactional
public class RecipeDaoImpl extends GenericDaoImpl<Recipe, Long> implements RecipeDao {

    public RecipeDaoImpl() {
        super(Recipe.class);
    }

    @Override
    public List<Recipe> getAllFetch() {
        String jql = "select r from Recipe r left join fetch r.ingredients, r.mealImages";
        return entityManager.createQuery(jql).getResultList();
    }
}
