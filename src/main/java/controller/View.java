package controller;

import model.Bank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;

public class View {
    /**
     * frames
     */
    private JFrame frame = new JFrame();
    private JFrame frame1 = new JFrame();
    /**
     * panles
     */
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();
    /**
     * label
     */
    private JLabel title = new JLabel("Person");
    private JLabel id = new JLabel("ID");
    private JLabel name = new JLabel("Name");
    private JLabel email = new JLabel("Email");
    private JLabel personToEditID = new JLabel("Person to Edit ID");
    private JLabel personToEditName = new JLabel("Person to Edit Name");
    private JLabel personToEditEmail = new JLabel("Person to Edit Email");

    /**
     * text filds
     */
    private JTextField idF = new JTextField();
    private JTextField nameF = new JTextField();
    private JTextField emailF = new JTextField();
    private JTextField personToEditIDF = new JTextField();
    private JTextField personToEditNameF = new JTextField();
    private JTextField personToEditEmailF = new JTextField();
    private JButton show = new JButton("Show");
    private JButton insert = new JButton("Insert");
    private JButton update = new JButton("Edit");
    private JButton delete = new JButton("Delete");

    private JLabel title1 = new JLabel("Account");

    private JLabel personIdCont = new JLabel("Person Id");
    private JLabel personName = new JLabel("Person Name");
    private JLabel personEmail = new JLabel("Person Email");
    private JLabel nrCont = new JLabel("Nr. Cont");
    private JLabel sumaAcc = new JLabel("Suma");
    private JLabel sumaLabel = new JLabel("Money to Add/Withdraw");
    private JLabel nrContEdit = new JLabel("Nr. Cont to Edit");


    private JTextField personIdContF = new JTextField();
    private JTextField personNameF = new JTextField();
    private JTextField personEmailF = new JTextField();
    private JTextField nrContF = new JTextField();
    private JTextField sumaAccF = new JTextField();
    private JTextField sumaF = new JTextField();
    private JTextField nrContEditF = new JTextField();


    private JButton show1 = new JButton("Show");
    private JButton insertSpending = new JButton("Insert Spending");
    private JButton insertSaving = new JButton("Insert Saving");
    private JButton update1 = new JButton("Edit");
    private JButton delete1 = new JButton("Delete");
    private JButton btnAddMoney = new JButton("Add Money");
    private JButton btnWithDrawMoney = new JButton("Withdrawn");

    private JScrollPane pane;
    private JScrollPane pane1;


    private Bank bank;

    /**
     * constructor
     */
    public View() {

        bank = new Bank();

        pane = new JScrollPane();
        pane1 = new JScrollPane();


        title.setBounds(300, 20, 200, 30);
        title.setFont(new Font("Courier New", Font.ITALIC, 18));
        id.setBounds(40, 60, 20, 50);
        name.setBounds(40, 105, 50, 20);
        email.setBounds(40, 135, 50, 20);
        personToEditID.setBounds(40, 160, 200, 20);
        personToEditName.setBounds(40, 190, 200, 20);
        personToEditEmail.setBounds(40, 220, 200, 20);
        idF.setBounds(200, 70, 250, 20);
        nameF.setBounds(200, 100, 250, 20);
        emailF.setBounds(200, 130, 250, 20);
        personToEditIDF.setBounds(200, 160, 250, 20);
        personToEditNameF.setBounds(200, 190, 250, 20);
        personToEditEmailF.setBounds(200, 220, 250, 20);

        show.setBounds(120, 280, 100, 20);
        insert.setBounds(220, 280, 100, 20);
        update.setBounds(320, 280, 100, 20);
        delete.setBounds(420, 280, 100, 20);

        panel.add(title);
        panel.add(id);
        panel.add(name);
        panel.add(email);
        panel.add(personToEditID);
        panel.add(personToEditName);
        panel.add(personToEditEmail);
        panel.add(idF);
        panel.add(nameF);
        panel.add(emailF);
        panel.add(personToEditIDF);
        panel.add(personToEditNameF);
        panel.add(personToEditEmailF);
        panel.add(show);
        panel.add(insert);
        panel.add(update);
        panel.add(delete);
        panel.setLayout(null);

        title1.setBounds(300, 20, 200, 30);
        title1.setFont(new Font("Courier New", Font.ITALIC, 18));

        personIdCont.setBounds(50, 60, 100, 50);
        personName.setBounds(50, 105, 100, 20);
        personEmail.setBounds(50, 135, 100, 20);
        nrCont.setBounds(50, 160, 100, 30);
        sumaAcc.setBounds(50, 185, 100, 30);
        sumaLabel.setBounds(50, 245, 250, 30);
        nrContEdit.setBounds(50, 215, 100, 30);


        personIdContF.setBounds(200, 70, 250, 20);
        personNameF.setBounds(200, 100, 250, 20);
        personEmailF.setBounds(200, 130, 250, 20);
        nrContF.setBounds(200, 160, 250, 20);
        sumaAccF.setBounds(200, 190, 250, 20);
        sumaF.setBounds(200, 250, 250, 20);
        nrContEditF.setBounds(200, 220, 250, 20);


        show1.setBounds(60, 280, 100, 20);
        insertSpending.setBounds(160, 280, 150, 20);
        insertSaving.setBounds(160, 300, 150, 20);
        update1.setBounds(310, 280, 100, 20);
        delete1.setBounds(410, 280, 100, 20);
        btnAddMoney.setBounds(310, 300, 100, 20);
        btnWithDrawMoney.setBounds(410, 300, 100, 20);

        panel1.add(title1);

        panel1.add(personIdCont);
        panel1.add(personName);
        panel1.add(personEmail);
        panel1.add(nrCont);
        panel1.add(sumaAcc);
        panel1.add(sumaLabel);

        panel1.add(personIdContF);
        panel1.add(personNameF);
        panel1.add(personEmailF);
        panel1.add(nrContF);
        panel1.add(sumaAccF);
        panel1.add(sumaF);
        panel1.add(nrContEdit);
        panel1.add(nrContEditF);

        panel1.add(show1);
        panel1.add(insertSpending);
        panel1.add(insertSaving);
        panel1.add(update1);
        panel1.add(delete1);
        panel1.add(btnAddMoney);
        panel1.add(btnWithDrawMoney);

        panel1.setLayout(null);

        frame1.add(panel1);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(600, 600);
        frame1.setTitle("Account");
        frame1.setVisible(true);
        frame1.setLocation(700, 30);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setTitle("Person");
        frame.setVisible(true);
        frame.setLocation(50, 30);
    }

    public int getIdPerson() {

        return Integer.parseInt(idF.getText());
    }

    public String getNamePerson() {
        return nameF.getText();
    }

    public String getemailPerson() {
        return emailF.getText();
    }

    public int getEditIdPerson() {

        return Integer.parseInt(personToEditIDF.getText());
    }

    public String getEditNamePerson() {
        return personToEditNameF.getText();
    }

    public String getEditEmailPerson() {
        return personToEditEmailF.getText();
    }

    void showListener(ActionListener listenForButton) {
        show.addActionListener(listenForButton);
    }

    void insertListener(ActionListener listenForButton) {
        insert.addActionListener(listenForButton);
        bank.writeData(bank);
    }

    void updateListener(ActionListener listenForButton) {
        update.addActionListener(listenForButton);
    }

    void deleteListener(ActionListener listenForButton) {
        delete.addActionListener(listenForButton);
    }


    public int getPersonIdCont() {

        return Integer.parseInt(personIdContF.getText());
    }

    public String getPersonNameAccount() {

        return personNameF.getText();
    }

    public String getEmailAccountPerson() {

        return personEmailF.getText();
    }

    public int getIdAccount() {

        return Integer.parseInt(nrContF.getText());
    }

    public int getSumaAccount() {

        return Integer.parseInt(sumaAccF.getText());
    }

    public int getMoneyTo() {
        return Integer.parseInt(sumaF.getText());
    }

    public int getAccountOld() {

        return Integer.parseInt(nrContEditF.getText());
    }

    void showListenerAccount(ActionListener listenForButton) {
        show1.addActionListener(listenForButton);
    }

    void insertListenerAccount(ActionListener listenForButton) {
        insertSpending.addActionListener(listenForButton);
    }

    void insertListenerAccountSaving(ActionListener listenForButton) {
        insertSaving.addActionListener(listenForButton);
    }

    void updateListenerAccount(ActionListener listenForButton) {
        update1.addActionListener(listenForButton);
    }


    void addMoney(ActionListener listenForButton) {
        btnAddMoney.addActionListener(listenForButton);
    }

    void withDraw(ActionListener listenForButton) {
        btnWithDrawMoney.addActionListener(listenForButton);
    }

    void deleteListenerAccount(ActionListener listenForButton) {
        delete1.addActionListener(listenForButton);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage);
    }

    public void suntIdiot(WindowListener lis) {
        frame.addWindowListener(lis);
        frame1.addWindowListener(lis);
    }
    
    public void afisarePerson(Bank bank) {

        //Bank bank=new Bank();
        //Bank bank2=new Bank();
        DefaultTableModel model = new DefaultTableModel(bank.returnHash(), new Object[]{"Id", "Nume", "Email"});

        JTable table = new JTable(model);
        panel.remove(pane);
        panel.repaint();
        panel.validate();
        pane = new JScrollPane(table);

        pane.setBounds(35, 330, 500, 200);
        panel.add(pane);

        table.setModel(model);
        model.fireTableDataChanged();
    }

    public void afisareAccount(Bank bank) {


        // bank=bank.readData();
        System.out.println("retHah");
        //  bank.retHash();

        DefaultTableModel model = new DefaultTableModel(bank.returnHashAccount(), new Object[]{"Person Id", "Person Name", "Person Email", "Nr. Cont", "Sold", "Tip"});

        JTable table = new JTable(model);
        panel1.remove(pane1);
        panel1.repaint();
        panel1.validate();
        pane1 = new JScrollPane(table);

        pane1.setBounds(35, 330, 500, 200);
        panel1.add(pane1);

        table.setModel(model);
        model.fireTableDataChanged();
    }



}
