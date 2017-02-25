package cz.rbenes.kukbuk.database.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import sun.util.resources.cldr.tg.CalendarData_tg_Cyrl_TJ;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rostik on 4.2.17.
 */
@Entity
@Table(name = "category")
@Access(AccessType.FIELD)
public class Category extends BaseEntity {
    @NotNull
    @Size(min = 2, max = 255)
    private String name;

    @Size(min = 2, max = 2000)
    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    Set<Recipe> recipes;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parentCategory", cascade = CascadeType.ALL)
    Set<Category> subCategories;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    Category parentCategory;

    public Category() {
        recipes = new HashSet<>();
        subCategories = new HashSet<>();
    }

    public Category(String name, String description, Set<Recipe> recipes) {
        recipes = new HashSet<>();
        subCategories = new HashSet<>();
        this.name = name;
        this.description = description;
        this.recipes = recipes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        if (recipe == null) {
            throw new NullPointerException("Can't add null Recipe");
        }
        if (recipe.getCategory() != null) {
            throw new IllegalStateException("Recipe is already in category " + recipe.getCategory());
        }
        getRecipes().add(recipe);
        recipe.setCategory(this);
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public void addCategory(Category category) {
        if (category == null) {
            throw new NullPointerException("Can't add null Category");
        }
        if (category.getParentCategory() != null) {
            throw new IllegalStateException("Category is already parent of category " + category.getParentCategory());
        }
        getSubCategories().add(category);
        category.setParentCategory(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
