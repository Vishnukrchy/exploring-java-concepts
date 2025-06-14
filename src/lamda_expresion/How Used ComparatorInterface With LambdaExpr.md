# How To Use Comparator Interface With Lambda Expression

Before Java 8, the `Comparator` interface was used to compare two objects by implementing its `compare` method. With the introduction of lambda expressions in Java 8, we can simplify the implementation of the `Comparator` interface.

// Traditional Comparator Interface Implementation
```java
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class MyComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Without using lambda expression
        Collections.sort(people, new MyComparator());

        // Using Comparator with Lambda Expression
        Collections.sort(people, (p1, p2) -> p1.getAge() - p2.getAge());

        // Displaying sorted list
        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}