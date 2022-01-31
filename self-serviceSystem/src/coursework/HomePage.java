package coursework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class HomePage extends JFrame{
	
	private JButton submit = new JButton();
	private JButton submit1 = new JButton();
	private JButton submit2 = new JButton();
	private JPanel p = new JPanel();
	private Image img = new ImageIcon("images/RamenShops.jpg").getImage();  
	
	public void Home() {
		
		JFrame homePage = new JFrame();
		JPanel page =  new BackgroundPanel(img);
		
		submit.setText("GUEST LOGIN");
		submit.setHideActionText(true);
		submit.setFont(new java.awt.Font("Dialog", 1, 20));
		submit.setBounds(30,380,200,50);
		submit.addActionListener(new submitAction1());
					
		submit1.setText("MEMBER LOGIN");
		submit1.setHideActionText(true);
		submit1.setFont(new java.awt.Font("Dialog", 1, 20));
		submit1.setBounds(240,380,200,50);
		submit1.addActionListener(new submitAction());
		
		submit2.setText("OWNER LOGIN");
		submit2.setHideActionText(true);
		submit2.setFont(new java.awt.Font("Dialog", 1, 20));
		submit2.setBounds(450,380,200,50);
		submit2.addActionListener(new submitAction2());
		
		page.add(submit);
		page.add(submit1);
		page.add(submit2);
		page.setBackground(Color.white);
		page.setBounds(0,0,700,500);
		page.setLayout(null);
		
		p.add(page);
		p.setBackground(Color.white);
		p.setBounds(0,0,700,500);
		p.setLayout(null);
		
		homePage.add(p);
		homePage.setTitle("SELF-SERVICE ORDERING SYSTEM");
		homePage.setVisible(true);
		homePage.setResizable(false);
		homePage.setBounds(400,200,700,500);
		homePage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	public void Home(JPanel panel) {
		
		p = panel;
		p.removeAll();
		p.repaint();
		
		JPanel page =  new BackgroundPanel(img);
		
		submit.setText("GUEST LOGIN");
		submit.setHideActionText(true);
		submit.setFont(new java.awt.Font("Dialog", 1, 20));
		submit.setBounds(30,380,200,50);
		submit.addActionListener(new submitAction1());
				
		
		
		submit1.setText("MEMBER LOGIN");
		submit1.setHideActionText(true);
		submit1.setFont(new java.awt.Font("Dialog", 1, 20));
		submit1.setBounds(240,380,200,50);
		submit1.addActionListener(new submitAction());
		
		
		submit2.setText("OWNER LOGIN");
		submit2.setHideActionText(true);
		submit2.setFont(new java.awt.Font("Dialog", 1, 20));
		submit2.setBounds(450,380,220,50);
		submit2.addActionListener(new submitAction2());
		
		page.add(submit);
		page.add(submit1);
		page.add(submit2);
		page.setBackground(Color.white);
		page.setBounds(0,0,700,500);
		page.setLayout(null);
		
		p.add(page);
		p.setBackground(Color.white);
		p.setBounds(0,0,700,500);
		p.setLayout(null);
		
		
		
		
	}
	
	private class BackgroundPanel extends JPanel{
		private Image image = null;  
		public BackgroundPanel(Image image) {  
		this.image = image;  
		 
		 }
		protected void paintComponent(Graphics g) {  
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);  
			     }
	}
	
	private class submitAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//new RegisterPage.register(p);
			new RegisterPage().register(p);
			
		}
		
	}

	
	private class submitAction1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//new RegisterPage.register(p);
			new OrderPage().Order(p);
			
		}
		
	}
	
	private class submitAction2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//new RegisterPage.register(p);
			new Managementlog().login(p);
			
		}
		
	}

}
