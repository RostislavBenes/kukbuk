package cz.rbenes.kukbuk.database.dao;

import cz.rbenes.kukbuk.config.TestKukBukConfig;
import cz.rbenes.kukbuk.database.entity.Category;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.*;
import java.util.List;

/**
 * Created by rostik on 5.2.17.
 */
@ContextConfiguration(classes = TestKukBukConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryDaoImplTest {

    @Autowired
    private CategoryDao categoryDao;

    @PersistenceContext
    private EntityManager manager;



    @Test
    public void testAdCategory() {
        Category sweaty = new Category();
        sweaty.setName("Kolace");

        categoryDao.save(sweaty);

        List<Category> cats = categoryDao.getAll();
        System.out.println("Cas vytvoreni: " + cats.get(0).getCreatedTime());
        Assert.assertEquals(sweaty.getName(), cats.get(0).getName());
    }
}
