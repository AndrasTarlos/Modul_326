package company;

import java.util.ArrayList;

public class Company {
    private String name;
    private final ArrayList<Department> departments = new ArrayList<>();


    public Company(String name){
        setCompanyName(name);
    }

    public String getCompanyName(){
        return name;
    }

    public void setCompanyName(String name) {
        this.name = name;
    }
    public void addDepartment(Department department){
        departments.add(department);
    }
    public Department getDepartment(int index){
        return departments.get(index);
    }
    public String getDepartmentsName(int index){
        return departments.get(index).getName();
    }
    public void removeDepartment(int index){
        departments.remove(index);
    }
    public int getNumberOfDepartments(){
        return departments.size();
    }
}
