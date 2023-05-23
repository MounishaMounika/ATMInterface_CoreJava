package com.ATMInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Home {
	
	static double balance=0;
	static double monthlyInterest=0,loanAmount=0,monthlyAmount=0;
	static int installmentNum=0,installmentPaid=0;
	public static List<Object> transactionDetails = new ArrayList<>();
	double withdrawLimit=20000,withdrawnAmount=0;
	 int count=1;
	 
	public Home() {
		
		JFrame frame= new JFrame("ATM Interface");
		frame.setSize(300,300);
		
		JLabel welcomeMsg;
		JButton checkBalance,deposit,withdraw,logout,transfer,transactionHistory,donate,applyLoan;
		
		
		welcomeMsg=new JLabel("Welcome "+Registration.registrationDetails.get(0)+"!");
		checkBalance = new JButton("Check Balance");
		deposit = new JButton("Deposit");
		withdraw = new JButton("Withdraw");
		logout = new JButton("Logout");
		transfer = new JButton("Transfer");
		transactionHistory = new JButton("Transaction History");
		donate = new JButton("Donate");
		applyLoan = new JButton("Apply Loan");
		
		checkBalance.setPreferredSize(new Dimension(150,30));
		deposit.setPreferredSize(new Dimension(150,30));
		withdraw.setPreferredSize(new Dimension(150,30));
		transfer.setPreferredSize(new Dimension(150,30));
		donate.setPreferredSize(new Dimension(150,30));
		applyLoan.setPreferredSize(new Dimension(150,30));
		transactionHistory.setPreferredSize(new Dimension(150,30));
		logout.setPreferredSize(new Dimension(150,30));
		
	    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

	    JPanel welcomePanel,checkPanel,depositPanel,withdrawPanel,transferPanel,transactionPanel,logoutPanel,donatePanel,loanPanel;
	    
	    welcomePanel=new JPanel();
	    checkPanel=new JPanel();
	    depositPanel=new JPanel();
	    withdrawPanel=new JPanel();
	    transferPanel=new JPanel();
	    transactionPanel=new JPanel();
	    logoutPanel=new JPanel();
	    donatePanel=new JPanel();
	    loanPanel=new JPanel();
	    
	    welcomePanel.add(welcomeMsg);
	    checkPanel.add(checkBalance);
	    depositPanel.add(deposit);
	    withdrawPanel.add(withdraw);
	    transferPanel.add(transfer);
	    donatePanel.add(donate);
	    loanPanel.add(applyLoan);
	    transactionPanel.add(transactionHistory);
	    logoutPanel.add(logout);
	    
	  
	    frame.add(welcomePanel);
	    frame.add(checkPanel);
	    frame.add(depositPanel);
	    frame.add(withdrawPanel);
	    frame.add(transferPanel);
	    frame.add(loanPanel);
	    frame.add(donatePanel);
	    frame.add(transactionPanel);
	    frame.add(logoutPanel);
	    
	    JPanel containerPanel = new JPanel();
	    containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
	    containerPanel.add(welcomePanel);
	    containerPanel.add(checkPanel);
	    containerPanel.add(depositPanel);
	    containerPanel.add(withdrawPanel);
	    containerPanel.add(transferPanel);
	    containerPanel.add(loanPanel);
	    containerPanel.add(donatePanel);
	    containerPanel.add(transactionPanel);
	    containerPanel.add(logoutPanel);

	    JScrollPane scrollPane = new JScrollPane(containerPanel);

	    frame.add(scrollPane);

		frame.setVisible(true);
	
	//Button to check balance
	checkBalance.addActionListener(new ActionListener()
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame f=new JFrame("Balance");
			f.setSize(300,300);
			f.setLayout(new FlowLayout());
			f.setVisible(true);
			
			JLabel l1 =new JLabel("Balance : ");
			JLabel l2 =new JLabel(Double.toString(balance));
			f.add(l1);
			f.add(l2);
			
		}
		
			
	});
	
	//Button to deposit amount
	deposit.addActionListener(new ActionListener()
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame f=new JFrame("Deposit");
			f.setSize(300,300);
			f.setLayout(new FlowLayout());
			f.setVisible(true);
			
			JLabel l1 = new JLabel("Enter amount to deposit");
			JTextField tf = new JTextField(20);
			JButton submit = new JButton("Deposit");
			
			f.add(l1);
			f.add(tf);
			f.add(submit);
			
			submit.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e1) {
					if(tf.getText().equals(""))
					{
						JOptionPane.showMessageDialog(f, "Field can't be empty", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						double depositAmount=0;
					try
					{
					depositAmount=Double.parseDouble(tf.getText());
					}catch(NumberFormatException e){
						JOptionPane.showMessageDialog(f, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					balance = balance + depositAmount;
					transactionDetails.add(Registration.registrationDetails.get(1));
					transactionDetails.add(tf.getText());
					transactionDetails.add("Deposited");
					JOptionPane.showMessageDialog(f, "Amount deposited Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
					}
					
				
			}
	});
	}
				
});
	      //Button to withdraw amount
	withdraw.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame f=new JFrame("Withdraw");
			f.setSize(300,300);
			f.setLayout(new FlowLayout());
			f.setVisible(true);

			JLabel l1 = new JLabel("Enter amount to Withdraw");
			JTextField tf = new JTextField(20);
			JButton submit = new JButton("Withdraw");

			f.add(l1);
			f.add(tf);
			f.add(submit);

			submit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(tf.getText().equals("")) {
						JOptionPane.showMessageDialog(f, "Field can't be empty", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						double withdrawAmount;
						try
						{
						withdrawAmount= Double.parseDouble(tf.getText());
						}catch(NumberFormatException exception){
							JOptionPane.showMessageDialog(f, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(balance <= 0 || balance<=Double.parseDouble(tf.getText()) ) {
							JOptionPane.showMessageDialog(f, "Insufficient Balance", "Error", JOptionPane.ERROR_MESSAGE);
						} else if(withdrawLimit <= 0) {
							JOptionPane.showMessageDialog(f, "Withdraw limit exceeded", "Error", JOptionPane.ERROR_MESSAGE);
						} else if(withdrawAmount > withdrawLimit) {
							JOptionPane.showMessageDialog(f, "You can withdraw only "+withdrawLimit+" amount", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							balance = balance - withdrawAmount;
							withdrawLimit = withdrawLimit - withdrawAmount;
							withdrawnAmount = withdrawnAmount + withdrawAmount;
							transactionDetails.add(Registration.registrationDetails.get(1));
							transactionDetails.add(tf.getText());
							transactionDetails.add("Withdrawn");
							JOptionPane.showMessageDialog(f, "Amount Withdrawn Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}	
			});
		}
	});

	       
	       //Transfer Button
	       transfer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame("Transfer");
				f.setSize(300,300);
				f.setLayout(new FlowLayout());
				f.setVisible(true);
				
				JLabel l1=new JLabel("Enter account number to Transfer");
				JTextField tf = new JTextField(20);
				JLabel l2=new JLabel("Enter Amount");
				JTextField tf1 = new JTextField(20);
				JButton submit=new JButton("Transfer");
				
				f.add(l1);
				f.add(tf);
				f.add(l2);
				f.add(tf1);
				f.add(submit);
				
				submit.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
					
						double amount;
						long accNum;
						try
						{
							amount=Double.parseDouble(tf1.getText());
							accNum=Long.parseLong(tf.getText());
						}catch(NumberFormatException exception){
							JOptionPane.showMessageDialog(f, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(tf.getText().equals("") || tf1.getText().equals("")){
							JOptionPane.showMessageDialog(f, "Field's can't be empty", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else if(Registration.registrationDetails.get(1).equals(tf.getText())) {
							JOptionPane.showMessageDialog(f, "Your Account Number and Transfer Account Can't be same", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else if(balance >= amount)
						{
						balance = balance-amount;
						transactionDetails.add(accNum);
						transactionDetails.add(tf1.getText());
						transactionDetails.add("Transferred");
						JOptionPane.showMessageDialog(f, "Transferred successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(f, "Insufficient Balance", "Error", JOptionPane.ERROR_MESSAGE);
						}
						}
						
					
				
				});
				
			}
	       
	       });
	       //Button to donate Amount
	       donate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFrame("Donate");
				f.setSize(300,300);
				f.setLayout(new FlowLayout());
				f.setVisible(true);
				
				JLabel l1 = new JLabel("Enter amount to Donate");
				JTextField tf = new JTextField(20);
				JButton submit = new JButton("Donate");
				
				f.add(l1);
				f.add(tf);
				f.add(submit);
				
				submit.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						double amount;
						try
						{
							amount=Double.parseDouble(tf.getText());
						}catch(NumberFormatException exception){
							JOptionPane.showMessageDialog(f, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(tf.getText().equals(""))
						{
							JOptionPane.showMessageDialog(f, "Field can't be empty", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else if(balance >= amount)
						{
							balance = balance-amount;
							transactionDetails.add(Registration.registrationDetails.get(1));
							transactionDetails.add(tf.getText());
							transactionDetails.add("Donated");
							JOptionPane.showMessageDialog(f, "Thankyou! Amount donated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(f, "Insufficient Balance", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					
				});
				
				
			}
	    	   
	       });
	       //Button to applyLoan
	       applyLoan.addActionListener(new ActionListener() {
	    	  
	    	  
	    	  
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFrame("Loan");
				f.setSize(300,300);
				f.setLayout(new FlowLayout());
				f.setVisible(true);
				
				JLabel amount,month,monthlyIncome;
				JButton submit,payInstallment;
				JCheckBox terms;
				JTextField principle,time,income;
				
				amount=new JLabel("Enter Loan Amount");
				month=new JLabel("Enter duration in Months");
				monthlyIncome=new JLabel("Enter your monthly Income");
				submit =new JButton("Take Loan");
				terms=new JCheckBox("Terms & Conditions");
				principle = new JTextField(20);
				time = new JTextField(20);
				income = new JTextField(20);
				JLabel rate=new JLabel("Note : You have to pay 2% Interest per Month");
				payInstallment=new JButton("Pay Installment");
				
				f.add(amount);
				f.add(principle);
				f.add(month);
				f.add(time);
				f.add(monthlyIncome);
				f.add(income);
				f.add(terms);
				f.add(submit);
				f.add(rate);
				f.add(payInstallment);
				
				
				
				submit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						double principle1,time1,income1;
						try {
							principle1=Double.parseDouble(principle.getText());
							time1=Double.parseDouble(time.getText());
							income1=Double.parseDouble(income.getText());
						}catch(NumberFormatException exception){
							JOptionPane.showMessageDialog(f, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(count==1)
						{
						if(principle.getText().equals("") || time.getText().equals("") || income.getText().equals("")){
							 JOptionPane.showMessageDialog(f, "Please enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
						}else {
							if(terms.isSelected())
							{
								monthlyInterest = ((principle1*time1*2)/100)/time1;
								loanAmount= principle1;
								installmentNum=Integer.parseInt(time.getText());
								if(income1>Math.round((monthlyInterest+(loanAmount/installmentNum))*100)/100)
								{
									balance = balance + principle1;
									transactionDetails.add(Registration.registrationDetails.get(1));
									transactionDetails.add(principle.getText());
									transactionDetails.add("Loan Credited");
									monthlyAmount=Math.round((monthlyInterest+(loanAmount/installmentNum))*100)/100;
									count--;
									JOptionPane.showMessageDialog(f, "Loan Confirmed for "+time.getText()+" months! You have to pay "+monthlyAmount+" per month", "Success", JOptionPane.INFORMATION_MESSAGE);
									
								}
								else {
									JOptionPane.showMessageDialog(f, "Loan Denied! Your Monthly Income is low", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}else {
								JOptionPane.showMessageDialog(f, "Please accept Terms & Conditions", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						
					}
					}
					
				});
				
				payInstallment.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame f = new JFrame("Loan");
						f.setSize(300,300);
						f.setLayout(new FlowLayout());
						f.setVisible(true);
						if(loanAmount==0)
						{
							JLabel msg=new JLabel("No Loan Taken");
							f.add(msg);
						}
						else {
							JLabel instAmount = new JLabel("Installment Amount: "+monthlyAmount);
							JLabel msg=new JLabel("You have to Pay "+installmentNum+" Installments");
							JLabel msg2=new JLabel("Enter Installment amount");
							JTextField amount=new JTextField(20);
							JButton pay = new JButton("Pay");
							JLabel msg1 = new JLabel("You paid "+installmentPaid+" Installments");
							
							pay.setPreferredSize(new Dimension(150,25));
							
							f.add(instAmount);
							f.add(msg);
							f.add(msg2);
							f.add(amount);
							f.add(pay);
							f.add(msg1);
							
							pay.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									double amount1;
									try
									{
										amount1=Double.parseDouble(amount.getText());
									}catch(NumberFormatException exception){
										JOptionPane.showMessageDialog(f, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
										return;
									}
									if(amount.getText().equals(""))
									{
										JOptionPane.showMessageDialog(f, "Field can't be empty", "Error", JOptionPane.ERROR_MESSAGE);
									}
									else if(installmentNum!=installmentPaid) {
										if(balance>=(Math.round((monthlyInterest+(loanAmount/installmentNum))*100)/100)){
									if(amount1!=Math.round((monthlyInterest+(loanAmount/installmentNum))*100)/100){
										JOptionPane.showMessageDialog(f, "Incorrect amount entered", "Error", JOptionPane.ERROR_MESSAGE);
									}else if(installmentPaid!=(installmentNum-1)) {
										balance = balance - amount1;
										transactionDetails.add(Registration.registrationDetails.get(1));
										transactionDetails.add(amount.getText());
										transactionDetails.add("Installment Paid");
										installmentPaid++;
										JOptionPane.showMessageDialog(f, "Payment Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
									}else if(installmentPaid==(installmentNum-1))
									{
										balance = balance - amount1;
										transactionDetails.add(Registration.registrationDetails.get(1));
										transactionDetails.add(amount.getText());
										transactionDetails.add("Installment Paid");
										installmentPaid=0;
										installmentNum=0;
										monthlyAmount=0;
										loanAmount=0;
										JOptionPane.showMessageDialog(f, "Loan Cleared", "Success", JOptionPane.INFORMATION_MESSAGE);
									}
										}else {
											JOptionPane.showMessageDialog(f, "Insufficient Balance", "Error", JOptionPane.ERROR_MESSAGE);
										}
								}
								
								}
							});
							
						}
						
					}
					
				});
			}
	    	   
	       });
	       //TransactionHistory Button
	       transactionHistory.addActionListener(new ActionListener() {
	    	    @Override
	    	    public void actionPerformed(ActionEvent e) {
	    	        JFrame f = new JFrame("Transaction History");
	    	        f.setSize(300, 300);

	    	        String[] columnNames = { "Account Number", "Amount", "Action Performed" };
	    	        Object[][] data = new Object[transactionDetails.size() / 3][3];

	    	        int rowIndex = 0;
	    	        for (int i = 0; i < transactionDetails.size(); i += 3) {
	    	            data[rowIndex][0] = transactionDetails.get(i);
	    	            data[rowIndex][1] = transactionDetails.get(i + 1);
	    	            data[rowIndex][2] = transactionDetails.get(i + 2);
	    	            rowIndex++;
	    	        }

	    	        JTable table = new JTable(data, columnNames);
	    	        table.getColumnModel().getColumn(0).setPreferredWidth(110);
	    	        table.getColumnModel().getColumn(1).setPreferredWidth(80);
	    	        table.getColumnModel().getColumn(2).setPreferredWidth(110);

	    	        JScrollPane scrollPane = new JScrollPane(table);

	    	        f.add(scrollPane);
	    	        f.setVisible(true);
	    	    }
	    	});

	       
	
	       //Logout button
	       logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new Welcome();
				
			}
	    	   
	       });
	       
	
}

}

