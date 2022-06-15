package employees;

import log.LogBook;
import log.UserAction;

import java.io.IOException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HRPerson extends Person {
    /**
     * <h1>Employees</h1>
     * author: Andras Tarlos
     * version: 1.0
     * date: 08.06.2022
     * description: This class includes methods for HRPerson
     */
    private int modus;
    private String pwd;
//, byte[] photo

    public HRPerson() {
        super();
    }

    public HRPerson(String firstName, String lastName, String departmentName, int modus, String pwd) {
        super(firstName, lastName, departmentName);
        setModus(modus);
        setPwd(pwd);
    }

    public void change(Person person, int modus) {

    }


    public void writeLogEntry(Person person, int action) throws IOException {
        UserAction ua = new UserAction(this, person, action);
        LogBook log = LogBook.getLogBookInstance();
        String entry = ua.getEntry();
        log.addEntry(entry);
    }
}