package banking;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class MainClass {


	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		JFrame  mainFrame= new JFrame("Bank of Ireland");
		
		JMenuBar mainMenu = new JMenuBar();
		JMenu accounts= new JMenu("Accounts");
		JMenu transactions= new JMenu("Transactions");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem details = new JMenuItem("Details");
		JMenuItem deposit = new JMenuItem("Deposit");
		JMenuItem withdrawl = new JMenuItem("Withdrawl");
		JMenuItem balance = new JMenuItem("Balance");
		
		JPanel transactionsPanel=new JPanel();
		Panel detailsPanel= new Panel();
		detailsPanel.setLayout(new GridLayout(2,2));
		
		Label nameLabel = new Label("Name");
		Label abbressLabel = new Label("Address");
		TextField name= new TextField(20);
		TextField address= new TextField(20);
		detailsPanel.add(nameLabel);
		detailsPanel.add(name);
		detailsPanel.add(abbressLabel);
		detailsPanel.add(address);
		
		
		Panel accNoPanel= new Panel();
		accNoPanel.setLayout(new FlowLayout());
		Label accLabel = new Label("Account No");
		TextField accNo= new TextField(7);
		Button getDetails= new Button("Get Account");
		accNoPanel.add(accLabel);
		accNoPanel.add(accNo);
		accNoPanel.add(getDetails);
		
		Panel accInfoPanel= new Panel();
		accInfoPanel.setLayout(new GridLayout(4,2));
		Label genderLabel = new Label("Gender");
		Label typeLabel = new Label("Account Type");
		Label balanceLabel = new Label("Current Balance");
		TextField genderFelid= new TextField(10);
		TextField typeFeild= new TextField(10);
		TextField currentBalance= new TextField(10);
		accInfoPanel.add(genderLabel);
		accInfoPanel.add(genderFelid);
		accInfoPanel.add(typeLabel);
		accInfoPanel.add(typeFeild);
		accInfoPanel.add(balanceLabel);
		accInfoPanel.add(currentBalance);
		
		Panel tPanel= new Panel();
		tPanel.setLayout(new FlowLayout());
		Label amountLabel = new Label("Amoumt");
		TextField amount= new TextField(7);
		Button depositButton= new Button();
		Button withdrawButton= new Button();
		tPanel.add(amountLabel);
		tPanel.add(amount);
		
		
		
		
		
		
		open.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame openFrame =new JFrame("Open Account");
				Panel radioPanel= new Panel();
				radioPanel.setLayout(new GridLayout(3,2));
				JRadioButton male = new JRadioButton ("Male");
				male.setActionCommand("M");
				JRadioButton female = new JRadioButton ("female");
				female.setActionCommand("F");
				JRadioButton current = new JRadioButton ("Current");
				current.setActionCommand("C");
				JRadioButton saving = new JRadioButton ("Saving");
				saving.setActionCommand("S");
				
				Label genderLabel = new Label("Gender");
				Label accountTypeLabel = new Label("Account Type");
				
				ButtonGroup gender = new ButtonGroup();
				ButtonGroup accountType = new ButtonGroup();
				gender.add(male);
				gender.add(female);
				accountType.add(saving);
				accountType.add(current);
				radioPanel.add(genderLabel);
				radioPanel.add(accountTypeLabel);
				radioPanel.add(male);
				radioPanel.add(current);
				radioPanel.add(female);
				radioPanel.add(saving);
				
				Button generate= new Button("Generate Account");
				BankEvent insertPress= new BankEvent(accountType,gender,name,address,openFrame);
			
				generate.addActionListener(insertPress);
			
				openFrame.add(detailsPanel,BorderLayout.NORTH);
				openFrame.add(radioPanel,BorderLayout.CENTER);
				openFrame.add(generate,BorderLayout.SOUTH);
				openFrame.setSize(400, 200);
				openFrame.setLocation(700, 300);
				openFrame.setVisible(true);
				
			}
			
		});
		

		
		deposit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				JFrame depositFrame= new JFrame("Deposit");
				accInfoPanel.add(tPanel);
				accInfoPanel.remove(withdrawButton);
				accInfoPanel.add(depositButton);
				depositFrame.add(accNoPanel,BorderLayout.NORTH);
				depositFrame.add(detailsPanel,BorderLayout.CENTER);
				depositFrame.add(accInfoPanel,BorderLayout.SOUTH);
				depositFrame.setSize(400, 300);
				depositFrame.setLocation(700, 300);
				depositFrame.setVisible(true);
				BankEvent getAcc= new BankEvent(accNo,genderFelid,typeFeild,name,address,currentBalance,depositFrame);
				
				getDetails.addActionListener(getAcc);
				depositButton.setLabel("Deposit");
				depositButton.addActionListener( new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(depositFrame.getTitle().equals("Deposit"))
						{
							getAcc.deposit(amount);
						}
						
						
					}});
				
			}
			
		});
		
		
		withdrawl.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				JFrame depositFrame= new JFrame("Withdrawl");
				accInfoPanel.add(tPanel);
				accInfoPanel.remove(depositButton);
				accInfoPanel.add(withdrawButton);
				
				depositFrame.add(accNoPanel,BorderLayout.NORTH);
				depositFrame.add(detailsPanel,BorderLayout.CENTER);
				depositFrame.add(accInfoPanel,BorderLayout.SOUTH);
				depositFrame.setSize(400, 300);
				depositFrame.setLocation(700, 300);
				depositFrame.setVisible(true);
				BankEvent getAcc= new BankEvent(accNo,genderFelid,typeFeild,name,address,currentBalance,depositFrame);
				
				getDetails.addActionListener(getAcc);
				withdrawButton.setLabel("Withdraw");
				withdrawButton.addActionListener( new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(depositFrame.getTitle().equals("Withdrawl"))
						{
							getAcc.withdraw(amount);
						}
						
					}});
				
			}
			
		});
		
		details.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				JFrame detailsFrame= new JFrame("Details");
				accInfoPanel.remove(tPanel);
				accInfoPanel.remove(withdrawButton);
				accInfoPanel.remove(depositButton);
				JTextArea transDetails= new JTextArea(5,50);
				transDetails.setEditable(false);
				transDetails.append("Transaction History \n");
				JScrollPane scrollPane = new JScrollPane(transDetails);
				
				
				BankEvent getAcc= new BankEvent(accNo,genderFelid,typeFeild,name,address,currentBalance,detailsFrame);
				getDetails.addActionListener(getAcc);
				getDetails.addActionListener(new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
						transDetails.append(getAcc.transactionPanel());
					   
					   
					    
					    
					    
					   
					}});
				//Label header= new Label("Transaction History");
				
				
				
				 scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				 scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				
				 transactionsPanel.add(scrollPane);
				detailsFrame.add(accNoPanel,BorderLayout.NORTH);
				detailsFrame.add(detailsPanel,BorderLayout.CENTER);
				detailsFrame.add(transactionsPanel,BorderLayout.SOUTH);
				detailsFrame.add(accInfoPanel,BorderLayout.EAST);
				detailsFrame.setSize(600, 300);
				detailsFrame.setLocation(700, 300);
				detailsFrame.setVisible(true);
			
			
				
			}
			
		});
		
		
		
		
		accounts.add(open);
		accounts.add(details);
		transactions.add(deposit);
		transactions.add(withdrawl);
		transactions.add(balance);
		mainMenu.add(accounts);
		mainMenu.add(transactions);
		
		
		mainFrame.add(mainMenu,BorderLayout.NORTH);
		mainFrame.setSize(400, 200);
		mainFrame.setLocation(300, 300);
		mainFrame.setVisible(true);
		
		
	}
}


