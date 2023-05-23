package com.ATMInterface;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;

public class Welcome {
	
	public Welcome(){
	JFrame frame = new JFrame("ATM_Interface");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300, 300);
	
	
	JButton loginButton,registerButton;
	JLabel label;
	
	label=new JLabel("Welcome to ATM Interface");
	loginButton=new JButton("Login");
	registerButton=new JButton("Register");
	
	
	frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
	loginButton.setPreferredSize(new Dimension(150,40));
	registerButton.setPreferredSize(new Dimension(150,40));
	frame.add(label);
	frame.add(loginButton);
	frame.add(registerButton);


	frame.setVisible(true);
	
	
	
	loginButton.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			new Login();	
		}
	});
	
	
	registerButton.addActionListener(new ActionListener()
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			new Registration();
		}
		
	});
	}
	public static void main(String[] args) {
		
		new Welcome();
		
    }

	}


