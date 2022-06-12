package employees;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    //private byte[] photo;
    private String firstName;
    private String lastName;
    private Participation participation;
    private String departmentName;

    public Person() {}

    public Person(String firstName, String lastName, String departmentName) {
        setFirstName(firstName);
        setLastName(lastName);
        setDepartmentName(departmentName);
        //setPhoto(photo);
    }

    public boolean getIsPerson(HRPerson person) {
        if (person.getModus() == 0 && person.getPwd() == null) {
            return true;
        }
        return false;
    }
}