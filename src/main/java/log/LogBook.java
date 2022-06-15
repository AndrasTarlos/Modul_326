package log;

import java.io.*;
import java.util.Vector;

public class LogBook {
    private Vector<String> entries = new Vector<>();
    private static LogBook instance;
    private File file;
    private BufferedReader reader;
    private BufferedWriter writer;
    private boolean fileWritingEnabled = false;

    private LogBook() {
        file = new File("logbook.log");
        try {
            if (!file.createNewFile()) {
                reader = new BufferedReader(new FileReader(file));
                readFile();
                reader.close();
            }

            writer = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LogBook getLogBookInstance() {
        if (instance == null) {
            instance = new LogBook();
        }
        return instance;
    }

    public void addEntry(String entry) throws IOException {
        entries.add(entry);
        if (fileWritingEnabled) {
            writeFile(entry);
        }
    }

    public String getEntry(Integer index) {
        return entries.get(index);
    }

    public int getSize() {
        return entries.size();
    }

    public void logbookClose() throws IOException {
        writer.close();
    }

    public void printLog() {
        for (String e: entries) {
            System.out.println(e);
        }
    }

    private void writeFile(String entry) throws IOException {
        writer.append(entry);
        writer.newLine();
        writer.flush();
    }

    private void readFile() throws IOException {
        while (reader.ready()) {
            entries.add(reader.readLine());
        }
        fileWritingEnabled = true;
    }
}
