package cz.rbenes.kukbuk.database.dao;

import cz.rbenes.kukbuk.database.entity.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rostik on 22.2.17.
 */
@Repository
@Transactional
public class IngredientDaoImpl extends GenericDaoImpl<Ingredient, Long> implements IngredientDao {

    public IngredientDaoImpl() {
        super(Ingredient.class);
    }
}
