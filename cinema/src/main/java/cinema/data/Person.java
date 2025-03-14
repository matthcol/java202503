package cinema.data;

import java.text.MessageFormat;
import java.time.LocalDate;

public class Person {
    private int id;
    private String name;
    private LocalDate birthdate;

    public Person() {
    }

    public Person(int id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override // redéfinition ou implémentation
    public String toString() {
       return MessageFormat.format(
               "{0} ({1})#{2}",
               name, birthdate, id
       );
    }
}
