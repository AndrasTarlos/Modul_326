package utils;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import company.Company;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ReadWriteJSON {
    private static URI companyJsonPath;
    private static URI fascadeJsonPath;

    static {
        try {
            companyJsonPath = Objects.requireNonNull(ReadWriteJSON.class.getResource("../JSON/companyJSON.json")).toURI();
            fascadeJsonPath = Objects.requireNonNull(ReadWriteJSON.class.getResource("../JSON/fascadeJSON.json")).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public ReadWriteJSON() {

    }

    protected Company readCompanyJSON() {
        Company[] company;
        try {
            String path = Paths.get(companyJsonPath).toString();
            byte[] jsonData = Files.readAllBytes(Paths.get(path));
            ObjectMapper objectMapper = new ObjectMapper();
            company = objectMapper.readValue(jsonData, Company[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return company[0];
    }

    /**
     *
     * @param company
     */
    protected void writeCompanyJSON(Company company) {
        List<Company> list = new ArrayList<>();
        list.add(company);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        try {
            fileOutputStream = new FileOutputStream(Paths.get(companyJsonPath).toString());
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, list);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @return Fascade
     */
    protected Fascade readFascadeJSON() {
        Fascade[] fascade;
        try {
            String path = Paths.get(fascadeJsonPath).toString();
            byte[] jsonData = Files.readAllBytes(Paths.get(path));
            ObjectMapper objectMapper = new ObjectMapper();
            fascade = objectMapper.readValue(jsonData, Fascade[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fascade[0];
    }
}
