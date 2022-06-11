package utils;

import company.Company;
import company.Department;
import employees.HRPerson;
import employees.Person;

import java.util.ArrayList;
import java.util.List;

public class Fascade {
    private Company company = new Company();

    public Fascade(Company company) {
        setCompany(company);
    }

    private void setCompany(Company company) {
        this.company = company;
    }

    public String getCompanyName() {
        return company.getCompanyName();
    }

    public void setCompanyName(String name) {
        company.setCompanyName(name);
    }

    public List<Department> getAllDepartment() {
        return company.getDepartments();
    }

    public List<String> getNameOfAllDepartment() {
        List<String> names = new ArrayList<>();
        for (Department d: company.getDepartments()) {
            names.add(d.getName());
        }
        return names;
    }

    public List<Person> getAllPerson() {
        List<Person> person = new ArrayList<>();
        for (Department d: company.getDepartments()) {
            person.addAll(d.getMembers());
        }

        return person;
    }

    public Person getPersonByFullName(String name) {
        for (Person p: getAllPerson()) {
            if (name.equals(p.getFirstName() + " " + p.getLastName())) {
                return p;
            }
        }
        return null;
    }
}
