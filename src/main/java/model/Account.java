package model;

import java.io.Serializable;

public class Account implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected int suma;
    private Person person;
    private int id;
    private String tipCont;

    public Account(Person person, int id, int suma, String tipCont) {
        this.person = person;
        this.id = id;
        this.suma = suma;
        this.tipCont = tipCont;
    }

    public Account(Person person, int id, int suma) {
        this.person = person;
        this.id = id;
        this.suma = suma;
    }

    public Account() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public String getTipCont() {
        return tipCont;
    }

    public void setTipCont(String tipCont) {
        this.tipCont = tipCont;
    }


    public String toString() {
        return "Account [personId=" + person.getId() + ", personName=" + person.getName() + ", personEmail="
                + person.getEmail() + ", id=" + id + ", suma=" + suma + ", tip=" + tipCont + "]";
    }
}
