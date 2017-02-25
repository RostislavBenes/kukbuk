package cz.rbenes.kukbuk.database.dao;

import cz.rbenes.kukbuk.config.TestKukBukConfig;
import cz.rbenes.kukbuk.database.entity.Category;
import cz.rbenes.kukbuk.database.entity.Recipe;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;


/**
 * Created by rostik on 23.2.17.
 */
@ContextConfiguration(classes = TestKukBukConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryDaoImplTest {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    @Transactional
    @Rollback
    public void findByName() {
        Category chickenCtg = CategoryTestData.getChickenCategory();
        Category porkCtg = CategoryTestData.getPorkCategory();
        categoryDao.save(chickenCtg);
        categoryDao.save(porkCtg);

        Category retrievedCtg = categoryDao.find(porkCtg.getName());
        Assert.assertEquals(porkCtg.getName(), retrievedCtg.getName());
        Assert.assertEquals(porkCtg.getDescription(), retrievedCtg.getDescription());
    }

    @Test(expected = PersistenceException.class)
    @Transactional
    @Rollback
    public void addingCategoriesWithSameNameThrows() {
        Category chickenCtg = CategoryTestData.getChickenCategory();
        Category secondChickenCtg = CategoryTestData.getChickenCategory();
        categoryDao.save(chickenCtg);
        categoryDao.save(secondChickenCtg);
    }

    @Test
    @Transactional
    @Rollback
    public void saveAndRetrieveNestedCategories() {
        Category root = CategoryTestData.getNestedCategories();

        categoryDao.save(root);
        Category retrieved = categoryDao.find(root.getName());

        Assert.assertNotNull(retrieved);
        Assert.assertEquals(2, retrieved.getSubCategories().size());
        for (Category c: retrieved.getSubCategories()) {
            Assert.assertEquals(root.getId(), c.getParentCategory().getId());
        }
    }



}
