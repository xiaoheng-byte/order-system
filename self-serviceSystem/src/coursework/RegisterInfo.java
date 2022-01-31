package coursework;

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

public class RegisterInfo extends JFrame{
	private JLabel title = new JLabel();
	private JLabel notice = new JLabel();
	private JLabel inputNo1 = new JLabel();
	private JLabel inputNo2 = new JLabel();
	private JLabel inputNo3 = new JLabel();
	private JLabel inputNo4 = new JLabel();
	private JLabel inputNo5 = new JLabel();
	private JLabel inputNo6 = new JLabel();
	private JLabel inputNo7 = new JLabel();
	private JLabel inputNo8 = new JLabel();
	private JLabel inputNo9 = new JLabel();
	private JLabel inputNo0 = new JLabel();
	private JButton submit = new JButton();
	private JButton submit1 = new JButton();
	private JButton back = new JButton();
	private JPanel p = new JPanel();
	private JLabel ps = new JLabel();
	
	public void info(JPanel panel,String t,String t1,String t2,String t3,String t4){
		p = panel;
		p.removeAll();
		p.repaint();
		title.setText("Welcome to Loyalty scheme!");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new java.awt.Font("Dialog", 1, 20));
		title.setBounds(100,25,500,50);
		
		notice.setText("Here Are Your Personal Information and Membership Number:");
		notice.setHorizontalAlignment(SwingConstants.CENTER);
		notice.setFont(new java.awt.Font("Dialog", 1, 14));
		notice.setBounds(100,70,500,50);
		
		inputNo1.setText("Membership Number:");
		inputNo1.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo1.setBounds(200,130,180,50);
		inputNo2.setText(t);
		inputNo2.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo2.setBounds(390,140,200,30);
		
		inputNo3.setText("First Name:");
		inputNo3.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo3.setBounds(200,160,180,50);
		inputNo4.setText(t1);
		inputNo4.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo4.setBounds(390,170,200,30);
		
		inputNo5.setText("Last Name:");
		inputNo5.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo5.setBounds(200,190,180,50);
		inputNo6.setText(t2);
		inputNo6.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo6.setBounds(390,200,200,30);
		
		inputNo7.setText("Contact Details:");
		inputNo7.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo7.setBounds(200,220,180,50);
		inputNo8.setText(t3);
		inputNo8.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo8.setBounds(390,230,200,30);
		
		inputNo9.setText("Virtual Stamps:");
		inputNo9.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo9.setBounds(200,250,180,50);
		inputNo0.setText(t4);
		inputNo0.setFont(new java.awt.Font("Dialog", 1, 16));
		inputNo0.setBounds(390,260,200,30);
		
		ps.setText("*Notification: You can use your membership number to log in and order food now !");
		ps.setFont(new java.awt.Font("Dialog", 1, 12));
		ps.setBounds(90,300,900,50);
		
		submit.setText("BACK");
		submit.setHideActionText(true);
		submit.setFont(new java.awt.Font("Dialog", 1, 20));
		submit.setBounds(100,370,240,50);
		
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new  RegisterPage().register(p);		
				}
		});
		//submit.addActionListener(new submitAction());
		
		submit1.setText("LOGIN");
		submit1.setHideActionText(true);
		submit1.setFont(new java.awt.Font("Dialog", 1, 20));
		submit1.setBounds(350,370,240,50);
		submit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Constants.setmember(t);
				Constants.settemp("0");
				new  DirectlyLogin ().ESPanel(p,"0");
			
				}
		});
		//submit.addActionListener(new submitAction());
		p.add(title);
		p.add(notice);
		p.add(inputNo1);
		p.add(inputNo2);
		p.add(inputNo3);
		p.add(inputNo4);
		p.add(inputNo5);
		p.add(inputNo6);
		p.add(inputNo7);
		p.add(inputNo8);
		p.add(inputNo9);
		p.add(inputNo0);
		p.add(ps);
		p.add(submit);
		p.add(submit1);
	}
}