import com.grupp12.grupp12projekt.backend.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getUsername() {
        User user = new User();
        user.setUsername("Hej");
        assertEquals("Hej", user.getUsername());
    }

    @Test
    void setUsername() {
        User user = new User();
        user.setUsername("Hej");
        assertEquals("Hej", user.getUsername());
    }

    @Test
    void getPassword() {
        User user = new User();
        user.setPassword("hej");
        assertEquals("hej", user.getPassword());
    }

    @Test
    void setPassword() {
        User user = new User();
        user.setPassword("hej");
        assertEquals("hej", user.getPassword());
    }

    @Test
    void getId() {
        User user = new User();
        user.setId(5);
        assertEquals(5, user.getId());
    }

    @Test
    void setId() {
        User user = new User();
        user.setId(5);
        assertEquals(5, user.getId());
    }

    @Test
    void getStorageID() {
        User user = new User();
        user.setStorageID(18);
        assertEquals(18, user.getStorageID());
    }

    @Test
    void setStorageID() {
        User user = new User();
        user.setStorageID(18);
        assertEquals(18, user.getStorageID());
    }
}