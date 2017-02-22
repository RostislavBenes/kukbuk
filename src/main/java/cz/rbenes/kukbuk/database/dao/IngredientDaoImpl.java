package cz.rbenes.kukbuk.database.dao;

import cz.rbenes.kukbuk.database.entity.Ingredient;

/**
 * Created by rostik on 22.2.17.
 */
public class IngredientDaoImpl extends GenericDaoImpl<Ingredient, Long> implements IngredientDao {

    public IngredientDaoImpl() {
        super(Ingredient.class);
    }
}
