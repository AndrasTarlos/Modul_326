package employees;

import log.LogBook;
import log.UserAction;

import java.io.IOException;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>HRPerson</h1>
 * @author: Andras Tarlos
 * @version: 1.0
 * @date: 18.06.2022
 * <h2>Description</h2>
 * This is a model class dedicated to replicate and save data
 * of an HRPerson. It includes all the methods needed for this software.
 * Getters and setters are made with the lombok library.
 */
@Getter
@Setter
public class HRPerson extends Person {
    private int modus;
    private String pwd;

    /**
     * Default constructor of HRPerson (for the ObjectMapper)
     */
    public HRPerson() {
        super();
    }

    /**
     * Advanced constructor
     * @param firstName of the HRPerson
     * @param lastName of the HRPerson
     * @param departmentName of the HRPerson
     * @param modus of the HRPerson
     * @param pwd of the HRPerson
     */
    public HRPerson(String firstName, String lastName, String departmentName, int modus, String pwd) {
        super(firstName, lastName, departmentName);
        setModus(modus);
        setPwd(pwd);
    }

    public void change(Person person, int modus) {

    }

    /**
     * Writes logs in the logbook
     * @param person a member of a department
     * @param action that the HRPerson did
     * @throws IOException in case of an error
     */
    public void writeLogEntry(Person person, int action) throws IOException {
        UserAction ua = new UserAction(this, person, action);
        LogBook log = LogBook.getLogBookInstance();
        String entry = ua.getEntry();
        log.addEntry(entry);
    }
}