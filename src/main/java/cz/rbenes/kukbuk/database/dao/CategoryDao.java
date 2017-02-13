package cz.rbenes.kukbuk.database.dao;

import cz.rbenes.kukbuk.database.entity.Category;

import javax.transaction.*;
import java.util.List;

/**
 * Created by rostik on 4.2.17.
 */
public interface CategoryDao extends GenericDao<Category, Long> {
}
