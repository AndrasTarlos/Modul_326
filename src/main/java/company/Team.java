package company;

import lombok.Getter;
import lombok.Setter;
/**
 * <h1>Teams</h1>
 * author: Francesco Ryu
 * version: 1.0
 * date: 01.06.2022
 * description: This class includes methods for Teams.
 */

@Getter
@Setter
public class Team {
    private String designation;
    /**
     * empty constructor
     */
    public Team() {}

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}