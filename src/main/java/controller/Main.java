package controller;



public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

		/*Bank bank=new Bank();
		Bank bank2=new Bank();
		Person person1= new Person(1,"ion","ion@dssd");
		Person person2= new Person(2,"ion2","ion@dssd");
		Person person3= new Person(3,"ion3","ion@dssd");
		//Person person4= new Person(4,"ion4","ion@dssd");

		Account ac=new Account(person1,1,88);
		Account ac1=new Account(person1,2,100);
		Account ac3=new Account(person2,1,100);
		Account ac4=new Account(person2,2,110);

		bank.addPerson(person1);
		bank.addPerson(person2);
		bank.addAcount(ac);
		bank.addAcount(ac1);
		bank.addPerson(person3);
		//bank.addPerson(person4);

		bank.afiseaza();

		//bank.removeAcount(ac);
		//bank.removePerson(person2);
		bank.editPerson(1, "Marie", "marie@palarie", person1);
		bank.addAcount(ac3);
		bank.addAcount(ac4);
		bank.editAccount(person2,1, 2234, 99);
		bank.addMoney(person2, 2234, 1);
		bank.withDraw(person2, 2234, 1);

	//	bank.afiseaza();

		bank.writeData(bank);
		bank2=bank.readData();

		bank2.afiseaza();
		*/
        View view = new View();
        Controller theController = new Controller(view);

    }

}
