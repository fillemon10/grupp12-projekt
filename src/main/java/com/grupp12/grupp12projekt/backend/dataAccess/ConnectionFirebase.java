package com.grupp12.grupp12projekt.backend.dataAccess;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.auth.oauth2.GoogleCredentials;

import com.google.firebase.database.DatabaseError;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConnectionFirebase {
    // Fetch the service account key JSON file contents
    private static final String DATABASE_URL = "https://good2go-c3e3a-default-rtdb.europe-west1.firebasedatabase.app/";
    private FirebaseDatabase firebaseDatabase;

    public ConnectionFirebase() throws FileNotFoundException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/com/grupp12/grupp12projekt/firebase/firebase_key.json");

        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(DATABASE_URL)
                    .build();
            FirebaseApp.initializeApp(options);
            firebaseDatabase = FirebaseDatabase.getInstance(DATABASE_URL);

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void update(Object value) {
        update(value, "testdata");
    }

    public void update(Object value, String key) {
        try {
            DatabaseReference ref = firebaseDatabase.getReference(key);
            final CountDownLatch latch = new CountDownLatch(1);
            ref.setValue(value, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError != null) {
                        System.out.println("Data could not be saved " + databaseError.getMessage());
                        latch.countDown();
                    } else {
                        System.out.println("Data saved successfully.");
                        latch.countDown();
                    }
                }
            });
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        firebaseDatabase.getApp().delete();
    }

}
