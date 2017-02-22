package cz.rbenes.kukbuk.database.dao;

import cz.rbenes.kukbuk.database.entity.MealImage;

/**
 * Created by rostik on 22.2.17.
 */
public class MealImageDaoImpl extends GenericDaoImpl<MealImage, Long> implements MealImageDao {

    public MealImageDaoImpl() {
        super(MealImage.class);
    }
}
