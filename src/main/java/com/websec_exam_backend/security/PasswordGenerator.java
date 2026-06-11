package com.websec_exam_backend.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

/* for testing */
public class PasswordGenerator {
    public static void main(String[] args) {

        HashMap<String, String> users = new HashMap<>();
        users.put("ramesh", "ramesh");
        users.put("sofia", "sofia");
        users.put("liam", "liam");
        users.put("eva", "eva");
        users.put("noah", "noah");
        users.put("oliver", "oliver");
        users.put("freja", "freja");
        users.put("ida", "ida");
        users.put("william", "william");
        users.put("emil", "emil");
        users.put("nanna", "nanna");
        users.put("kasper", "kasper");
        users.put("aline", "aline");
        users.put("jonas", "jonas");
        users.put("mathilde", "mathilde");
        users.put("viktor", "viktor");
        users.put("laura", "laura");
        users.put("simon", "simon");
        users.put("guest", "guest");

        PasswordGenerator generator = new PasswordGenerator();
        int i = 2;
        for (Map.Entry<String, String> userEntry : users.entrySet()) {
            System.out.println(generator.printPasswordWithUsername(userEntry.getKey(), userEntry.getValue(), i++));
        }
    }

    String printPasswordWithUsername(String username, String password, int i) {
        // Helper output for SQL seed creation; not used by the authentication runtime.
        return "(" + (i) + ", '" + new BCryptPasswordEncoder().encode(password) + "', '" + username + "', UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'), 2),";
    }
}
