package coursework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class OrderPage extends JPanel{
	
	private JLabel title = new JLabel();
	private JLabel picture = new JLabel();
	private ImageIcon image = new ImageIcon ("images/ramen.jpg");
	private JButton submit = new JButton();
	private JButton back = new JButton();
	private JPanel p;
	private JLabel soup = new JLabel("SOUP:");
	private JComboBox<String> soupbox = new JComboBox<>();
	private JLabel noodle = new JLabel("NOODLES:");
	private JComboBox<String> noodlebox = new JComboBox<>();
	private JLabel springOnion = new JLabel("SPRING ONION:");
	private JComboBox<String> springOnionbox = new JComboBox<>();
	private JLabel nori = new JLabel("NORI:");
	private JComboBox<String> noribox = new JComboBox<>();
	private JLabel chashu = new JLabel("CHASHU:");
	private JComboBox<String> chashubox = new JComboBox<>();
	private JLabel egg = new JLabel("BOILED EGG:");
	private JComboBox<String> eggbox = new JComboBox<>();
	private JLabel spiciness = new JLabel("SPICINESS:");
	private JComboBox<String> spicibox = new JComboBox<>();
	
	public void Order(JPanel panel) {
		
		p = panel;
		p.removeAll();
		p.repaint();
		
		title.setText("Please Customize Your Ramen!");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new java.awt.Font("Dialog", 1, 20));
		title.setBounds(100,25,500,50);
		
		
		image.setImage(image.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT ));
		picture.setBounds(75, 120, 200, 200);
		picture.setIcon(image);
		
		soup.setFont(new java.awt.Font("Dialog", 1, 17));
		soup.setBounds(320,105,140,30);
		soupbox.addItem("Tonkotsu");
		soupbox.addItem("Shoyu");
		soupbox.addItem("Shio");
		soupbox.setBounds(480,110,150,30);
		
		noodle.setFont(new java.awt.Font("Dialog", 1, 17));
		noodle.setBounds(320,145,140,30);
		noodlebox.addItem("Soft");
		noodlebox.addItem("Medium");
		noodlebox.addItem("Firm");
		noodlebox.setBounds(480,150,150,30);
		
		springOnion.setFont(new java.awt.Font("Dialog", 1, 17));
		springOnion.setBounds(320,185,140,30);
		springOnionbox.addItem("No Please!");
		springOnionbox.addItem("Just a Little!");
		springOnionbox.addItem("a Lot!");
		springOnionbox.setBounds(480,190,150,30);
		
		nori.setFont(new java.awt.Font("Dialog", 1, 17));
		nori.setBounds(320,225,140,30);
		noribox.addItem("YES");
		noribox.addItem("NO");
		noribox.setBounds(480,230,150,30);
		
		chashu.setFont(new java.awt.Font("Dialog", 1, 17));
		chashu.setBounds(320,265,140,30);
		chashubox.addItem("YES");
		chashubox.addItem("NO");
		chashubox.setBounds(480,270,150,30);
		
		egg.setFont(new java.awt.Font("Dialog", 1, 17));
		egg.setBounds(320,305,140,30);
		eggbox.addItem("YES");
		eggbox.addItem("NO");
		eggbox.setBounds(480,310,150,30);
		
		spiciness.setFont(new java.awt.Font("Dialog", 1, 17));
		spiciness.setBounds(320,345,140,30);
		spicibox.addItem("0");
		spicibox.addItem("1");
		spicibox.addItem("2");
		spicibox.addItem("3");
		spicibox.addItem("4");
		spicibox.addItem("5");
		spicibox.setBounds(480,350,150,30);
		
		
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
	
		
		p.setLayout(null);
		p.add(soupbox);
		p.add(soup);
		p.add(noodlebox);
		p.add(noodle);
		p.add(springOnionbox);
		p.add(springOnion);
		p.add(nori);
		p.add(noribox);
		p.add(chashu);
		p.add(chashubox);
		p.add(egg);
		p.add(eggbox);
		p.add(spiciness);
		p.add(spicibox);
		p.add(picture);
		p.add(title);
		p.add(back);
		p.add(submit);
		
		p.revalidate();
		
	}
	
	private class backAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(Constants.getflag()==1 ||Constants.getflag()==2) {
				new  DirectlyLogin ().ESPanel(p,Constants.gettemp());
			}
			else {
				new HomePage().Home(p);
			}
			
			
		}
		
	}
	
	private class submitAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String soupS = new String();
			soupS = soupbox.getSelectedItem().toString();
			String noodlesS = new String();
			noodlesS = noodlebox.getSelectedItem().toString();
			String springOnionS = new String();
			springOnionS = springOnionbox.getSelectedItem().toString();
			String noriS = new String();
			noriS = noribox.getSelectedItem().toString();
			String chashuS = new String();
			chashuS = chashubox.getSelectedItem().toString();
			String eggS = new String();
			eggS = eggbox.getSelectedItem().toString();
			String spiciS = new String();
			spiciS = spicibox.getSelectedItem().toString();
			
			Constants.setsoup(soupS);
			Constants.setnoodles(noodlesS);
			Constants.setspringOnion(springOnionS);
			Constants.setnori(noriS);
			Constants.setchashu(chashuS);
			Constants.setegg(eggS);
			Constants.setspiciness(spiciS);
			
			new AddPage().Add( p );
			
		}
		
	}
	
	
	
	

}