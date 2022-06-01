package company;

import java.util.ArrayList;

public class JobFunctions {
    private ArrayList<String> designations = new ArrayList<>();

    public JobFunctions() {

    }

    public void addJobFunction(String function) {
        designations.add(function);
    }

    public String getJobFunction(int index) {
        return designations.get(index);
    }

    public void removeJobFunction(int index) {
        designations.remove(index);
    }

    public int getSize() {
        return designations.size();
    }
}
