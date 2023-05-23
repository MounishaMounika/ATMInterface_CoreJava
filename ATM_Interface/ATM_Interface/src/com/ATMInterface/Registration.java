package com.ATMInterface;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Registration {
	
	
	JTextField nameText,accountNumberText;
	JPasswordField pinText,confirmPinText;
	public static List<Object> registrationDetails =new ArrayList<>();
	
	JFrame frame=new JFrame("Registration Page");
	

	public Registration() {
		
		JLabel name,accountNumber,pin,confirmPin;
		JButton registerButton;
		frame.setSize(300,300);
		
		
		name = new JLabel("Enter Name");
		accountNumber = new JLabel("Enter Account Number");
		pin = new JLabel("Enter Pin");
		confirmPin = new JLabel("Re-enter Pin");
		
		nameText = new JTextField(20);
		accountNumberText = new JTextField(20);
		pinText = new JPasswordField(20);
		confirmPinText = new JPasswordField(20);
		
		registerButton =new JButton("Register");
		
		frame.setLayout(new FlowLayout());
		frame.add(name);
		frame.add(nameText);
		frame.add(accountNumber);
		frame.add(accountNumberText);
		frame.add(pin);
		frame.add(pinText);
		frame.add(confirmPin);
		frame.add(confirmPinText);
		frame.add(registerButton);
		
		frame.setVisible(true);
		
		registerButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				clickedOnRegister();
			}
			
		});
		
	}

	@SuppressWarnings("deprecation")
	public void clickedOnRegister() {
		
		if(nameText.getText().length()==0 || accountNumberText.getText().length()==0 || pinText.getText().length()==0 || confirmPinText.getText().length()==0)
        {
            JOptionPane.showMessageDialog(frame, "Please enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
		
		registrationDetails.clear();	
		registrationDetails.add(nameText.getText());
		registrationDetails.add(accountNumberText.getText());
		registrationDetails.add(pinText.getText());
		registrationDetails.add(confirmPinText.getText());
		
	
		
		if(!registrationDetails.get(2).equals(registrationDetails.get(3)))
		{
			JOptionPane.showMessageDialog(frame, "Pin and Confirm Pin are not same", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			Home.balance=0;
			Home.monthlyInterest=0;
			Home.loanAmount=0;Home.monthlyAmount=0;
			Home.installmentNum=0;Home.installmentPaid=0;
			Home.transactionDetails.clear();
			JOptionPane.showMessageDialog(frame, "Registration successful! You can login now", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
}
