package company;

import employees.Person;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Person> members = new ArrayList<>();

    public Department(String name){
        setName(name);
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addMember(Person member) {
        members.add(member);
    }
    public Person getMember(int index){
        return members.get(index);
    }
    public void removeMember(int index){
        members.remove(index);
    }
    public int getNumberOfMembers(){
        return members.size();
    }

    public ArrayList<Person> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Person> members) {
        this.members = members;
    }
}
