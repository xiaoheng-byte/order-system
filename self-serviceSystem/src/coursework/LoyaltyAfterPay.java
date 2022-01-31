package coursework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class LoyaltyAfterPay{
	
	private JButton submit1 = new JButton();
	private JPanel p = new JPanel();
	private Image img = new ImageIcon("images/cloud2.jpg").getImage(); 
	private JLabel TitleLabel = new JLabel();
	private JLabel Welcome1Label = new JLabel();
	private JLabel Welcome2Label = new JLabel();
	private JLabel CurrentSLabel = new JLabel();
	
	public void afterpay(JPanel panel) throws IOException {
		p = panel;
		p.removeAll();
		p.repaint();
		
		String str = FindString.findStamps("ticket/pInfo.txt",Constants.getmember());
		JPanel page =  new BackgroundPanel(img);
		
		TitleLabel.setText("REVIEW YOUR VIRTUAL STAMPS !");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setFont(new java.awt.Font("Dialog", 1, 20));
		TitleLabel.setBounds(100,25,500,50);
		
		Welcome1Label.setText("Dear member !");
		Welcome1Label.setHorizontalAlignment(SwingConstants.CENTER);
		Welcome1Label.setFont(new java.awt.Font("Dialog", 1, 22));
		Welcome1Label.setBounds(100,90,500,50);
				
		Welcome2Label.setText("Thank you for your order ! ");
		Welcome2Label.setHorizontalAlignment(SwingConstants.CENTER);
		Welcome2Label.setFont(new java.awt.Font("Dialog", 1, 22));
		Welcome2Label.setBounds(100,150,500,50);
		
		CurrentSLabel.setText("Your current virtual stamps change to : "+str);
		CurrentSLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//JLabel CurrentSLabel = new JLabel("Your current virtual stamps are:   "+CheckEnter.StampsNember(Memberid));
		CurrentSLabel.setFont(new java.awt.Font("Dialog", 1, 22));
		CurrentSLabel.setBounds(80,210,600,50);
		
		submit1.setText("FINISH VIEW");
		submit1.setHideActionText(true);
		submit1.setFont(new java.awt.Font("Dialog", 1, 20));
		submit1.setBounds(240,380,230,50);
		submit1.addActionListener(new submitAction());	
		
		page.add(TitleLabel);
		page.add(Welcome1Label);
		page.add(Welcome2Label);
		page.add(CurrentSLabel);
		page.add(submit1);
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
			Constants.Return0();
			new HomePage().Home(p);
		}
		
	}	
	
}