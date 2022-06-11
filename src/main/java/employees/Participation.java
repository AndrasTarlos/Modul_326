package employees;

import company.JobFunctions;
import company.Team;

public class Participation {
    private JobFunctions functions = new JobFunctions();
    private Team team = new Team();

    public Participation() {}

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
        team.addTeam(designation);
    }

    public String getTeamName(int index) {
        return team.getTeam(index);
    }

    public void removeTeam(int index) {
        team.removeTeam(index);
    }

    public int getNumberOfTeams() {
        return team.getSize();
    }

    public JobFunctions getFunctions() {
        return functions;
    }

    public void setFunctions(JobFunctions functions) {
        this.functions = functions;
    }

    public Team getTeams() {
        return team;
    }

    public void setTeams(Team team) {
        this.team = team;
    }
}
