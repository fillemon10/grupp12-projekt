import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.grupp12.grupp12projekt.backend.Model;

public class ModelTest {
    Model model = Model.getInstance();



    @Test
    public void getStorageContentTest(){
        model.logInUser("1","1");
        Assertions.assertTrue(model.getStorageContent().size() > 0);
    }

    @Test
    public void get20bestMatchingRecipesTest(){
        model.logInUser("1","1");

        Assertions.assertTrue(model.get20bestMatchingRecipes(model.getAllRecipes()).size() == 20);



    }

    @Test
    public void getMatchingIngredientsTest(){
        model.logInUser("1","1");
        Recipe r =  model.getAllRecipes().get(241);
        Assertions.assertTrue(model.getMatchingIngredients(r).size() > 0);


    }

    @Test
    public void getMatchingPercentageTest(){
        model.logInUser("1","1");
        Recipe r =  model.getAllRecipes().get(241);
        Assertions.assertEquals(0.25, model.getMatchingPercentage(r));
    }

    @Test
    public void getFilteredRecipesTest(){
        model.logInUser("1","1");
        Assertions.assertTrue(model.getFilteredRecipes().size() > 0);
    }

    @Test
    public void findIngredientsTest(){
        model.logInUser("1","1");
        Assertions.assertTrue(model.findIngredients("al").size() > 0);

    }

    @Test
    public void getCurrentUsersStorageIDTest(){
        model.logInUser("1","1");
        Assertions.assertTrue(model.getCurrentUsersStorageID() > 0);
    }

    @Test
    public void getIngredientsNotInStorageTest(){
        model.logInUser("1","1");
        Assertions.assertTrue(model.getIngredientsNotInStorage().size() > 0);


    }


    @Test
    void getInstance() {
        fail();
    }

    @Test
    void setCurrentUserStorageId() {
    }

    @Test
    void getStorage() {
    }

    @Test
    void getStorageContent() {
    }

    @Test
    void deleteStorageIngredient() {
    }

    @Test
    void get20bestMatchingRecipes() {
    }

    @Test
    void getMatchingIngredients() {
    }

    @Test
    void getMatchingPercentage() {
    }

    @Test
    void getAllRecipes() {
    }

    @Test
    void getFilteredRecipes() {
    }

    @Test
    void findIngredients() {
    }

    @Test
    void filterByIngredient() {
    }

    @Test
    void addObserver() {
    }

    @Test
    void removeObserver() {
    }

    @Test
    void clearObservers() {
    }

    @Test
    void notifyObservers() {
    }

    @Test
    void createNewUser() {
    }

    @Test
    void logInUser() {
    }

    @Test
    void getCurrentUser() {
    }

    @Test
    void addIngredientToStorage() {
    }

    @Test
    void getCurrentUsersStorageID() {
    }

    @Test
    void getIngredientsNotInStorage() {
    }

    @Test
    void logout() {
    }
}
