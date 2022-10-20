import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Storage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    @Test
    void getId() {
        Storage storage = new Storage();
        storage.setId(5);
        assertEquals(5, storage.getId());
    }

    @Test
    void setId() {
        Storage storage = new Storage();
        storage.setId(5);
        assertEquals(5, storage.getId());
    }

    @Test
    void getIngredients() {
        Storage storage = new Storage();
        Ingredient ingredient = new Ingredient();
        ingredient.setName("hej");
        List<Ingredient> list = new ArrayList<>();
        list.add(ingredient);
        storage.setIngredients(list);
        assertEquals(list.get(0).getName(), storage.getIngredients().get(0).getName());
    }

    @Test
    void setIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Butter");
        ingredient.setId(2);
        ingredients.add(ingredient);
        Storage storage = new Storage();
        storage.setIngredients(ingredients);
        assertEquals(storage.getIngredients().size(), ingredients.size());
    }

    @Test
    void addIngredient() {
        Storage storage = new Storage();
        Ingredient ingredient = new Ingredient();
        ingredient.setName("hej");
        List<Ingredient> list = new ArrayList<>();
        storage.setIngredients(list);
        list.add(ingredient);
        storage.addIngredient(ingredient);
        assertEquals(list.get(0).getName(), storage.getIngredients().get(0).getName());
    }

    @Test
    void removeIngredient() {
        Storage storage = new Storage();
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredients.add(ingredient);
        storage.setIngredients(ingredients);
        storage.removeIngredient(ingredient);
        assertTrue(storage.getIngredients().isEmpty());
    }

    @Test
    void containsIngredient() {
        Storage storage = new Storage();
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredients.add(ingredient);
        storage.setIngredients(ingredients);
        assertTrue(storage.containsIngredient(ingredient));
    }
}