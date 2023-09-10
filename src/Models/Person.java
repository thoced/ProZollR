package Models;

import java.util.List;

public class Person {
    private String firstname;
    private String name;
    private String address;
    private String number;
    private String town;
    private String zipcode;


    // Constructeur


    public Person() {
    }

    public Person(String firstname, String name, String address, String number, String town, String zipcode) {
        this.firstname = firstname;
        this.name = name;
        this.address = address;
        this.number = number;
        this.town = town;
        this.zipcode = zipcode;
    }

    // Getters et Setters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
