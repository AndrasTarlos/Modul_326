package employees;

import java.awt.*;

public class Person {
    //private byte[] photo;
    private String firstName;
    private String lastName;
    private Participation participation;

    public Person() {}

    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        //setPhoto(photo);
    }
/*
    public byte[] getPhoto() {
        return photo;
    }


    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
 */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Participation getParticipation() {
        return participation;
    }

    public void setParticipation(Participation participation) {
        this.participation = participation;
    }
}
