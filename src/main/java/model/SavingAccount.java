package model;

import java.io.Serializable;

public class SavingAccount extends Account implements Serializable {

    private static final String tipCont = "SavingAccount";

    private static final long serialVersionUID = 1L;

    public SavingAccount(Person person, int id, int suma) {
        super(person, id, suma * 2, tipCont);	}

}

