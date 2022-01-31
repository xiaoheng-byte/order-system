package coursework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class DirectlyLogin extends JPanel{
	
	private JLabel title = new JLabel();
	private JLabel notice = new JLabel();
	
    private JTextField MemNtextField;
	private static int StampsN;
    private static String Memberid;
    private JPanel p = new JPanel();
    private Image img = new ImageIcon("images/cloud1.jpg").getImage(); 
    
    
    public void login(JPanel panel) {
		p = panel;
		p.removeAll();
		p.repaint();
		JLabel TitleLabel = new JLabel("LOYALTY SCHEME SYSTEM");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setFont(new java.awt.Font("Dialog", 1, 20));
		TitleLabel.setBounds(100,25,500,50);
		p.add(TitleLabel);
		
		JLabel ChSLabel = new JLabel("Checking existing virtual stamps");
		ChSLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ChSLabel.setFont(new java.awt.Font("Dialog", 1, 14));
		ChSLabel.setBounds(100,70,500,50);
		p.add(ChSLabel);
		
		JLabel MemNLabel = new JLabel("Input your membership number :");
		MemNLabel.setFont(new java.awt.Font("Dialog", 1, 15));
		MemNLabel.setBounds(90, 140, 250, 30);
		p.add(MemNLabel);
		
		MemNtextField = new JTextField();
		MemNtextField.setBounds(350, 140, 200,30);
		p.add(MemNtextField);
		MemNtextField.setColumns(10);
		
		ImageIcon image = new ImageIcon ("images/mem.png");
		JLabel picture1 = new JLabel();
		image.setImage(image.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT ));
		picture1.setBounds(270, 200, 150, 150);
		picture1.setIcon(image);
		p.add(picture1);
		
		JButton EnterButton1 = new JButton("BACK");
		EnterButton1.setFont(new java.awt.Font("Dialog", 1, 20));
		//EnterButton.setBackground(SystemColor.inactiveCaption);
		EnterButton1.setBounds(100,370,240,50);	
		p.add(EnterButton1);
		
		EnterButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new RegisterPage().register(p);		
				}
		});
		
		JButton EnterButton = new JButton("SUBMIT");
		EnterButton.setFont(new java.awt.Font("Dialog", 1, 20));
		//EnterButton.setBackground(SystemColor.inactiveCaption);
		EnterButton.setBounds(350,370,240,50);		
		p.add(EnterButton);
		
		EnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = MemNtextField.getText();
                Constants.setmember(text);
				//Memberid = text;
				
				try {
					if(FindString.findString("ticket/pInfo.txt",text)==1) {
							String str = FindString.findStamps("ticket/pInfo.txt",text);
							Constants.settemp(str);
							new  DirectlyLogin ().ESPanel(p,str);
							
							} else {
								Object[] options ={ "OK"};
								int m = JOptionPane.showOptionDialog(null, "Please try again!", "Warning",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
								return;
							}
				} catch (HeadlessException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
			});
    }
		
    
    public void ESPanel(JPanel panel,String s) {
		p = panel;
		p.removeAll();
		p.repaint();
		
		JPanel page =  new BackgroundPanel(img);
		
		JLabel TitleLabel = new JLabel("LOYALTY SCHEME SYSTEM");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setFont(new java.awt.Font("Dialog", 1, 20));
		TitleLabel.setBounds(100,25,500,50);
		
		JLabel Welcome1Label = new JLabel("Dear member!");
		Welcome1Label.setHorizontalAlignment(SwingConstants.CENTER);
		Welcome1Label.setFont(new java.awt.Font("Dialog", 1, 22));
		Welcome1Label.setBounds(100,100,500,50);
				
		JLabel Welcome2Label = new JLabel("Welcome to check for your virtual stamps");
		Welcome2Label.setHorizontalAlignment(SwingConstants.CENTER);
		Welcome2Label.setFont(new java.awt.Font("Dialog", 1, 22));
		Welcome2Label.setBounds(100,170,500,50);
		
		JLabel CurrentSLabel = new JLabel("Your current virtual stamps : "+s);
		CurrentSLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//JLabel CurrentSLabel = new JLabel("Your current virtual stamps are:   "+CheckEnter.StampsNember(Memberid));
		CurrentSLabel.setFont(new java.awt.Font("Dialog", 1, 22));
		CurrentSLabel.setBounds(100,230,500,50);
		
		JButton Orderbtn = new JButton("CONTINUE ORDER");
		Orderbtn.setFont(new java.awt.Font("Dialog", 1, 20));
		//ReturnCSbtn.setForeground(SystemColor.desktop);
		//ReturnCSbtn.setFont(new Font("Lucida Handwriting", Font.BOLD, 15));
		Orderbtn.setBounds(350,370,240,50);
		Orderbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int num = Integer.parseInt(s);
				 if(num>=10) {
					 Constants.setflag(2);
				 }
				 else {
					 Constants.setflag(1);
				 }
				new OrderPage().Order(p);
			}
		});
		JButton ReturnCSbtn = new JButton("BACK");
		ReturnCSbtn.setFont(new java.awt.Font("Dialog", 1, 20));
		//ReturnCSbtn.setForeground(SystemColor.desktop);
		//ReturnCSbtn.setFont(new Font("Lucida Handwriting", Font.BOLD, 15));
		ReturnCSbtn.setBounds(100,370,240,50);	
		ReturnCSbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  new DirectlyLogin().login(p);
			}
		});
		page.add(TitleLabel);
		page.add(CurrentSLabel);
		page.add(Welcome1Label);
		page.add(ReturnCSbtn);
		page.add(Welcome2Label);
		page.add(Orderbtn);
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
		
	
 }
