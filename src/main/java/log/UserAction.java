package log;

import employees.HRPerson;
import employees.Person;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class UserAction {
    public static final int CREATE_PERSON = 0;
    public static final int CHANGE_VALUE = 1;
    public static final int SET_ASSIGNMENT = 2;
    public static final int DELETE_PERSON = 3;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private String[] actionDescription = {"Person erstellt", "Daten verändert", "Aufgabe gesetzt", "Person gelöscht"};
    private String entry;

    public UserAction(HRPerson hrPerson, Person person, int action) {
        String firstName = hrPerson.getFirstName();
        String lastName = hrPerson.getLastName();

        LocalDateTime now = LocalDateTime.now();
        String fN = person.getFirstName();
        String lN = person.getLastName();
        if (action >= 0 && action < actionDescription.length ) {
            entry = dtf.format(now) + " Von: " + firstName + " " + lastName + " | Aktion: "
                    + actionDescription[action] + " | Person: " + fN + " " + lN;
        } else {
            entry = dtf.format(now) + " Von: " + firstName + " " + lastName + " | Aktion: Unbekannte Aktion "
                    + "| Person: " + fN + " " + lN;
        }
    }

    public String getEntry() {
        return entry;
    }
}
