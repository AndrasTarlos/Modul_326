
import employees.HRPerson;
import employees.Person;
import log.LogBook;
import log.UserAction;

import java.io.IOException;

public class LogTest {

    public static void main(String[]args) throws IOException {
        HRPerson hrp = new HRPerson("Max", "Muster");
        Person pe = new Person("Maila", "Maurer");

        hrp.writeLogEntry(pe, UserAction.CREATE_PERSON);
        hrp.writeLogEntry(pe, UserAction.SET_ASSIGNMENT);
        hrp.writeLogEntry(pe,UserAction.CHANGE_VALUE);
        hrp.writeLogEntry(pe, -1);
        hrp.writeLogEntry(pe, UserAction.DELETE_PERSON);

        LogBook.getLogBookInstance().printLog();
    }
}
