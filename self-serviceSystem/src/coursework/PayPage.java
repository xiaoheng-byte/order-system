package coursework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PayPage extends JFrame{
	private JLabel title = new JLabel();
	private JLabel notice = new JLabel();
	private JLabel inputNo1 = new JLabel();
	private JLabel inputNo2 = new JLabel();
	private JLabel inputNo3 = new JLabel();
	private JLabel inputNo4 = new JLabel();
	private JLabel inputNo5 = new JLabel();
	private JLabel inputNo6 = new JLabel();
	private JButton submit = new JButton();
	private JButton submit1 = new JButton();
	private JButton submit2 = new JButton();
	private JButton back = new JButton();
	private JPanel p = new JPanel();
	private JLabel ps = new JLabel();
	public void pay(JPanel panel){
		p = panel;
		p.removeAll();
		p.repaint();
		String ms = Double.toString(Constants.getmoney());
		title.setText("Thanks For Your Order!");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new java.awt.Font("Dialog", 1, 20));
		title.setBounds(100,25,500,50);
		
		notice.setText("Please Choose One Way to Pay:");
		notice.setHorizontalAlignment(SwingConstants.CENTER);
		notice.setFont(new java.awt.Font("Dialog", 1, 14));
		notice.setBounds(100,70,500,50);
		
		inputNo1.setText("Total Price:");
		inputNo1.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo1.setBounds(200,130,180,50);
		inputNo2.setText(ms);
		inputNo2.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo2.setBounds(390,140,200,30);
		
		inputNo3.setText("Virtual Stamps:");
		inputNo3.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo3.setBounds(200,160,180,50);
		inputNo4.setText(Constants.gettemp());
		inputNo4.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo4.setBounds(390,170,200,30);
		
		inputNo5.setText("*If you are loyalty members and have more than 10 virtual Stamps");
		inputNo5.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo5.setBounds(100,250,700,50);
		inputNo6.setText("The meal will be free (Virtual stamps will also be reduced by 10)");
		inputNo6.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo6.setBounds(100,300,700,35);
		
		submit.setText("BACK");
		submit.setHideActionText(true);
		submit.setFont(new java.awt.Font("Dialog", 1, 20));
		submit.setBounds(30,380,200,50);
		submit.addActionListener(new submitAction());
					
		submit1.setText("Use Stamps");
		submit1.setHideActionText(true);
		submit1.setFont(new java.awt.Font("Dialog", 1, 20));
		submit1.setBounds(240,380,200,50);
		submit1.addActionListener(new submitAction1());
		
		submit2.setText("Use Cash/Card");
		submit2.setHideActionText(true);
		submit2.setFont(new java.awt.Font("Dialog", 1, 20));
		submit2.setBounds(450,380,200,50);
		submit2.addActionListener(new submitAction2());
		
		p.add(title);
		p.add(notice);
		p.add(inputNo1);
		p.add(inputNo2);
		p.add(inputNo3);
		p.add(inputNo4);
		p.add(inputNo5);
		p.add(inputNo6);
		p.add(ps);
		p.add(submit);
		p.add(submit1);
		p.add(submit2);
	}
	private class submitAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new ChoicePage().choice(p);
		}	
	}
	private class submitAction1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Constants.getflag()==2) {
				try {
					GenerateTicket.printTicket();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					FindString.changeStamps("ticket/pInfo.txt",FindString.change("ticket/pInfo.txt", Constants.getmember(), Constants.gettemp(),1));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					new LoyaltyAfterPay().afterpay(p);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				Object[] options ={ "OK"};
				int m = JOptionPane.showOptionDialog(null, "You cannot use this way to pay!", "Warning",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
   	 			return;
			}
		}	
	}
	private class submitAction2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Constants.getflag()==1 ||Constants.getflag()==2) {
				try {
					GenerateTicket.printTicket();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					FindString.changeStamps("ticket/pInfo.txt",FindString.change("ticket/pInfo.txt", Constants.getmember(), Constants.gettemp(),2));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					new LoyaltyAfterPay().afterpay(p);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				try {
					GenerateTicket.printTicket();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new EndPage().End(p);
			}
				
		}	
	}
}
