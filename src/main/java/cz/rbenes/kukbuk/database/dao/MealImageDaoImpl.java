package cz.rbenes.kukbuk.database.dao;

import cz.rbenes.kukbuk.database.entity.MealImage;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rostik on 22.2.17.
 */
@Repository
@Transactional
public class MealImageDaoImpl extends GenericDaoImpl<MealImage, Long> implements MealImageDao {

    public MealImageDaoImpl() {
        super(MealImage.class);
    }
}
