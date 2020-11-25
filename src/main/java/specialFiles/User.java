package specialFiles;

import java.util.Comparator;

public class User {

    private String name;
    private String surName;
    private int age;

/*    public void setName(String name){
        this.name=name;
    }

    public void setAge (int age){
        this.age=age;
    }*/

    public User(String name,String surName, int age){
        this.name=name;
        this.surName=surName;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSurName(){
        return surName;
    }



    @Override
    public String toString() {
        return "User{" +
                "nameOfUser='" + name + '\'' +
                ", nameOfUser='" + surName + '\'' +
                ", ageOfUser='" + age + '\'' +
               '}';
    }
}
