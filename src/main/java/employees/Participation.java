package employees;

import company.Team;
import lombok.Getter;
import lombok.Setter;
/**
 * <h1>Participation</h1>
 * author: Tarlos Andras
 * version: 1.0
 * date: 01.12.2022
 * description: This class includes methods for JobFunctions.
 */
@Getter
@Setter
public class Participation {
    private JobFunction function = new JobFunction();
    private Team team = new Team();

    /**
     * Default Constructor of Participation
     */
    public Participation() {}
}