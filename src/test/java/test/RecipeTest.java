
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void getId() {
        Recipe recipe = new Recipe();
        recipe.setId(1);
        assertEquals(1, recipe.getId());
    }

    @Test
    void setId() {
        Recipe recipe = new Recipe();
        recipe.setId(1);
        assertEquals(1, recipe.getId());
    }

    @Test
    void getName() {
        Recipe recipe = new Recipe();
        recipe.setName("turkey and pasta");
        assertEquals("turkey and pasta", recipe.getName());
    }

    @Test
    void setName() {
        Recipe recipe = new Recipe();
        recipe.setName("turkey and pasta");
        assertEquals("turkey and pasta", recipe.getName());
    }

    @Test
    void getIngredients() {
        Recipe recipe = new Recipe();
        Ingredient ing1 = new Ingredient();
        Ingredient ing2 = new Ingredient();
        Ingredient ing3 = new Ingredient();
        List<Ingredient> inglist = new ArrayList<>();
        inglist.add(ing1);
        inglist.add(ing2);
        inglist.add(ing3);
        recipe.setIngredients(inglist);

        assertEquals(3, recipe.getIngredients().size());
    }

    @Test
    void setIngredients() {
        Recipe recipe = new Recipe();
        Ingredient ing1 = new Ingredient();
        Ingredient ing2 = new Ingredient();
        Ingredient ing3 = new Ingredient();
        List<Ingredient> inglist = new ArrayList<>();
        inglist.add(ing1);
        inglist.add(ing2);
        inglist.add(ing3);
        recipe.setIngredients(inglist);

        assertEquals(3, recipe.getIngredients().size());
    }

    @Test
    void getRating() {
        Recipe recipe = new Recipe();
        recipe.setRating("3");
        assertEquals("3", recipe.getRating());

    }

    @Test
    void setRating() {
        Recipe recipe = new Recipe();
        recipe.setRating("3");
        assertEquals("3", recipe.getRating());
    }

    @Test
    void containsIngredient() {
        Recipe recipe = new Recipe();
        Ingredient ing1 = new Ingredient();
        ing1.setId(1);
        Ingredient ing2 = new Ingredient();
        ing2.setId(2);
        Ingredient ing3 = new Ingredient();
        ing3.setId(3);
        List<Ingredient> inglist = new ArrayList<>();
        inglist.add(ing1);
        inglist.add(ing2);
        inglist.add(ing3);
        recipe.setIngredients(inglist);







    }
}