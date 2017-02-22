package cz.rbenes.kukbuk.database.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by rostik on 13.2.17.
 */
@Entity
@Table(name = "ingredient")
@Access(AccessType.FIELD)
public class Ingredient extends BaseEntity {

    @NotNull
    @Size(min = 2, max = 255)
    private String name;

    @NotNull
    @Size(min = 2, max = 255)
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;


    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
