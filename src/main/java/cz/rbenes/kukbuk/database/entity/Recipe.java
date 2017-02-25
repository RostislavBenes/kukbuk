package cz.rbenes.kukbuk.database.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rostik on 13.2.17.
 */
//TODO: pridat typ jidla: maso, vegetarian, vegan. Asi enum
@Entity
@Table(name = "recipe")
@Access(AccessType.FIELD)
public class Recipe extends BaseEntity {
    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull
    @Size(min = 2, max = 5000)
    private String procedure;

    @Size(min = 2, max = 5000)
    private String comment;

    @Min(0)
    @Max(255)
    @Column(name = "serving_count")
    private int servingCount;

    @Column(name = "preparation_time")
    private Duration preparationTime;

    @Min(0)
    @Max(5)
    private int difficulty;

    @Min(0)
    @Max(5)
    private int rating;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<MealImage> mealImages;

    public Recipe() {
        ingredients = new HashSet<>();
        mealImages = new HashSet<>();
    }

    public Recipe(String name, String procedure, String comment, int servingCount, Duration preparationTime,
                  int difficulty, int rating, Set<Ingredient> ingredients, Set<MealImage> mealImages) {
        this.name = name;
        this.procedure = procedure;
        this.comment = comment;
        this.servingCount = servingCount;
        this.preparationTime = preparationTime;
        this.difficulty = difficulty;
        this.rating = rating;
        this.ingredients = ingredients;
        this.mealImages = mealImages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getServingCount() {
        return servingCount;
    }

    public void setServingCount(int servingCount) {
        this.servingCount = servingCount;
    }

    public Duration getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Duration preparationTime) {
        this.preparationTime = preparationTime;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Set<MealImage> getMealImages() {
        return mealImages;
    }

    public void addMealImage(MealImage mealImage) {
        if (mealImage == null) {
            throw new NullPointerException("Can't add null meal image");
        }
        if (mealImage.getRecipe() != null) {
            throw new IllegalStateException("Meal image is already set for recipe" + mealImage.getRecipe());
        }
        getMealImages().add(mealImage);
        mealImage.setRecipe(this);
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        if (ingredient == null) {
            throw new NullPointerException("Can't add null ingredient");
        }
        if (ingredient.getRecipe() != null) {
            throw new IllegalStateException("Ingredient is already set for recipe" + ingredient.getRecipe());
        }
        getIngredients().add(ingredient);
        ingredient.setRecipe(this);
    }
}
