package coursework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class EndPage {
	private JButton submit = new JButton();
	private JPanel p = new JPanel();
	private Image img = new ImageIcon("images/end.jpg").getImage();  
	private JLabel title = new JLabel();
	private JLabel notice = new JLabel();
	
	public void End(JPanel panel) {
		
		p = panel;
		p.removeAll();
		p.repaint();
		
		JPanel page =  new BackgroundPanel(img);
		
		title.setText("Thanks For Your Order !");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new java.awt.Font("Dialog", 1, 22));
		title.setBounds(35,25,320,50);
		
		notice.setText("You have successfully paid the order !");
		notice.setHorizontalAlignment(SwingConstants.CENTER);
		notice.setFont(new java.awt.Font("Dialog", 1, 18));
		notice.setBounds(8,80,450,50);
		
		submit.setText("Finish");
		submit.setHideActionText(true);
		submit.setFont(new java.awt.Font("Dialog", 1, 20));
		submit.setBounds(220,380,280,50);
		submit.addActionListener(new submitAction());	
		
		page.add(title);
		page.add(notice);
		page.add(submit);
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
