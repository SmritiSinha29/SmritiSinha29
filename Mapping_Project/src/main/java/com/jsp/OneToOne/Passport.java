package com.jsp.OneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passportId;

    private String passportNumber;

   
    @OneToOne(mappedBy = "passport")
    private Person person;


    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Passport() {}

    public Passport(int passportId, String passportNumber) {
        this.passportId = passportId;
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Passport [passportId=" + passportId + ", passportNumber=" + passportNumber + "]";
    }
}
