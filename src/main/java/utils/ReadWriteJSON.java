package utils;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import company.Company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadWriteJSON {

    public ReadWriteJSON() {}

    protected Company readCompanyJSON() {
        Company[] company;
        try {
            //C:\Users\andra\OneDrive - Bildungszentrum Zürichsee\BZZ\Probst\Modul 326\Auftrag_4\Auftrag_4\src\main\resources\JSON
            String path = "C:\\Users\\andra\\OneDrive - Bildungszentrum Zürichsee\\BZZ\\Probst\\Modul 326\\Auftrag_4\\Auftrag_4\\src\\main\\resources\\JSON\\company.json";
            //String pathi = Objects.requireNonNull(ReadWriteJSON.class.getResource("../JSON/person.json")).toString();
            //pathi = pathi.replace("file:/", "");


            byte[] jsonData = new byte[0];
            jsonData = Files.readAllBytes(Paths.get(path));
            ObjectMapper objectMapper = new ObjectMapper();
            company = objectMapper.readValue(jsonData, Company[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return company[0];
    }

    protected void writeCompanyJSON(Company company) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;
        try {
            fileOutputStream = new FileOutputStream("C:\\Users\\andra\\OneDrive - Bildungszentrum Zürichsee\\BZZ\\Probst\\Modul 326\\Auftrag_4\\Auftrag_4\\src\\main\\resources\\JSON\\company.json");
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, new Company[] {company});
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
