import com.grupp12.grupp12projekt.backend.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getUsername() {
        User user = new User();
        user.setUsername("Hej");
        Assertions.assertTrue(user.getUsername().equals("Hej"));
    }

    @Test
    void setUsername() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void setPassword() {
    }

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getStorageID() {
    }

    @Test
    void setStorageID() {
    }
}