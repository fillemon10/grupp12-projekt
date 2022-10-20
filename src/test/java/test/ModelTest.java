import com.grupp12.grupp12projekt.Observable;
import com.grupp12.grupp12projekt.Observer;
import com.grupp12.grupp12projekt.backend.*;
import com.grupp12.grupp12projekt.viewsAndControllers.StoragePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

public class ModelTest {
    Model model = Model.getInstance();
    private static class TestClass implements Observer{
        String string;

        TestClass(Model model){
            model.addObserver(this);
        }

        public void onNotify() {
            string = "notified";
        }
    }

    @Test
    void getStorageContent(){
        model.logInUser("1","1");
        Assertions.assertTrue(model.getStorageContent().size() > 0);
    }

    @Test
    void get20bestMatchingRecipes(){
        model.logInUser("1","1");

        assertEquals(20, model.get20bestMatchingRecipes(model.getAllRecipes()).size());

    }

    @Test
    void getMatchingIngredients(){
        model.logInUser("1","1");
        Recipe r =  model.getAllRecipes().get(241);
         Assertions.assertTrue(model.getMatchingIngredients(r).size() == 0);


    }

    @Test
    void getMatchingPercentage(){
        model.logInUser("1","1");
        Recipe r =  model.getAllRecipes().get(241);
        Assertions.assertEquals(0, model.getMatchingPercentage(r));
    }

    @Test
    void getFilteredRecipes(){
        model.logInUser("1","1");
        Assertions.assertTrue(model.getFilteredRecipes().size() > 0);
    }

    @Test
    void findIngredients(){
        model.logInUser("1","1");
        Assertions.assertTrue(model.findIngredients("al").size() > 0);

    }

    @Test
    void getCurrentUsersStorageID(){
        model.logInUser("1","1");
        Assertions.assertTrue(model.getCurrentUsersStorageID() > 0);
    }

    @Test
    void getIngredientsNotInStorage(){
        model.logInUser("1","1");
        Assertions.assertTrue(model.getIngredientsNotInStorage().size() > 0);


    }

    @Test
    void setCurrentUserStorageId() {
        model.logInUser("1","1");
        model.setCurrentUserStorageId(12);
        assertEquals(12, model.getStorage().getId());
    }

    @Test
    void getStorage() {
        model.logInUser("1", "1");
        Storage storage = model.getStorage();
        assertEquals(storage.getId(), model.getStorage().getId());

        String string = "";
        try {
            model.setCurrentUserStorageId(40000);
        } catch (IllegalArgumentException e) {
            string = e.getMessage();
        }
        assertEquals(string, "Storage does not exist.");
    }

    @Test
    void deleteStorageIngredient() {
        model.logInUser("1","1");
        int before = model.getStorage().getIngredients().size();
        Ingredient ingredient = model.getStorage().getIngredients().get(1);
        model.deleteStorageIngredient(ingredient);
        assertTrue(before > model.getStorage().getIngredients().size());
    }

    @Test
    void getAllRecipes() {
        assertTrue(model.getAllRecipes().size() > 4000);
    }

    @Test
    void filterByIngredient() {
        Model model = Model.getInstance();
        TestClass testObserver = new TestClass(model);
        model.filterByIngredient(model.getIngredientsNotInStorage().get(0));
        assertNotEquals(model.getFilteredRecipes(),model.getAllRecipes());
        assertEquals(testObserver.string, "notified");
    }

    @Test
    void addObserver() {
        TestClass testClass = new TestClass(model);
        model.addObserver(testClass);
        //assertEquals();
    }

    @Test
    void removeObserver() {
        TestClass testObserver = new TestClass(model);
        model.notifyObservers();
        assertEquals(testObserver.string, "notified");
        testObserver.string = "";

        model.removeObserver(testObserver);
        model.notifyObservers();
        assertNotEquals(testObserver.string, "notified");

    }

    @Test
    void createNewUser() {
        String string = "";
        try {
            model.createNewUser("helloperson", "hellopassword");
        } catch (IllegalArgumentException e) {
            string = e.getMessage();
        }
        assertEquals(string, "Username already exists!");
        String username = getRandomString(6);
        String password = getRandomString(6);
        model.createNewUser(username, password);
        assertEquals(model.getCurrentUser().getUsername(), username);
    }


    @Test
    void logInUser() {
        model.logInUser("1", "1");
        assertEquals("1", model.getCurrentUser().getUsername());
        assertThrows(IllegalArgumentException.class, () -> model.logInUser("hanna", "filip"));
    }

    @Test
    void getCurrentUser()
    {model.logInUser("1","1");
        assertEquals("1", model.getCurrentUser().getUsername());
    }

    @Test
    void addIngredientToStorage() {
        model.logInUser("1", "1");
        int sizeBefore = model.getStorageContent().size();
        Ingredient brocoli = new Ingredient();
        brocoli.setName("broccoli");
        brocoli.setId(56);
        model.addIngredientToStorage(brocoli);
        int sizeAfter =  model.getStorageContent().size();
        assertTrue(sizeAfter == sizeBefore + 1);



    }

    @Test
    void logout() {
        model.logInUser("1", "1");
        model.logout();
        assertEquals(model.getCurrentUser(),null);

    }


    private String getRandomString(int i) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < i) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
