package banking;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BankEvent implements ActionListener  {
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 static final String DB_URL = "jdbc:mysql://localhost/banking";
	 static final String USER = "root";
	 static final String PASS = "";
	 JFrame currentFrame;
	 Connection conn = null;
	 Statement stmt = null;
	 ButtonGroup accountType,gender;
	 TextField name, address, accountNo, accountTypeFeild,genderFelid,currentBalance,amount;
	 String myAccount;
	 Double balance;
	 
	 

	public BankEvent(ButtonGroup accountType, ButtonGroup gender, TextField name, TextField address, JFrame currentFrame) {
	this.accountType=accountType;
	this.gender= gender;
	this.name=name;
	this.address=address;
	this.currentFrame=currentFrame;
	}

	public BankEvent(TextField accNo, TextField genderFelid,TextField typeFeild, TextField name, TextField address,TextField currentBalance, JFrame currentFrame) {
		// TODO Auto-generated constructor stub
		this.accountNo=accNo;
		this.genderFelid= genderFelid;
		this.accountTypeFeild=typeFeild;
		this.name=name;
		this.address=address;
		this.currentBalance=currentBalance;
		this.currentFrame=currentFrame;
	}


	@Override
	public void actionPerformed(ActionEvent x) {
		// TODO Auto-generated method stub
		Button y=(Button)x.getSource();
		String buttonName=y.getLabel();
		System.out.println(buttonName);
		switch(buttonName){
		case "Generate Account": accountInsert();
		break;
		
		case "Get Account": getDetails();
		break;
		
		
		}
		
	}
	
	public void accountInsert()
	{
		String sql;
		String accountNo="";
		ResultSet rs = null;
		String name = this.name.getText();
		String address = this.address.getText();
		String acc =this.accountType.getSelection().getActionCommand();
		String gender=this.gender.getSelection().getActionCommand();
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(DB_URL,USER,PASS);
			 stmt = conn.createStatement();
		
		     sql ="select concat('"+acc+"','"+gender+"', LPAD(ifnull(max(substring(accountno,3,3))+1,'001'),3,'0'))from accounts where substring(accountno,1,1)='"+acc+"'";
		     System.out.println("SQL= "+sql);
		     rs = stmt.executeQuery(sql);
		     while(rs.next()){
		    	 accountNo=rs.getString(1);
		    System.out.println("account no= "+rs.getString(1));

		      }
		     
		     sql="insert into accounts values('"+accountNo+"','"+name+"','"+address+"')";
		     stmt.executeUpdate(sql);
		     JOptionPane.showMessageDialog(currentFrame,"Account No:"+accountNo+" has been Created");
		     
		     rs.close();
		     stmt.close();
		     conn.close();
		     reset();
		     currentFrame.dispose();
			 
		 }
		 catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		
	
	}
	

	public void getDetails()
	{
		ResultSet rs = null;
		this.myAccount= this.accountNo.getText();
		String sql="select a.accountNo,a.name,a.address, substring(a.accountno,1,1)as type,substring(a.accountno,2,1)as gender, ((select sum(amount)from transactionLog where accountno='"+myAccount+"' and actionTaken='D')-(select sum(amount)from transactionLog where accountno='"+myAccount+"' and actionTaken='W'))as balance \r\n" + 
				"from accounts a,transactionLog t \r\n" + 
				"where a.accountNo=t.accountNo and a.accountNo='"+myAccount+"'\r\n" + 
				"GROUP by a.accountNo";
		
		 
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(DB_URL,USER,PASS);
			 stmt = conn.createStatement();
		     rs = stmt.executeQuery(sql);
		    if(!rs.isBeforeFirst())
		    {
		    	reset();
		    	 JOptionPane.showMessageDialog(currentFrame,"Account No:"+myAccount+" does not Exsist");
		    }
		     while(rs.next()){
		    	
		    System.out.println("account no= "+rs.getString(1));
		   this.accountNo.setText(rs.getString(1));
		   this.name.setText(rs.getString(2));
		   this.address.setText(rs.getString(3));
		   
		  if(rs.getString(5).equalsIgnoreCase("M"))
		  {
			  this.genderFelid.setText("Male");
		  }
		  else
		  {
			  this.genderFelid.setText("Female");
		  }
		  
		  if(rs.getString(4).equalsIgnoreCase("S"))
		  {
			  this.accountTypeFeild.setText("Saving");
		  }
		  else
		  {
			  this.accountTypeFeild.setText("Current");
		  }
		   
		   
		   this.balance=(double) rs.getInt(6);
		   this.currentBalance.setText(""+ this.balance);

		      }
		     
		     stmt.close();
		     conn.close();
			 
		 }
		 catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
	
	}
	
	public void deposit(TextField amount){
		
		String sql;
		
		this.amount=amount;
		double amountDouble = Double.parseDouble(this.amount.getText());
		
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(DB_URL,USER,PASS);
			 stmt = conn.createStatement();
		     
		     sql="insert into transactionlog(actionTaken,accountNo,amount) values('D','"+myAccount+"',"+amountDouble+")";
		     System.out.println("the deposit sql is "+sql);
		     stmt.executeUpdate(sql);
		     JOptionPane.showMessageDialog(currentFrame,"€"+amountDouble+" has been deposited into Account No: "+myAccount.toUpperCase()+". Your new balance is"+(this.balance+amountDouble));
		     
		 
		     stmt.close();
		     conn.close();
		     reset();
		     currentFrame.dispose();
			 
		 }
		 catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		
		
	}
	
	
	
public void withdraw(TextField amount){
		
		String sql;
		this.amount=amount;
		double amountDouble = Double.parseDouble(this.amount.getText());
		double newBalance=(this.balance-amountDouble);
		System.out.println("Balance:"+this.balance+" amount:"+amountDouble);
		
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(DB_URL,USER,PASS);
			 stmt = conn.createStatement();
		     if(newBalance>=0)
		     {
		    	 
		    	 System.out.println("New Balance:"+newBalance);
		    	 sql="insert into transactionlog(actionTaken,accountNo,amount) values('W','"+myAccount+"',"+amountDouble+")";
			     System.out.println("the withdraw sql is "+sql);
			     stmt.executeUpdate(sql);
			     JOptionPane.showMessageDialog(currentFrame,"€"+amountDouble+" has been Withdrawn from Account No:"+myAccount.toUpperCase()+". Your new balance is €"+newBalance);
			    
			     reset();
			     currentFrame.dispose();
		     }
		     else{
			     JOptionPane.showMessageDialog(currentFrame,"You Have Insufficient Funds in your account to make this Withdrawl. Please Try a new amount!" ,"Inane error",
			    		    JOptionPane.ERROR_MESSAGE);
			     this.amount.setText("");
		     }
		     
		     stmt.close();
		     conn.close();
		     
			 
		 }
		 catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		
		
	}

public String transactionPanel(){
	String transaction = "";
	
	ResultSet rs = null;
	String sql;
	String newline = "\n";
	String tab="\t";


	 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 conn = DriverManager.getConnection(DB_URL,USER,PASS);
		 stmt = conn.createStatement();
	     
	    
	    	 sql="select actionTaken, amount, DATE_FORMAT(transactionDate, ' %d %m %y') from transactionlog where accountno='" +myAccount+"'";
		     System.out.println("the deposit sql is "+sql);
		     rs=stmt.executeQuery(sql);
		    
		     transaction=transaction+"Date" + tab+ "Action"+tab+ "Amount"+newline;
		 
		     while(rs.next()){
			   
		    	 transaction=transaction+rs.getString(3)+tab+ rs.getString(1)+tab+ +rs.getInt(2)+newline;
			    
			     System.out.println("DATE: "+rs.getString(3)+" ACTION:"+rs.getString(1)+" AMOUNT:"+rs.getInt(2));
		    	
				      }
	     
	     rs.close();
	     stmt.close();
	     conn.close();
 
	 }
	 catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }

	return transaction;
}



	public void reset() {
		
		 
		 this.name.setText("");
		 this.address.setText("");
		 this.accountNo.setText("");
		 this.genderFelid.setText("");
		 this.accountTypeFeild.setText("");
		 this.currentBalance.setText("");
		
	if(this.amount  !=null)  this.amount.setText("");
	if (this.accountType != null)	 this.accountType.clearSelection();
	if (this.gender != null)	 this.gender.clearSelection();	
	}

	

}
