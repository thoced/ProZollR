package Models;

import java.util.List;

public class PhoneNumber {
    private String countryCode;
    private String areaCode;
    private String number;

    private List<Person> persons;

    // Constructeur
    public PhoneNumber(String countryCode, String areaCode, String number,List<Person> persons) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.number = number;
        this.persons = persons;
    }

    // Getters et Setters
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "+" + countryCode + " " + areaCode + " " + number;
    }
}
