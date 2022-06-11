package utils;

import company.Company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ReadWriteJSON readWriteJSON = new ReadWriteJSON();
        Fascade fascade = new Fascade(readWriteJSON.readCompanyJSON());

        //readWriteJSON.writeCompanyJSON(company);
    }
}
