package employees;

import company.Team;

public class Participation {
    private JobFunctions functions = new JobFunctions();
    private Team team = new Team();

    public Participation() {}

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