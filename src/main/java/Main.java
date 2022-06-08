import employees.HRPerson;
import employees.Person;
import log.LogBook;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	    LogBook log = LogBook.getLogBookInstance();
        HRPerson hrPerson = new HRPerson("Ben", "Dover");
        //new byte[] {1, 0, 0, 0, 1}
        Person person = new Person("Hugh", "Jass");
        hrPerson.writeLogEntry(person, 0);
        log.printLog();
        log.logbookClose();
    }
}
