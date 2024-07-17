package org.example;


import org.mindrot.jbcrypt.BCrypt;

public class UserManager {

    public static void registerUser(String username, String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        Database.registerUser(username, hashedPassword);
    }

    public static boolean authenticateUser(String username, String password) {
        String storedHashedPassword = Database.getUserPassword(username);
        return storedHashedPassword != null && BCrypt.checkpw(password, storedHashedPassword);
    }
}

