package cz.rbenes.kukbuk.database.dao;

import cz.rbenes.kukbuk.database.entity.Category;
import cz.rbenes.kukbuk.database.entity.Recipe;

import java.time.Duration;
import java.util.*;

/**
 * Created by rostik on 23.2.17.
 */
public class CategoryTestData {

    public static Category getChickenCategory() {
        Category chickenCtg = new Category();
        chickenCtg.setName("Chicken");
        chickenCtg.setDescription("All you can do from this half-bird.");

        List<Recipe> recipes = getChickenRecipes();
        chickenCtg.addRecipe(recipes.get(0));
        chickenCtg.addRecipe(recipes.get(1));
        return chickenCtg;
    }

    public static List<Recipe> getChickenRecipes() {
        Recipe recipe1 = new Recipe("Grilled Chicken", "Make chicken grilled", "Delicious meat", 2,
                Duration.ofMinutes(50), 2, 3, new HashSet<>(), new HashSet<>());
        Recipe recipe2 = new Recipe("Cooked Chicken", "Make chicken cooked", "Not so delicious meat", 2,
                Duration.ofMinutes(60), 1, 1, new HashSet<>(), new HashSet<>());
        List<Recipe> recipes = new ArrayList<>();
        recipes.addAll(Arrays.asList(recipe1, recipe2));
        return recipes;
    }

    public static Category getPorkCategory() {
        Category porkCtg = new Category();
        porkCtg.setName("Pork");
        porkCtg.setDescription("All you can do from this pig.");
        List<Recipe> recipes =getPorkRecipes();

        porkCtg.addRecipe(recipes.get(0));
        porkCtg.addRecipe(recipes.get(1));
        return porkCtg;
    }

    public static List<Recipe> getPorkRecipes() {
        Recipe recipe1 = new Recipe("Grilled pork", "Make pork grilled", "Delicious meat", 2,
                Duration.ofMinutes(80), 2, 3, new HashSet<>(), new HashSet<>());
        Recipe recipe2 = new Recipe("Cooked pork", "Make pork cooked", "Not so delicious meat", 2,
                Duration.ofMinutes(90), 1, 1, new HashSet<>(), new HashSet<>());
        List<Recipe> recipes = new ArrayList<>();
        recipes.addAll(Arrays.asList(recipe1, recipe2));
        return recipes;
    }

    public static Category getNestedCategories() {
        Category root = new Category("Meat", "Delicious fod from meat", Collections.emptySet());
        Category pork = getPorkCategory();
        Category chicken = getChickenCategory();
        root.addCategory(pork);
        root.addCategory(chicken);

        return root;
    }
}
