package objectsort;

public class User implements Comparable<User> {
    private int age;
    private String name;
    public User (){}
    public User (int age, String name){
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(User o) {
        return this.age - o.age;
    }
    @Override
    public String toString() {
        return "[user={age=" + age + ",name=" + name + "}]";
    }
}