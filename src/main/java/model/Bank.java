package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Bank implements BankProc, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Hashtable<Person, ArrayList<Account>> bankHash;

    public Bank() {
        bankHash = new Hashtable<Person, ArrayList<Account>>();
    }


    @Override
    public void addPerson(Person person) {
        // TODO Auto-generated method stub

        //pre
        int s1 = bankHash.size();

        ArrayList<Account> cont = new ArrayList<Account>();
        bankHash.put(person, cont);

        //post
        int s2 = bankHash.size();
        assert s2 == s1 + 1 : "Person not Added";

    }

    @Override
    public void removePerson(Person person) {
       /* while(bankHash.keys().hasMoreElements()){
            System.out.println(bankHash.keys().nextElement());
        }*/

        //pre
        int s1 = bankHash.size();
        ;

        Set<Person> keys = this.bankHash.keySet();

        for (Person key : keys) {
            if (key.getId() == person.getId() && key.getName().equals(person.getName()) && key.getEmail().equals(person.getEmail())) {
                bankHash.remove(key);
                break;
            }
        }
        //post
        int s2 = bankHash.size();
        assert s2 != s1 - 1 : "Person not remove";
    }

    public void editPerson(Person oldPerson, Person person) {
        System.out.println("Old " + oldPerson);
        System.out.println("New " + person);

        Set<Person> keys = bankHash.keySet();
        Person personKey = null;

        for (Person key : keys) {
            System.out.println(key.getId());
            System.out.println(oldPerson.getId());
            if (key.getId() == oldPerson.getId() && key.getName().equals(oldPerson.getName()) && key.getEmail().equals(oldPerson.getEmail()))
                personKey = key;
        }

        ArrayList<Account> cont = new ArrayList<Account>();
        System.out.println(bankHash);

        cont = bankHash.get(personKey);
        System.out.println(bankHash.containsKey(personKey));
        System.out.println(cont);
        for (int i = 0; i < cont.size(); i++) {
            cont.get(i).setPerson(person);
        }
        bankHash.remove(personKey);
        bankHash.put(person, cont);


    }

    @Override
    public void addAcount(Account account) {

        //pre
        assert account != null : "Account is empty";

        System.out.println(account);
        Person person = account.getPerson();
        System.out.println(person);

        Set<Person> keys = bankHash.keySet();
        Person personKey = null;

        for (Person key : keys) {
            if (key.getId() == person.getId() && key.getName().equals(person.getName()) && key.getEmail().equals(person.getEmail())) {
                personKey = key;
                break;
            }
        }

        System.out.println("b" + bankHash);

        ArrayList<Account> cont = bankHash.get(personKey);
        System.out.println(cont);
        cont.add(account);
        bankHash.put(personKey, cont);

        //post
        assert !(cont.isEmpty()) : "Account not added";
    }

    @Override
    public void removeAcount(Account account) {
        // TODO Auto-generated method stub

        assert account != null : "Account is not empty";

        System.out.println(account);
        Person person = account.getPerson();
        System.out.println(person);

        Set<Person> keys = bankHash.keySet();
        Person personKey = null;

        for (Person key : keys) {
            if (key.getId() == person.getId() && key.getName().equals(person.getName()) && key.getEmail().equals(person.getEmail()))
                personKey = key;
        }
        System.out.println("personKey" + personKey);

        ArrayList<Account> cont = bankHash.get(personKey);
        Account accountKey = null;

        for (Account ac : cont) {
            if (ac.getId() == account.getId())
                accountKey = ac;
        }

        System.out.println("accKey" + accountKey);

        System.out.println(cont.contains(accountKey));
        cont.remove(accountKey);

        bankHash.put(personKey, cont);

        //post
        assert cont.isEmpty() : "Account not removed";

    }

    public void editAccount(Person oldPerson, int oldId, int id, int suma) {

        Set<Person> keys = bankHash.keySet();
        Person personKey = null;

        for (Person key : keys) {
            if (key.getId() == oldPerson.getId() && key.getName().equals(oldPerson.getName()) && key.getEmail().equals(oldPerson.getEmail())) {
                personKey = key;
                break;
            }
        }

        ArrayList<Account> cont = bankHash.get(personKey);
        System.out.println("Contul este=" + cont);
        for (int i = 0; i < cont.size(); i++) {
            if (cont.get(i).getId() == oldId) {
                cont.get(i).setId(id);
                cont.get(i).setSuma(suma);
            }
        }
    }

    @Override
    public void addMoney(Person person, int idAccount, int suma) {


        assert suma > 0 : "Suma pozitiva";
        int sumaContPre = 0, sumaContPost = 0;

        Set<Person> keys = bankHash.keySet();
        Person personKey = null;

        for (Person key : keys) {
            if (key.getId() == person.getId() && key.getName().equals(person.getName()) && key.getEmail().equals(person.getEmail()))
                personKey = key;
        }
        ArrayList<Account> cont = bankHash.get(personKey);


        Account accountKey = null;
        Boolean tipCont = false;

        for (Account ac : cont) {
            if (ac.getTipCont().equals("SavingAccount") && ac.getId() == idAccount) {
                tipCont = true;
                sumaContPre = ac.getSuma();
            } else if (ac.getTipCont().equals("SpendingAccount") && ac.getId() == idAccount)
                sumaContPre = ac.getSuma();
        }
        System.out.println(tipCont);

        if (tipCont == false) {
            for (int i = 0; i < cont.size(); i++) {
                if (cont.get(i).getId() == idAccount) {
                    cont.get(i).setSuma(cont.get(i).getSuma() + suma);
                    sumaContPost = cont.get(i).getSuma();
                }
            }
        } else {
            for (int i = 0; i < cont.size(); i++) {
                if (cont.get(i).getId() == idAccount) {
                    if (suma < 1000) {
                        throw new ArithmeticException("Minimum Deposit must be over 1000 RON");
                    }
                    cont.get(i).setSuma(cont.get(i).getSuma() + suma);
                    sumaContPost = cont.get(i).getSuma();

                }
            }
        }

        System.out.println(sumaContPost);
        System.out.println(sumaContPre);
        System.out.println(suma);

        assert sumaContPost == sumaContPre + suma : "Nu s-a retras corect";
    }

    @Override
    public void withDraw(Person person, int idAccount, int suma) {

        int sum = 0;

        Set<Person> keys = bankHash.keySet();
        Person personKey = null;
        Boolean tipCont = false;

        for (Person key : keys) {
            if (key.getId() == person.getId() && key.getName().equals(person.getName()) && key.getEmail().equals(person.getEmail()))
                personKey = key;
        }
        ArrayList<Account> cont = bankHash.get(personKey);

        for (Account ac : cont) {
            if (ac.getTipCont().equals("SavingAccount") && ac.getId() == idAccount) {
                tipCont = true;
                sum = ac.getSuma();
            } else if (ac.getTipCont().equals("SpendingAccount") && ac.getId() == idAccount)
                sum = ac.getSuma();
        }

        if (tipCont == true) {
            for (int i = 0; i < cont.size(); i++) {
                if (cont.get(i).getId() == idAccount) {
                    if (cont.get(i).getSuma() - suma >= 0) {
                        if (suma > cont.get(i).getSuma() / 2)
                            cont.get(i).setSuma(cont.get(i).getSuma() - suma);
                        else
                            throw new ArithmeticException("You must Withdraw at least half of your deposit");
                    } else throw new ArithmeticException("Not enough founds");
                }
            }
        } else
            for (int i = 0; i < cont.size(); i++) {
                if (cont.get(i).getId() == idAccount) {
                    if (cont.get(i).getSuma() - suma >= 0) {
                        cont.get(i).setSuma(cont.get(i).getSuma() - suma);
                        sum=cont.get(i).getSuma();
                    } else throw new ArithmeticException("Not enough founds");
                }
            }

        assert sum >0 : "Not enough founds";
    }

    public void afiseaza() {
        System.out.println(bankHash.toString());
    }


    @Override
    public void writeData(Bank bank) {
        ObjectOutputStream output;
        try {
            output = new ObjectOutputStream(new FileOutputStream("Bank.txt"));
            output.writeObject(bank);
        } catch (IOException e) {

        }

    }

    @SuppressWarnings("resource")
    @Override
    public Bank readData() {
        // TODO Auto-generated method stub
        ObjectInputStream input;
        try {
            input = new ObjectInputStream(new FileInputStream("Bank.txt"));
            Object obj = input.readObject();
            return (Bank) obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object[][] returnHashAccount() {
        Object[][] data = new Object[100][100];
        Person p = new Person();
        // System.out.println("returnHash="+this.bankHash);


        Set<Person> keys = this.bankHash.keySet();
        Iterator<Person> itr = keys.iterator();
        int i, j;
        i = 0;
        j = 0;
        System.out.println(data);
        System.out.println(this.bankHash.size());
        while (itr.hasNext()) {
            p = itr.next();
            ArrayList<Account> cont = bankHash.get(p);
            if (!(bankHash.get(p).isEmpty())) {
                System.out.println(cont);
                System.out.println("cont size = " + cont.size());
                for (int m = 0; m < cont.size(); m++) {
                    j = 0;
                    System.out.println(m);
                    data[i][j++] = p.getId();
                    data[i][j++] = p.getName();
                    data[i][j++] = p.getEmail();
                    // System.out.println(cont.get(m).getId());
                    data[i][j++] = cont.get(m).getId();
                    System.out.println("i=" + i);
                    System.out.println("j=" + j);
                    System.out.println("data[" + i + "][" + j + "]=" + data[i][j]);
                    //  System.out.println(cont.get(m).getSuma());
                    data[i][j++] = cont.get(m).getSuma();
                    System.out.println("data[" + i + "][" + j + "]=" + data[i][j]);
                    //  System.out.println(cont.get(m).getTipCont());
                    data[i][j++] = cont.get(m).getTipCont();
                    System.out.println("data[" + i + "][" + j + "]=" + data[i][j]);
                    i++;
                }
            }
        }
        return data;
    }

    public Object[][] returnHash() {
        Object[][] data = new Object[100][100];
        Person p = new Person();
        // System.out.println("returnHash="+this.bankHash);
        Set<Person> keys = this.bankHash.keySet();
        Iterator<Person> itr = keys.iterator();
        int i, j;
        i = 0;
        j = 0;
        System.out.println(data);
        // System.out.println(this.bankHash.size());
        while (itr.hasNext()) {
            j = 0;
            p = itr.next();
            System.out.println(i + "=" + p);
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getEmail());
            data[i][j++] = p.getId();
            data[i][j++] = p.getName();
            data[i][j++] = p.getEmail();
            i++;
        }
        return data;
    }

    public void retHash() {
        Object[][] data = new Object[100][100];
        Person p = new Person();
        // System.out.println("returnHash="+this.bankHash);
        Set<Person> keys = this.bankHash.keySet();
        Iterator<Person> itr = keys.iterator();
        int i, j;
        i = 0;
        j = 0;
        System.out.println(data);
        // System.out.println(this.bankHash.size());
        while (itr.hasNext()) {
            j = 0;
            p = itr.next();
            System.out.println(i + "=" + p);
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getEmail());
            data[i][j++] = p.getId();
            data[i][j++] = p.getName();
            data[i][j++] = p.getEmail();
            i++;
        }
    }

    public String toString() {
        return "BankHash=" + bankHash;

    }

}
