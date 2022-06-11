package utils;

import company.Company;
import employees.HRPerson;
import employees.Person;
import log.LogBook;
import utils.ReadWriteJSON;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ReadWriteJSON readWriteJSON = new ReadWriteJSON();
        Company company = readWriteJSON.readCompanyJSON();
        readWriteJSON.writeCompanyJSON(company);
    }
}
