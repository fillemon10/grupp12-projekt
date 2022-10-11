
import com.grupp12.grupp12projekt.backend.Ingredient;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class IngredientTest {
    Ingredient ingredient = new Ingredient(123, "Flour");

    @Test
    public void getNameTest() {
        assertEquals(ingredient.getName(), "Flour");
    }

    @Test
    public void getIDTest() {
        assertEquals(ingredient.getID(), 123);
    }
}
