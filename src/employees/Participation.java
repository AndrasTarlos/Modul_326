package employees;

import java.util.ArrayList;
import java.util.List;

public class Participation {
    private List<JobFunctions> function = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();
    private Person owner;

    public Participation(Person person) {

    }

    public void addFunction(JobFunction jobFunction) {

    }

    public String getFunctionName(int index) {
        return function.get(index);
    }

    public void removeFunction(int index) {
        function.remove();
    }

    public int getNumberOfFunctions() {
        return function.getSize();
    }

    public void addTeam(Teams teams) {
        teams.add(teams);
    }

    public String getTeamName(int index) {
        return "";
    }

    public void removeTeam(int index) {

    }

    public int getNumberOfTeams() {
        return 1;
    }
}
