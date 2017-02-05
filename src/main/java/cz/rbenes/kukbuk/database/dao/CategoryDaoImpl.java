package cz.rbenes.kukbuk.database.dao;

import cz.rbenes.kukbuk.database.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * Created by rostik on 4.2.17.
 */
@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {
    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = manager.createQuery("Select a From Category a", Category.class).getResultList();
        return categories;
    }
}
