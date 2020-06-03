package objectsort;

import java.util.*;

public class ComparableTest {
    public static void main(String[] args) {
        User u1 = new User(12, "xiaohua");
        User u2 = new User(10, "abc");
        User u3 = new User(15,"ccc");
        User[] users = {u1,u2,u3};
        System.out.print("数组排序前：");
        printArray(users);
        System.out.println();
//        Arrays.sort(users);
//        System.out.print("数组排序1后：");
//        printArray(users);
//        System.out.println();

        System.out.print("数组排序2后：");
        Arrays.sort(users, Comparator.reverseOrder());
        printArray(users);

        ArrayList<User> list = new ArrayList<>(users.length);
        Collections.addAll(list, users);
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println();
        System.out.println("list排序后");
        list.forEach(System.out::print);
    }

    public static void printArray (User[] users) {
        for (User user:users) {
            System.out.print(user.toString());
        }
    }
}
