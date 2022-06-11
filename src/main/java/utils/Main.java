package utils;

import company.Company;
import employees.HRPerson;
import employees.Person;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ReadWriteJSON readWriteJSON = new ReadWriteJSON();
        Fascade fascade = new Fascade(readWriteJSON.readCompanyJSON());
        for (Person p: fascade.getAllPerson()) {
            if (p.getClass() == HRPerson.class) {
                System.out.println(p.getFirstName());
            }
        }

        //readWriteJSON.writeCompanyJSON(company);
    }
}
