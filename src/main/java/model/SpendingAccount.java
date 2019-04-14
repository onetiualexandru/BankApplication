package model;

import java.io.Serializable;

public class SpendingAccount extends Account implements Serializable {

    private static final String tipCont = "SpendingAccount";

    private static final long serialVersionUID = 1L;

    public SpendingAccount(Person person, int id, int suma) {
        super(person, id, suma , tipCont);	}
    }


