package cz.rbenes.kukbuk.database.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by rostik on 13.2.17.
 */
@Entity
@Table(name = "meal_image")
@Access(AccessType.FIELD)
public class MealImage extends BaseEntity {

    @NotNull
    private byte[] image;

    @Size(min = 2, max = 1000)
    private String description;

    @NotNull
    private int width;

    @NotNull
    private int height;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
