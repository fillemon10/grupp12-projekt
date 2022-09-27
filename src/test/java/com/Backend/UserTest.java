import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {
    ArrayList<Recipe> favorites = new ArrayList<>();
    User myUser = new User(1234, "Rikard", "1234", 1234, favorites);
    Ingredient butter = new Ingredient(123, "Butter");
    Ingredient milk = new Ingredient(123, "Milk");
    List<Ingredient> ingredients = new ArrayList<Ingredient>();

    @Test
    public void addRecipeToFavoritesList() {
        ingredients.add(butter);
        ingredients.add(milk);

        Recipe recipe = new Recipe(123, "Butter and milk", ingredients, "7");
        myUser.addRecipeToFavorite(recipe);

        assertTrue(myUser.getFavorites().contains(recipe));
    }

    @Test
    public void removeRecipeFromFavoritesList() {
        ingredients.add(butter);
        ingredients.add(milk);

        Recipe recipe = new Recipe(123, "Butter and milk", ingredients, "7");
        myUser.addRecipeToFavorite(recipe);
        myUser.removeRecipeFromFavorites(recipe);

        assertFalse(myUser.getFavorites().contains(recipe));
    }

}
