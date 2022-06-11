package utils;

import company.Company;
import company.Department;

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
}
