package company;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {
    private String name;
    private final ArrayList<Department> departments = new ArrayList<>();

    public Company() {}

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
    @JsonIgnore
    public int getNumberOfDepartments(){
        return departments.size();
    }
}