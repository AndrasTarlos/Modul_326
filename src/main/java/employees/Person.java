package employees;

import lombok.Getter;
import lombok.Setter;

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
public class Person {
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
}