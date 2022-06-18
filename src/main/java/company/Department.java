package company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import employees.HRPerson;
import employees.Person;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>Department</h1>
 * @author: Andras Tarlos
 * @version: 1.0
 * @date: 18.06.2022
 * <h2>Description</h2>
 * The model class of a department. A company can have multiple different departments.
 */
@Getter
@Setter
public class Department {
    private String name;
    private ArrayList<HRPerson> members = new ArrayList<>();

    public Department() {}

    public Department(String name){
        setName(name);
    }

    public void addMember(HRPerson member) {
        members.add(member);
    }

    public Person getMember(int index){
        return members.get(index);
    }

    public void removeMember(int index){
        members.remove(index);
    }

    public void removeMember(HRPerson person) {
        members.remove(person);
    }
    @JsonIgnore
    public int getNumberOfMembers(){
        return members.size();
    }
}