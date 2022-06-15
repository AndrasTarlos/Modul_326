package utils;

import company.Company;
import company.Department;
import employees.HRPerson;
import employees.JobFunction;
import company.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import employees.Person;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

/**
 * Fascade
 * author: Tarlos Andras
 * version: 1.0
 * date: 01.12.2022
 * description: This is a Fascade class that is responsible for the data exchange between the model
 * and View classes in the wanted format.
 */
@Getter
@Setter
public class Fascade {
    private Company company = new Company();
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<JobFunction> jobFunctions = new ArrayList<>();

    /**
     * Default constructor of Fascade
     */
    public Fascade() {}

    /**
     * Advanced constructor of Fascade
     * @param company a company object
     */
    public Fascade(Company company) {
        setCompany(company);
    }

    // Company

    /**
     * Setter of the company object
     * @param company a company object
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * Getter of company name
     * @return String
     */
    public String getCompanyName() {
        return company.getCompanyName();
    }

    /**
     * Setter of company name
     * @param name the new company name
     */
    public void setCompanyName(String name) {
        company.setCompanyName(name);
    }

    // Department

    /**
     * Getter of all departments
     * @return ArrayList<Department>
     */
    public ArrayList<Department> getAllDepartment() {
        return company.getDepartments();
    }

    /**
     * Getter of all names of departments
     * @return List<String>
     */
    public List<String> getNameOfAllDepartment() {
        List<String> names = new ArrayList<>();
        for (Department d: company.getDepartments()) {
            names.add(d.getName());
        }
        return names;
    }

    /**
     * Gets the searched department
     * @param name the search term
     * @return a Department object
     */
    public Department getSearchedDepartment(String name) {
        for (Department d: getAllDepartment()) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        return null;
    }

    // Person

    /**
     * Gets all Person objects
     * @return List<HRPerson>
     */
    public List<HRPerson> getAllPerson() {
        List<HRPerson> person = new ArrayList<>();
        for (Department d: company.getDepartments()) {
            person.addAll(d.getMembers());
        }

        return person;
    }

    public List<HRPerson> getAllPersonSortedAZ() {
        List<HRPerson> list = getAllPerson();
        Collections.sort(list, Person.compareAscending());
        return list;
    }

    public List<HRPerson> getAllPersonSortedZA() {
        List<HRPerson> list = getAllPersonSortedAZ();
        Collections.reverse(list);
        return list;
    }

    /**
     * Gets an HRPerson object
     * @param name = "firstname lastname"
     * @return
     */
    public HRPerson getPersonByFullName(String name) {
        for (HRPerson p : getAllPerson()) {
            if (name.equals(p.getFirstName() + " " + p.getLastName())) {
                return p;
            }
        }
        return null;
    }

    public void switchPersonDepartmentTo(@NotNull Department newDepartment, HRPerson person) {
        newDepartment.addMember(person);
        getPersonsCurrentDepartment(person).removeMember(person);
    }

    public Department getPersonsCurrentDepartment(HRPerson person) {
        for (Department d: getAllDepartment()) {
            if (person.getDepartmentName().equals(d.getName())) {
                return d;
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
