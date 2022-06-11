package company;
import java.util.ArrayList;

/**
 * <h1>JobFunctions</h1>
 * author: Francesco Ryu
 * version: 1.0
 * date: 01.06.2022
 * description: This class includes methods for JobFunctions.
 */

public class JobFunctions {
    private ArrayList<String> designations = new ArrayList<>();

    /**
     * Empty constructor
     */
    public JobFunctions() {

    }

    /**
     * adds a function to the designations ArrayList
     * @param function
     */
    public void addJobFunction(String function) {
        designations.add(function);
    }

    /**
     * gets a designation from index
     * @param index
     * @return index from designations
     */
    public String getJobFunction(int index) {
        return designations.get(index);
    }

    /**
     * removes a designation form index
     * @param index
     */
    public void removeJobFunction(int index) {
        designations.remove(index);
    }

    /**
     * gets size from designations ArrayList
     * @return size of designations
     */
    public int getSize() {
        return designations.size();
    }

    public ArrayList<String> getDesignations() {
        return designations;
    }

    public void setDesignations(ArrayList<String> designations) {
        this.designations = designations;
    }
}