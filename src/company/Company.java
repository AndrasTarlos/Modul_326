package company;

import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<String> departments = new ArrayList<>();


    public void Company(String name){

    }

    public void getCompanyName(){

    }
    public void addDepartment(){

    }
    public ArrayList<String> getDepartment(int index){
        return departments;
    }
    public String getDepartmentsName(){
        return name;
    }
    public ArrayList<String> removeDepartment(int index){
        return departments;
    }
    public ArrayList<String> getNumberOfDepartments(){
        return departments;
    }

}
