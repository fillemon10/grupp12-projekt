import com.grupp12.grupp12projekt.backend.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    Ingredient butter = new Ingredient(1, "Butter");
    Ingredient milk = new Ingredient(2, "Milk");
    Ingredient salt = new Ingredient(3, "Salt");
    Ingredient sugar = new Ingredient(4, "Sugar");
    Ingredient flour = new Ingredient(5, "Flour");
    Ingredient eggs = new Ingredient(6, "Eggs");
    Ingredient water = new Ingredient(0, "Water");
    Ingredient bakingSoda = new Ingredient(9, "Baking soda");

    Recipe makePancakes() {
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(butter);
        ingredients.add(milk);
        ingredients.add(salt);
        ingredients.add(sugar);
        ingredients.add(flour);
        ingredients.add(eggs);
        return new Recipe(123, "Pancakes", ingredients, "7");
    }

    Recipe makeStickBread() {
        List<Ingredient> stickBreadIngredients = new ArrayList<Ingredient>();
        stickBreadIngredients.add(flour);
        stickBreadIngredients.add(water);
        stickBreadIngredients.add(bakingSoda);

        return new Recipe(938, "Stick bread", stickBreadIngredients, "1");
    }

    boolean databaseContains(Recipe recipe, Database db) {
        boolean contains = false;

        for (Recipe r :
                db.getAllRecipes()) {
            if (r == recipe) {
                contains = true;
                break;
            }
        }

        return contains;
    }

    @Test
    public void getInstanceTest() {
        Database db = Database.getInstance();
        Database db2 = Database.getInstance();

        assertEquals(db, db2);
    }

    @Test
    public void addRecipeTest() {
        Database db = Database.getInstance();
        Recipe pancakes = makePancakes();
        Recipe stickBread = makeStickBread();
        db.addRecipe(pancakes);
        boolean containsPancakes = databaseContains(pancakes, db);
        boolean containsStickBread = databaseContains(stickBread, db);

        assertTrue(containsPancakes);
        assertFalse(containsStickBread);

        db.addRecipe(stickBread);
        containsStickBread = databaseContains(stickBread, db);

        assertTrue(containsStickBread);
    }

    @Test
    public void getAllRecipesTest() {
        Database db = Database.getInstance();
        Database db2 = Database.getInstance();

        Recipe pancakes = makePancakes();
        db.addRecipe(pancakes);

        Recipe stickBread = makeStickBread();
        db2.addRecipe(stickBread);

        assertEquals(db.getAllRecipes(), db2.getAllRecipes());
    }
}
