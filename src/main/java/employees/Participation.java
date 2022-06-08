package employees;

import company.JobFunctions;
import company.Teams;

import java.util.ArrayList;
import java.util.List;

public class Participation {
    private JobFunctions functions = new JobFunctions();
    private Teams teams = new Teams();
    private Person owner;

    public Participation(Person person) {
        owner = person;
    }

    public void addFunction(String designation) {
        functions.addJobFunction(designation);
    }

    public String getFunctionName(int index) {
        return functions.getJobFunction(index);
    }

    public void removeFunction(int index) {
        functions.removeJobFunction(index);
    }

    public int getNumberOfFunctions() {
        return functions.getSize();
    }

    public void addTeam(String designation) {
        teams.addTeam(designation);
    }

    public String getTeamName(int index) {
        return teams.getTeam(index);
    }

    public void removeTeam(int index) {
        teams.removeTeam(index);
    }

    public int getNumberOfTeams() {
        return teams.getSize();
    }
}
