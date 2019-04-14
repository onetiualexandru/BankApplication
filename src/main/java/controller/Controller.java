package controller;


import model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controller {

    public Bank bank = new Bank();
    private View theView;

    public Controller(View theView) {
        this.bank = bank.readData();
        this.theView = theView;
        this.theView.showListener(new listenerShow());
        this.theView.insertListener(new listenerInsert());
        this.theView.updateListener(new listenerUpdate());
        this.theView.deleteListener(new listenerDelete());

        this.theView.showListenerAccount(new listenerShowAccount());
        this.theView.insertListenerAccount(new listenerInsertAccount());
        this.theView.insertListenerAccountSaving(new listenerInsertAccountSaving());
        this.theView.updateListenerAccount(new listenerUpdateAccount());
        this.theView.deleteListenerAccount(new listenerDeleteAccount());
        this.theView.addMoney(new listenerAddMoney());
        this.theView.withDraw(new listenerWithdraw());

        this.theView.suntIdiot(new listenerExit());
    }

    /**
     * listener
     *
     * @author Onetiu Alexandru
     */

    class listenerExit extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Closed");
            bank.writeData(bank);
            e.getWindow().dispose();
        }
    }

    class listenerShow implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            theView.afisarePerson(bank);

        }
    }

    class listenerInsert implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Person person = new Person(theView.getIdPerson(), theView.getNamePerson(), theView.getemailPerson());
                bank.addPerson(person);
                // bank.writeData(bank);
                // bank.afiseaza();
                // System.out.println("person from listener:" + person);
            } catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Parametrii Invalizi!");
            }
        }
    }

    class listenerUpdate implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Person oldPerson = new Person(theView.getEditIdPerson(), theView.getEditNamePerson(),
                        theView.getEditEmailPerson());
                Person person = new Person(theView.getIdPerson(), theView.getNamePerson(), theView.getemailPerson());
                bank.editPerson(oldPerson, person);

                // bank.removePerson(person);
                // bank.writeData(bank);
                bank.afiseaza();
                // System.out.println("person from listener:" + person);
            } catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Parametrii Invalizi!");
            } catch (NullPointerException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Persoana nu Exista!");
            }
        }
    }

    class listenerDelete implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Person oldPerson = new Person(theView.getIdPerson(), theView.getNamePerson(), theView.getemailPerson());
                bank.removePerson(oldPerson);
            } catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Parametrii Invalizi!");
            }
        }


    }

    class listenerShowAccount implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            theView.afisareAccount(bank);

        }
    }

    class listenerInsertAccount implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Person person = new Person(theView.getPersonIdCont(), theView.getPersonNameAccount(), theView.getEmailAccountPerson());
                Account ac = new SpendingAccount(person, theView.getIdAccount(), theView.getSumaAccount());
                bank.addAcount(ac);
                bank.afiseaza();

            } catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Parametrii Invalizi!");
            } catch (NullPointerException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Persoana nu Exista!");
            }
        }
    }

    class listenerInsertAccountSaving implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Person person = new Person(theView.getPersonIdCont(), theView.getPersonNameAccount(), theView.getEmailAccountPerson());
                System.out.println(theView.getSumaAccount());
                Account ac = new SavingAccount(person, theView.getIdAccount(), theView.getSumaAccount());
                bank.addAcount(ac);
                bank.afiseaza();

            } catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Parametrii Invalizi!");
            } catch (NullPointerException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Persoana nu Exista!");
            }
        }
    }

    class listenerUpdateAccount implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Person person = new Person(theView.getPersonIdCont(), theView.getPersonNameAccount(), theView.getEmailAccountPerson());
                bank.editAccount(person, theView.getAccountOld(), theView.getIdAccount(), theView.getSumaAccount());
                Account account = new Account(person, theView.getIdAccount(), theView.getSumaAccount(), "tip");
                bank.afiseaza();
                AccountObserver ac = new AccountObserver(account);
                theView.displayErrorMessage(ac.update(account));

            } catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Parametrii Invalizi!");
            } catch (NullPointerException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Persoana nu Exista!");
            }
        }
    }

    class listenerDeleteAccount implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Person person = new Person(theView.getPersonIdCont(), theView.getPersonNameAccount(), theView.getEmailAccountPerson());
                Account ac = new Account(person, theView.getIdAccount(), theView.getSumaAccount(), "tip");
                bank.removeAcount(ac);
                bank.afiseaza();

            } catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Parametrii Invalizi!");
            } catch (NullPointerException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Persoana nu Exista!");
            }
        }
    }

    class listenerAddMoney implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Person person = new Person(theView.getPersonIdCont(), theView.getPersonNameAccount(), theView.getEmailAccountPerson());
                System.out.println("viewGetMoney=" + theView.getMoneyTo());
                // Account ac = new Account(person,theView.getIdAccount(),theView.getSumaAccount(),"tip");
                bank.addMoney(person, theView.getIdAccount(), theView.getMoneyTo());
                bank.afiseaza();

            } catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Parametrii Invalizi!");
            } catch (NullPointerException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Persoana nu Exista!");
            } catch (ArithmeticException ex) {
                System.out.println(ex);
                theView.displayErrorMessage(ex.getMessage());
            }
        }
    }

    class listenerWithdraw implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Person person = new Person(theView.getPersonIdCont(), theView.getPersonNameAccount(), theView.getEmailAccountPerson());
                System.out.println("viewGetMoney=" + theView.getMoneyTo());
                // Account ac = new Account(person,theView.getIdAccount(),theView.getSumaAccount(),"tip");
                bank.withDraw(person, theView.getIdAccount(), theView.getMoneyTo());
                bank.afiseaza();

            } catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Parametrii Invalizi!");
            } catch (NullPointerException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Persoana nu Exista!");
            } catch (ArithmeticException ex) {
                System.out.println(ex);
                theView.displayErrorMessage(ex.getMessage());
            }
        }
    }

}
