package abTest;

import specialFiles.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingOfList {
    public static void main(String[] args) {
        List<User>  users= Arrays.asList(
                new User("Maksim","Ivanov",14),
                new User("Sergey","Petrov",30),
                new User("Pavel","Ivanov",25),
                new User("Maksim","Sidorov",34));

        System.out.println("Before sort:");
        for (User user : users) {
            System.out.println(user);
        }

       // Collections.sort(users,((o1, o2) -> o1.getAge()-o2.getAge()));

        Comparator<User> userComparator = Comparator.comparing((User p) ->"Ivanov".equals(p.getSurName())? -1:0).thenComparing(User::getAge).thenComparing(User::getName);
       users.sort(userComparator);

      //  users.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));
        System.out.println("---------------------");
        System.out.println("\nAfter sort:");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
