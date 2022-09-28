import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.User;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

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

    @Test
    public void saveUser() {
        Model model = new Model(myUser, null, null);
        model.saveUser();
        try {
            File myObj = new File("src/main/resources/loginDetails.txt");
            Scanner myReader = new Scanner(myObj);
            assertEquals(myReader.nextLine(), "Rikard");
            assertEquals(myReader.nextLine(), "1234");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
