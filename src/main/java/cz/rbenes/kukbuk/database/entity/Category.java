package cz.rbenes.kukbuk.database.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
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

//    @Size(min = 2, max = 2000)
//    @Column(name = "description")
//    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    Set<Recipe> recipes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

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


}
