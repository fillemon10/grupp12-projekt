import com.grupp12.grupp12projekt.backend.Model;
import com.grupp12.grupp12projekt.backend.Storage;
import com.grupp12.grupp12projekt.backend.StorageHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StorageHandlerTest {
    Model model = Model.getInstance();

    @Test
    void getStorageFromDatabase() {
        Storage storage = new Storage();
        //assertThrows(IllegalArgumentException.class, () -> storage.setId(55555));

    }

}