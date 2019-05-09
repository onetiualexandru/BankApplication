package model;

import java.util.ArrayList;

public class AccountObserver {

    ArrayList<Account> obs=new ArrayList<Account>();
    Account account=new Account();

    public AccountObserver(Account account){
        this.account=account;
    }

    public String update(Account account) {
        obs.add(account);
        return "Account"+account+"has been modified";
    }
}
