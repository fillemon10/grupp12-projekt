import com.grupp12.grupp12projekt.backend.Ingredient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @Test
    void getId() {
        Ingredient ing = new Ingredient();
        ing.setId(1);
        assertEquals(1, ing.getId());
    }

    @Test
    void getName() {
        Ingredient ing = new Ingredient();
        ing.setName("turkey");
        assertEquals("turkey", ing.getName());
    }

    @Test
    void setId() {
        Ingredient ing = new Ingredient();
        ing.setId(1);
        assertEquals(1, ing.getId());
    }

    @Test
    void setName() {
        Ingredient ing = new Ingredient();
        ing.setName("turkey");
        assertEquals("turkey", ing.getName());
    }
}