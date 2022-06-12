package utils;

import company.Company;
import company.Department;
import employees.HRPerson;
import employees.JobFunction;
import company.Team;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fascade {
    private Company company = new Company();
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<JobFunction> jobFunctions = new ArrayList<>();

    public Fascade() {}

    public Fascade(Company company) {
        setCompany(company);
    }

    // Company

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCompanyName() {
        return company.getCompanyName();
    }

    public void setCompanyName(String name) {
        company.setCompanyName(name);
    }

    // Department

    public ArrayList<Department> getAllDepartment() {
        return company.getDepartments();
    }

    public List<String> getNameOfAllDepartment() {
        List<String> names = new ArrayList<>();
        for (Department d: company.getDepartments()) {
            names.add(d.getName());
        }
        return names;
    }

    // Person

    public List<HRPerson> getAllPerson() {
        List<HRPerson> person = new ArrayList<>();
        for (Department d: company.getDepartments()) {
            person.addAll(d.getMembers());
        }

        return person;
    }

    public HRPerson getPersonByFullName(String name) {
        for (HRPerson p : getAllPerson()) {
            if (name.equals(p.getFirstName() + " " + p.getLastName())) {
                return p;
            }
        }
        return null;
    }

    // Teams

    public Team getSearchedTeam(String name) {
        for (Team t: getTeams()) {
            if (name.equals(t.getDesignation()))
                return t;
        }
        return null;
    }

    public void setTeamOfPerson(HRPerson person, String value) {
        person.getParticipation().setTeam(getSearchedTeam(value));
    }

    // JobFunctions

    public JobFunction getSearchedJobFunction(String name) {
        for (JobFunction j: getJobFunctions()) {
            if (name.equals(j.getDesignation()))
                return j;
        }
        return null;
    }

    public void setJobFunctionOfPerson(HRPerson person, String value) {
        person.getParticipation().setFunction(getSearchedJobFunction(value));
    }
}
