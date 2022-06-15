package utils;

import company.Company;

public class Main {
    public static void main(String[] args) {
        ReadWriteJSON readWriteJSON = new ReadWriteJSON();
        Fascade fascade = readWriteJSON.readFascadeJSON();
        Company company = readWriteJSON.readCompanyJSON();
        //readWriteJSON.writeCompanyJSON(company);
    }
}
