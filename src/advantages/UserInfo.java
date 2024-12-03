package advantages;

import java.util.Locale;

public class UserInfo {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String description;

    public UserInfo(int id, String name, String surname, int age, String description) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void printDescription() {
        if (description != null) {
            System.out.println("description is " + description);
        }
    }

    public static void main(String args[]){
        User user = new User(7, "James", "Bond", 37, "Secret Agent");
        user.printDescription();
        Utils.printUpperCase(user.getName());
    }
 }

 class Utils{
    static void printUpperCase(String text){
        if(text != null){
            System.out.println("text in upperCase:  "+text.toUpperCase(Locale.getDefault()));
        }
    }
 }
