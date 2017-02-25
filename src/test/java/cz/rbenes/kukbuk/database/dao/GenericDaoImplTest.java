package cz.rbenes.kukbuk.database.dao;

import cz.rbenes.kukbuk.config.TestKukBukConfig;
import cz.rbenes.kukbuk.database.entity.Category;
import cz.rbenes.kukbuk.database.entity.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

/**
 * Created by rostik on 5.2.17.
 */
@ContextConfiguration(classes = TestKukBukConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class GenericDaoImplTest {

    @Autowired
    private CategoryDao categoryDao;


    @Test
    @Transactional
    @Rollback
    public void storeAndRetrieveEntity() {
        Category chickenCtg = CategoryTestData.getChickenCategory();

        categoryDao.save(chickenCtg);

        List<Category> cats = categoryDao.getAll();
        Category retrievedCategory = cats.get(0);
        Assert.assertEquals(chickenCtg.getName(), retrievedCategory.getName());
        Assert.assertEquals(chickenCtg.getDescription(), retrievedCategory.getDescription());
        Assert.assertNotNull(retrievedCategory.getCreatedTime());
        Assert.assertEquals(2, retrievedCategory.getRecipes().size());
    }




    @Test
    @Transactional
    @Rollback
    public void saveOrUpdateSavesAndUpdateEntity() {
        Category chickenCtg = CategoryTestData.getChickenCategory();

        categoryDao.saveOrUpdate(chickenCtg);

        List<Category> cats = categoryDao.getAll();
        Category retrievedCategory = cats.get(0);
        Assert.assertEquals(chickenCtg.getName(), retrievedCategory.getName());

        retrievedCategory.setName("Meat");
        categoryDao.saveOrUpdate(retrievedCategory);

        Category doubleRetrievedCategory = categoryDao.find(retrievedCategory.getId());
        Assert.assertEquals("Meat", doubleRetrievedCategory.getName());
    }

    @Test
    @Transactional
    @Rollback
    public void storeAndRetrieveEntities() {
        Category chickenCtg = CategoryTestData.getChickenCategory();
        Category porkCtg = CategoryTestData.getPorkCategory();

        categoryDao.save(chickenCtg);
        categoryDao.save(porkCtg);

        List<Category> retrievedCategories = categoryDao.getAll();
        Assert.assertEquals(2, retrievedCategories.size());
    }

    @Test
    @Transactional
    @Rollback
    public void storeAndUpdateEntity() {
        Category chickenCtg = CategoryTestData.getChickenCategory();

        categoryDao.save(chickenCtg);

        List<Category> cats = categoryDao.getAll();
        Category retrievedCategory = cats.get(0);
        Assert.assertEquals(chickenCtg.getName(), retrievedCategory.getName());

        retrievedCategory.setName("Meat");
        categoryDao.update(retrievedCategory);

        Category doubleRetrievedCategory = categoryDao.find(retrievedCategory.getId());
        Assert.assertEquals("Meat", doubleRetrievedCategory.getName());
    }

    @Test
    @Transactional
    @Rollback
    public void storeAndDeleteEntity() {
        Category chickenCtg = CategoryTestData.getChickenCategory();

        categoryDao.save(chickenCtg);

        List<Category> cats = categoryDao.getAll();
        Category retrievedCategory = cats.get(0);
        Assert.assertEquals(chickenCtg.getName(), retrievedCategory.getName());

        categoryDao.remove(retrievedCategory);

        Category doubleRetrievedCategory = categoryDao.find(retrievedCategory.getId());
        Assert.assertNull(doubleRetrievedCategory);
    }

}
