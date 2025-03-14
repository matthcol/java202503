package demo.cinema.data;

import cinema.data.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.Stream;

class PersonDemo {

    @Test
    void demoPersonDefault(){
        var person = new Person(); // default constructor
        System.out.println(person);

        person.setName("Charlie Chaplin");
        System.out.println(person);
        System.out.println(person.getName());
    }

    @Test
    void demoPersonAllArgsConstructor(){
        var person1 = new Person(1, "Charlie Chaplin", LocalDate.of(1899, 4, 16));
        var person2 = new Person(2, "Grace Kelly", null);

        Stream.of(person1, person2)
                .forEach(System.out::println);
    }

}