package problem2;

import java.io.*;
import java.util.*;

public class User implements Serializable {
    private String name;
    private String surname;
    private int age;

    public User() {
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public User(User user) {
        this.name = user.name;
        this.surname = user.surname;
        this.age = user.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void saveUser(File file) {

        List<User> users = getUsersFromFile(file);
        users.add(this);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            for (User user : users) {
                outputStream.writeObject(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> getUsersFromFile(File file) {

        List<User> users = new ArrayList<>();

        if (file.length() == 0) {
            return users;
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    User user = (User) inputStream.readObject();
                    users.add(user);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public String toString() {
        return "First Name: " + this.name +
                ", Last Name: " + this.surname + ", Age: " + this.age ;
    }
}
