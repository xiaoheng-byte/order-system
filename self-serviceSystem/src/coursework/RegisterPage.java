package coursework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegisterPage extends JFrame{
	private JLabel title = new JLabel();
	private JLabel notice = new JLabel();
	private ImageIcon image = new ImageIcon ("images/e-mail.png");
	private ImageIcon image2 = new ImageIcon ("images/phone.png");
	private JLabel picture1 = new JLabel();
	private JLabel picture2 = new JLabel();
	private JButton email = new JButton();
	private JButton phone = new JButton();
	private JButton submit = new JButton();
	private JButton submit1 = new JButton();

	private  JPanel p = new JPanel();
	
	public void register() {
		JFrame registerPage = new JFrame();
		registerPage.setTitle("LOYALTY SCHEME SYSTEM");
		
		title.setText("LOYALTY SCHEME SYSTEM");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new java.awt.Font("Dialog", 1, 20));
		title.setBounds(100,25,500,50);
		
		notice.setText("Please Select the Registration Way Or Login Directly");
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
		submit.setBounds(350,370,240,50);
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new HomePage().Home(p);		
				}
		});
		//submit.addActionListener(new submitAction());
		
		submit1.setText("LOGIN");
		submit1.setHideActionText(true);
		submit1.setFont(new java.awt.Font("Dialog", 1, 20));
		submit1.setBounds(100,370,240,50);
		submit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				new  DirectlyLogin().login(p);
			
				}
		});
		
		email.setText("Email");
		email.setHideActionText(true);
		email.setFont(new java.awt.Font("Dialog", 1, 18));
		email.setBounds(30,310,290,40);
		email.addActionListener(new emailAction());
		
		phone.setText("Mobile Phone");
		phone.setHideActionText(true);
		phone.setFont(new java.awt.Font("Dialog", 1, 18));
		phone.setBounds(360,310,290,40);
		phone.addActionListener(new phoneAction());
		
		p.add(title);
		p.add(notice);
		p.add(submit);
		p.add(submit1);
		p.add(email);
		p.add(phone);
		p.add(picture1);
		p.add(picture2);
		p.setBackground(Color.white);
		p.setBounds(0,0,700,500);
		p.setLayout(null);
		
		registerPage.add(p);
		registerPage.setVisible(true);
		registerPage.setResizable(false);
		registerPage.setBounds(400,200,700,500);
		registerPage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
	}
public void register(JPanel panel) {
		
		p = panel;
		p.removeAll();
		p.repaint();
		title.setText("LOYALTY SCHEME SYSTEM");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new java.awt.Font("Dialog", 1, 20));
		title.setBounds(100,25,500,50);
		
		notice.setText("Please Select the Registration Way Or Login Directly");
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
		submit.setBounds(100,370,240,50);
		//submit.addActionListener(new submitAction());
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new HomePage().Home(p);		
				}
		});
		
		submit1.setText("LOGIN");
		submit1.setHideActionText(true);
		submit1.setFont(new java.awt.Font("Dialog", 1, 20));
		submit1.setBounds(350,370,240,50);
		
		submit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 new DirectlyLogin().login(p);
	
				}
		});
		
		email.setText("Email");
		email.setHideActionText(true);
		email.setFont(new java.awt.Font("Dialog", 1, 18));
		email.setBounds(30,310,290,40);
		email.addActionListener(new emailAction());
		
		phone.setText("Mobile Phone");
		phone.setHideActionText(true);
		phone.setFont(new java.awt.Font("Dialog", 1, 18));
		phone.setBounds(360,310,290,40);
		phone.addActionListener(new phoneAction());
		
		p.add(title);
		p.add(notice);
		p.add(submit);
		p.add(submit1);
		p.add(email);
		p.add(phone);
		p.add(picture1);
		p.add(picture2);
		p.setBackground(Color.white);
		p.setBounds(0,0,700,500);
		p.setLayout(null);
		
	}
	private class emailAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new EmailRegister().register(p);
			
		}
		
	}
	private class phoneAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			new PhoneRegister().register(p);
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RegisterPage().register();
	}

}
