import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Storage;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StorageTest {
    ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    Storage myStorage = new Storage(124, 1234, ingredients);

    @Test
    public void addIngredientToStorage() {
        Ingredient butter = new Ingredient(123, "Butter");
        myStorage.addIngredient(butter);

        assertTrue(myStorage.getContents().contains(butter));
    }

    @Test
    public void removeIngredientFromStorage() {
        Ingredient butter = new Ingredient(123, "Butter");
        Ingredient milk = new Ingredient(123, "Milk");
        myStorage.addIngredient(butter);
        myStorage.addIngredient(milk);
        myStorage.removeIngredient(butter);

        assertFalse(myStorage.getContents().contains(butter));

    }
}
