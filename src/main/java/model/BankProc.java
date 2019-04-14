package model;


public interface BankProc {

    public void addPerson(Person person);

    public void removePerson(Person person);

    public void addAcount(Account account);

    public void removeAcount(Account account);

    public void addMoney(Person person,int idAccount,int suma);

    public void withDraw(Person person,int idAccount,int suma);

    public void writeData(Bank bank);

    public Bank readData();

}
