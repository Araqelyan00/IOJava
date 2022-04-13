package problem2;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("file.txt");

        User[] users = new User[]{
                new User("Name", "Surname", 21),
                new User("Name", "Surname", 30),
                new User("Name", "Surname", 40),
        };

        for (User user : users) {
            user.saveUser(file);
        }

        List<User> usersList = User.getUsersFromFile(file);

        for (User user : usersList) {
            System.out.println(user);
        }

    }
}
