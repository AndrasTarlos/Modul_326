package company;
import java.util.ArrayList;

/**
 * <h1>Teams</h1>
 * author: Francesco Ryu
 * version: 1.0
 * date: 01.06.2022
 * description: This class includes methods for Teams.
 */

public class Teams {
    private ArrayList<String> designations = new ArrayList<>();

    /**
     * empty constructor
     */
    public Teams() {}

    /**
     * adds team to designations ArrayList
     * @param function
     */
    public void addTeam(String function) {
        designations.add(function);
    }

    /**
     * gets a designation from index
     * @param index
     * @return index from designations
     */
    public String getTeam(int index) {
        return designations.get(index);
    }

    /**
     * removes designation from index
     * @param index
     */
    public void removeTeam(int index) {
        designations.remove(index);
    }

    /**
     * gets size from designations from ArrayList
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
