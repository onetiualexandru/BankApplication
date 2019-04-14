package model;

import static org.junit.Assert.*;

public class BankTest {

    @org.junit.Test
    public void addPerson() {
        Bank bank=new Bank();
        Person person1= new Person(1,"ion","ion@dssd");
        bank.addPerson(person1);
    }

    @org.junit.Test
    public void removePerson() {
        Bank bank=new Bank();
        Person person1= new Person(1,"ion","ion@dssd");
        bank.removePerson(person1);
    }

    @org.junit.Test
    public void addAcount() {
        Bank bank=new Bank();
        Person person1= new Person(1,"ion","ion@dssd");
        bank.addPerson(person1);
        Account ac1=new Account(person1,2,100);
        bank.addAcount(ac1);
    }

    @org.junit.Test
    public void removeAcount() {
        Bank bank=new Bank();
        Person person1= new Person(1,"ion","ion@dssd");
        bank.addPerson(person1);
        Account ac1=new Account(person1,2,100);
        bank.removeAcount(ac1);
    }

    @org.junit.Test
    public void addMoney() {
        Bank bank=new Bank();
        Person person1= new Person(1,"ion","ion@dssd");
        bank.addPerson(person1);
        Account ac1=new Account(person1,2,100,"SavingAccount");
        bank.addAcount(ac1);
        bank.addMoney(person1,2,1000);
    }

    @org.junit.Test
    public void withDraw() {
        Bank bank=new Bank();
        Person person1= new Person(1,"ion","ion@dssd");
        bank.addPerson(person1);
        Account ac1=new Account(person1,2,1000,"SavingAccount");
        bank.addAcount(ac1);
        bank.withDraw(person1,2,600);
    }
}