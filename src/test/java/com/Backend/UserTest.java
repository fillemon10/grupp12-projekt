import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.User;
import com.grupp12.grupp12projekt.backend.UserDataAccess;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class UserTest {
    ArrayList<Recipe> favorites = new ArrayList<>();
    User myUser = new User();
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

    @Test
    public void saveUser() {
        UserDataAccess userDataAccess = new UserDataAccess();
        myUser.setUsername("TestUser");
        myUser.setPassword("123");
        myUser.setStorageID(123);
        myUser.setFavorites(favorites);
        userDataAccess.save(myUser);
        assertTrue(userDataAccess.get(myUser.getID()).equals(myUser));
    }

}
