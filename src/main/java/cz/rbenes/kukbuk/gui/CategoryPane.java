package cz.rbenes.kukbuk.gui;

import cz.rbenes.kukbuk.database.dao.CategoryDao;
import cz.rbenes.kukbuk.database.entity.Category;
import cz.rbenes.kukbuk.service.CategoryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rostik on 23.2.17.
 */
public class CategoryPane  extends GridPane {
    private CategoryService categoryService;

    Category root;

    public CategoryPane(CategoryService categoryService) {
        super();
        this.categoryService = categoryService;
    }

    public void init() {
        Button addCategory = new Button("Add");
        addCategory.setOnAction( event -> {

        });
//        List<Category> categories = categoryService.getAll();
        root = categoryService.get("Categories");
        TreeItem<Category> rootItem = new TreeItem<>(root);
        List<TreeItem<Category>> rootChildren = new ArrayList<TreeItem<Category>>();
        for (Category c: root.getSubCategories()) {
            rootChildren.add(new TreeItem<Category>(c));
        }
        rootItem.getChildren().addAll(rootChildren);
        TreeView<Category> categoryTree = new TreeView<Category>(rootItem);

        this.add(categoryTree, 0, 1);

    }
}
