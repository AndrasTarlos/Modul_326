package employees;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Locale;

/**
 * Person
 * author: Tarlos Andras
 * version: 1.0
 * date: 01.12.2022
 * description: This model class includes methods for all Person
 * and makes sure that every data is saved correctly.
 */
@Getter
@Setter
public class Person implements Comparable<Person> {
    //private byte[] photo;
    private String firstName;
    private String lastName;
    private Participation participation;
    private String departmentName;

    /**
     * Default constructor of Person
     */
    public Person() {}

    /**
     * Advanced constructor of Person
     * @param firstName the first part of a persons name
     * @param lastName the first part of a persons name
     * @param departmentName the department name the persons belongs to (only one)
     */
    public Person(String firstName, String lastName, String departmentName) {
        setFirstName(firstName);
        setLastName(lastName);
        setDepartmentName(departmentName);
        //setPhoto(photo);
    }

    /**
     * Tests if a person is an HRPerson or a plain Person (office worker)
     * @param person the person to be observed
     * @return a boolean value depending on the Persons type
     */
    public boolean getIsPerson(HRPerson person) {
        if (person.getModus() == 0 && person.getPwd() == null) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(@NotNull Person p) {
        return firstName.compareTo(p.getFirstName());
    }

    public static Comparator<Person> compareAscending() {
        return new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFirstName().toUpperCase(Locale.ROOT).compareTo(o2.getFirstName().toUpperCase(Locale.ROOT));
            }
        };
    }

    public static Comparator<Person> compareReversed() {
        return new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFirstName().toUpperCase(Locale.ROOT).compareTo(o2.getFirstName().toUpperCase(Locale.ROOT)) - 2;
            }
        };
    }
}