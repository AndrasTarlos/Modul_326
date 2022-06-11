package utils;

import company.Company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ReadWriteJSON readWriteJSON = new ReadWriteJSON();
        Company company = readWriteJSON.readCompanyJSON();
        readWriteJSON.writeCompanyJSON(company);
    }
}
