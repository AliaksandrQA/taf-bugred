package by.academy.util;

public class User {
    private String name;
    private String email;
    private String password;


    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String generateRandomUserData() {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String result = "";
        for (int i = 0; i < 5; i++) {

            result += abc.charAt((int) (Math.random() * abc.length()));
        }
        return result;
    }
    public static String generateRandomUserEmail() {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String siteDomain = "@tut.by";
        String result = "";
        for (int i = 0; i < 5; i++) {

            result += abc.charAt((int) (Math.random() * abc.length()));
        }
        return result + siteDomain;
    }
}