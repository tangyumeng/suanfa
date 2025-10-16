package base.test;


import java.util.HashSet;
import java.util.Objects;

// 假设我们有一个Person类，只重写了equals，没有重写hashCode
class Person {
    private String name;
    private int age;

    // 构造函数...

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    // 没有重写hashCode - 这是错误的！
    @Override
    public int hashCode() {
        return Objects.hash(name, age); // 使用相同的字段计算hashCode
    }
}

public class TestEqual {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Alice", 25);

        System.out.println(p1.equals(p2)); // true - equals认为它们相等

        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);

        System.out.println(set.size()); // 2 - 但HashSet认为它们不同！
        System.out.println(set.contains(p2)); // 可能返回false！
    }
}
