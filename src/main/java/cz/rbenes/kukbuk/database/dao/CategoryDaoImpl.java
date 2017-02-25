package cz.rbenes.kukbuk.database.dao;

import cz.rbenes.kukbuk.database.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;


/**
 * Created by rostik on 4.2.17.
 */
@Repository
@Transactional
public class CategoryDaoImpl extends GenericDaoImpl<Category, Long> implements CategoryDao {

    public CategoryDaoImpl() {
        super(Category.class);
    }

    @Override
    public List<Category> getAllFetch() {
        String jql = "select c from Category c left join fetch c.recipes";
        return entityManager.createQuery(jql).getResultList();
    }

    @Override
    public Category find(String name) {
        String jql = "select c from Category c where c.name = :name";
        Query query = entityManager.createQuery(jql);
        query.setParameter("name", name);
        return (Category) query.getSingleResult();
    }
}
