package fascades;

import company.Company;
import company.Department;
import employees.HRPerson;
import employees.JobFunction;
import company.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import employees.Person;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

/**
 * <h1>Fascade</h1>
 * @author: Tarlos Andras
 * @version: 1.0
 * @date: 18.06.2022
 * <h2>Description</h2>
 * This is a Fascade class that is responsible for the data exchange between the model
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

    /**
     * Returns the department Object, the person is in
     * @param person an HRPerson
     * @return Department
     */
    public Department getPersonsCurrentDepartment(HRPerson person) {
        for (Department d: getAllDepartment()) {
            if (person.getDepartmentName().equals(d.getName())) {
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

    /**
     * Returns an A to Z sorted person list
     * @return List<HRPerson>
     */
    public List<HRPerson> getAllPersonSortedAZ() {
        List<HRPerson> list = getAllPerson();
        Collections.sort(list, Person.compareAscending());
        return list;
    }

    /**
     * Returns an Z to A sorted person list
     * @return List<HRPerson>
     */
    public List<HRPerson> getAllPersonSortedZA() {
        List<HRPerson> list = getAllPersonSortedAZ();
        Collections.reverse(list);
        return list;
    }

    /**
     * Returns all the person whose names contain the search term
     * @param searchTerm the user enters
     * @return List<HRPerson>
     */
    public List<HRPerson> getSearchedPerson(String searchTerm) {
        List<HRPerson> list = new ArrayList<>();
        for (HRPerson p: getAllPerson()) {
            if ((getPersonsFullName(p).toUpperCase(Locale.ROOT)).contains(searchTerm.toUpperCase(Locale.ROOT))) {
                list.add(p);
            }
        }
        return list;
    }

    /**
     * Returns only the persons who have the filtered attributes (department, team, job function)
     * @param departmentName selected filter
     * @param teamName selected filter
     * @param jobFunctionName selected filter
     * @return List<HRPerson>
     */
    public List<HRPerson> getFilteredPerson(String departmentName, String teamName, String jobFunctionName) {
        int type = -1;
        if (departmentName == null && teamName == null && jobFunctionName == null) {
            return getAllPerson();
        } else if (departmentName == null && teamName == null) {
            type = 0;
        } else if (teamName == null && jobFunctionName == null) {
            type = 1;
        } else if (departmentName == null && jobFunctionName == null) {
            type = 2;
        } else if (departmentName == null) {
            type = 3;
        } else if (teamName == null) {
            type = 4;
        } else if (jobFunctionName == null) {
            type = 5;
        }

        List<HRPerson> list = new ArrayList<>();
        for (HRPerson p: getAllPerson()) {
            switch (type) {
                case 0 -> {
                    if (p.getParticipation().getFunction().getDesignation().equals(jobFunctionName)) {
                        list.add(p);
                    }
                }
                case 1 -> {
                    if (p.getDepartmentName().equals(departmentName)) {
                        list.add(p);
                    }
                }
                case 2 -> {
                    if (p.getParticipation().getTeam().getDesignation().equals(teamName)) {
                        list.add(p);
                    }
                }
                case 3 -> {
                    if (p.getParticipation().getFunction().getDesignation().equals(jobFunctionName) &&
                            p.getParticipation().getTeam().getDesignation().equals(teamName)) {
                        list.add(p);
                    }
                }
                case 4 -> {
                    if (p.getParticipation().getFunction().getDesignation().equals(jobFunctionName) &&
                            p.getDepartmentName().equals(departmentName)) {
                        list.add(p);
                    }
                }
                case 5 -> {
                    if (p.getDepartmentName().equals(departmentName) &&
                            p.getParticipation().getTeam().getDesignation().equals(teamName)) {
                        list.add(p);
                    }
                }
            }
            if (p.getDepartmentName().equals(departmentName) && p.getParticipation().getTeam().getDesignation().equals(teamName)
                    && p.getParticipation().getFunction().getDesignation().equals(jobFunctionName)) {
                list.add(p);
            }
        }
        return list;
    }

    /**
     * Gets an HRPerson object
     * @param name = "firstname lastname"
     * @return HRPerson
     */
    public HRPerson getPersonByFullName(String name) {
        for (HRPerson p : getAllPerson()) {
            if (name.equals(p.getFirstName() + " " + p.getLastName())) {
                return p;
            }
        }
        return null;
    }

    /**
     * Returns a persons full name (firstname lastname)
     * @param p an HRPerson
     * @return String
     */
    public String getPersonsFullName(HRPerson p) {
        return p.getFirstName() + " " + p.getLastName();
    }

    /**
     * Changes the persons the department
     * @param newDepartment Department object
     * @param person a person
     */
    public void switchPersonDepartmentTo(@NotNull Department newDepartment, HRPerson person) {
        newDepartment.addMember(person);
        getPersonsCurrentDepartment(person).removeMember(person);
        person.setDepartmentName(newDepartment.getName());
    }

    // Teams

    /**
     * Returns the by name searched Team
     * @param name search term
     * @return Team object
     */
    public Team getSearchedTeam(String name) {
        for (Team t: getTeams()) {
            if (name.equals(t.getDesignation()))
                return t;
        }
        return null;
    }

    /**
     * Changes the team the person belongs to
     * @param person a person
     * @param newTeam new teams name
     */
    public void setTeamOfPerson(HRPerson person, String newTeam) {
        person.getParticipation().setTeam(getSearchedTeam(newTeam));
    }

    // JobFunctions

    /**
     * Returns a JobFunction object by name
     * @param name of job function
     * @return JobFunction
     */
    public JobFunction getSearchedJobFunction(String name) {
        for (JobFunction j: getJobFunctions()) {
            if (name.equals(j.getDesignation()))
                return j;
        }
        return null;
    }

    /**
     * Changes the job function the selected person has
     * @param person a perosn
     * @param newJobFunction the new job functions name
     */
    public void setJobFunctionOfPerson(HRPerson person, String newJobFunction) {
        person.getParticipation().setFunction(getSearchedJobFunction(newJobFunction));
    }
}
