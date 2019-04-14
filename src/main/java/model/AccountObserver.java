package model;

import java.util.ArrayList;

public class AccountObserver {

    ArrayList<Account> obs=new ArrayList<Account>();

    public AccountObserver(Account account){

    }
    public AccountObserver( ArrayList<Account> obs){
        this.obs=obs;
    }

    public String update(Account account) {
        obs.add(account);
        return "Account"+account+"has been modified";
    }
}
