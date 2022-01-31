package coursework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class ChoicePage extends JFrame{
	private JLabel title = new JLabel();
	private JLabel notice = new JLabel();
	private ImageIcon image = new ImageIcon ("images/eatin.jpg");
	private ImageIcon image2 = new ImageIcon ("images/away.jpg");
	private JLabel picture1 = new JLabel();
	private JLabel picture2 = new JLabel();
	private JButton email = new JButton();
	private JButton phone = new JButton();
	private JButton submit = new JButton();
	private JButton submit1 = new JButton();

	private  JPanel p = new JPanel();
	
	public void choice(JPanel panel) {
		p = panel;
		p.removeAll();
		p.repaint();
		
		title.setText("Select One Way to Eat !");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new java.awt.Font("Dialog", 1, 20));
		title.setBounds(100,25,500,50);
		
		notice.setText("Please Select Eat In Or Take Away");
		notice.setHorizontalAlignment(SwingConstants.CENTER);
		notice.setFont(new java.awt.Font("Dialog", 1, 14));
		notice.setBounds(100,70,500,50);
		
		image.setImage(image.getImage().getScaledInstance(290, 200,Image.SCALE_DEFAULT ));
		picture1.setBounds(30, 120, 400, 200);
		picture1.setIcon(image);
		image2.setImage(image2.getImage().getScaledInstance(290, 200,Image.SCALE_DEFAULT ));
		picture2.setBounds(360, 120, 400, 200);
		picture2.setIcon(image2);
		
		submit.setText("BACK");
		submit.setHideActionText(true);
		submit.setFont(new java.awt.Font("Dialog", 1, 20));
		submit.setBounds(200,370,300,50);
		submit.addActionListener(new backAction());
		
		email.setText("Eat In");
		email.setHideActionText(true);
		email.setFont(new java.awt.Font("Dialog", 1, 18));
		email.setBounds(30,310,290,40);
		email.addActionListener(new eatinAction());
		
		phone.setText("Take Away");
		phone.setHideActionText(true);
		phone.setFont(new java.awt.Font("Dialog", 1, 18));
		phone.setBounds(360,310,290,40);
		phone.addActionListener(new takeAction());
		
		p.add(title);
		p.add(notice);
		p.add(submit);
		p.add(email);
		p.add(phone);
		p.add(picture1);
		p.add(picture2);
		p.setBackground(Color.white);
		p.setBounds(0,0,700,500);
		p.setLayout(null);
		
		
	}

	private class eatinAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Constants.setway(1);
			try {
				GenerateTicket.calcu();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			new PayPage().pay(p);
		}
		
	}
	private class takeAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Constants.setway(2);
			try {
				GenerateTicket.calcu();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			new PayPage().pay(p);
		}
		
	}
	private class backAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new AddPage().Add(p);
		}
		
	}

}
