import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.Storage;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RecipeTest {

    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    private Ingredient butter = new Ingredient(123, "Butter");
    private Ingredient milk = new Ingredient(123, "Milk");



    @Test
    public void checkIfContains() {
        ingredients.add(butter);
        ingredients.add(milk);
        Recipe recipe = new Recipe(123, "Butter and milk", ingredients, "7");

        assertTrue(recipe.getContents().contains(butter));

    }

    @Test
    public void checkIfNotContains() {
        ingredients.add(butter);
        ingredients.add(milk);
        Recipe recipe = new Recipe(123, "Butter and milk", ingredients, "7");

        Ingredient salt = new Ingredient(123, "Salt");

        assertFalse(recipe.getContents().contains(salt));
    }

}
