package coursework;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

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



public class EmailRegister extends JPanel{
	private JLabel title = new JLabel();
	private JLabel notice = new JLabel();
	private JLabel inputNo1 = new JLabel();
	private JLabel inputNo2 = new JLabel();
	private JLabel inputNo3 = new JLabel();
	private JLabel ps = new JLabel();
	private ImageIcon image = new ImageIcon ("images/welcome.png");
	private JLabel picture = new JLabel();
	JTextField jt1=new JTextField();
	JTextField jt2=new JTextField();
	JTextField jt3=new JTextField();
	private JButton submit = new JButton();
	private JButton back = new JButton();
	private JPanel p = new JPanel();

	public void register(JPanel panel) {
		p = panel;
		p.removeAll();
		p.repaint();
		
		title.setText("Welcome to Loyalty scheme!");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new java.awt.Font("Dialog", 1, 20));
		title.setBounds(100,25,500,50);
		
		notice.setText("Please Input ALL the Following Information:");
		notice.setHorizontalAlignment(SwingConstants.CENTER);
		notice.setFont(new java.awt.Font("Dialog", 1, 14));
		notice.setBounds(100,70,500,50);
		
		image.setImage(image.getImage().getScaledInstance(290, 200,Image.SCALE_DEFAULT ));
		picture.setBounds(380, 120, 300, 200);
		picture.setIcon(image);
		
		inputNo1.setText("First Name:");
		inputNo1.setFont(new java.awt.Font("Dialog", 1, 14));
		inputNo1.setBounds(60,120,100,50);
		jt1.setBounds(160,130,200,30);
		
		inputNo2.setText("Last Name:");
		inputNo2.setFont(new java.awt.Font("Dialog", 1, 14));
		inputNo2.setBounds(60,190,100,50);
		jt2.setBounds(160,200,200,30);
		
		inputNo3.setText("Email:");
		inputNo3.setFont(new java.awt.Font("Dialog", 1, 14));
		inputNo3.setBounds(60,260,100,50);
		jt3.setBounds(160,270,200,30);
		
		ps.setText("*Notification: You will receive an email  with a membership number Once the registration is successful");
		ps.setFont(new java.awt.Font("Dialog", 1, 12));
		ps.setBounds(50,340,900,50);
		
		back.setText("BACK");
		back.setHideActionText(false);
		back.setFont(new java.awt.Font("Dialog", 1, 20));
		back.setBounds(75,400,250,50);
		back.addActionListener(new backAction());
		
		submit.setText("SUBMIT");
		submit.setHideActionText(false);
		submit.setFont(new java.awt.Font("Dialog", 1, 20));
		submit.setBounds(375,400,250,50);	
		submit.addActionListener(new submitAction());
		
		p.add(title);
		p.add(notice);
		p.add(inputNo1);
		p.add(jt1);
		p.add(jt2);
		p.add(jt3);
		p.add(inputNo2);
		p.add(inputNo3);
		p.add(picture);
		p.add(ps);
		p.add(back);
		p.add(submit);
		p.setLayout(null);
		p.revalidate();

	}
	private class backAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new RegisterPage().register(p);
		}
		
	}
	private class submitAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String text1 = jt1.getText();
			String text2 = jt2.getText();
			String text3 = jt3.getText();
			String text4 = "0";
			if(text1.length()==0||text2.length()==0||text3.length()==0) {
				Object[] options ={ "OK"};
				int m = JOptionPane.showOptionDialog(null, "Please enter all information !", "Warning",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
   	 			return;
	 		}
			else {
				if (text1.matches("^[A-Za-z]+$")&&text2.matches("^[A-Za-z]+$")) {
					if(text3.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")) {
						try {
							if(FindString.findString("ticket/pInfo.txt",text3)==1) {
								Object[] options ={ "OK"};
								int m = JOptionPane.showOptionDialog(null, "This E-mail has been registered, please do not register again !", "Warning",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
								return;
							}
							else {
								StringBuilder str=new StringBuilder();//定义变长字符回串
								Random random=new Random();
								//随机生成数字，并添加到字符串
								for(int i=0;i<8;i++){
								    str.append(random.nextInt(10));
								}
								String text = str.toString();
								BufferedWriter wt = null;
								try {
									wt = new BufferedWriter(new FileWriter("ticket/pInfo.txt",true));
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								try {
									wt.write("Membership Number:"+text+"\n");
									wt.write("First Name:"+text1+"\n");
									wt.write("Last Name:"+text2+"\n");
								wt.write("E-mail:"+text3+"\n");
								wt.write("Virtual Stamps:"+text4+"\n");
								wt.write("\n");	
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								try {
									wt.close();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
   
								new RegisterInfo().info(p,text,text1,text2,text3,text4);
}
						} catch (HeadlessException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}	
					else {
						Object[] options ={ "OK"};
						int m = JOptionPane.showOptionDialog(null, "The E-mail entered does not conform to the format !", "Warning",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		   	 			return;
					}
				}
				else {
					Object[] options ={ "OK"};
					int m = JOptionPane.showOptionDialog(null, "The name entered does not conform to the format !", "Warning",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		   	 		return;
				}
			}	
			
		}
	}
}