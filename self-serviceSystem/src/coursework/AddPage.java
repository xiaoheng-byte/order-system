package coursework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;


public class AddPage extends JPanel{
	public AddPage() {
	}
	
	private JLabel picture = new JLabel();
	private ImageIcon image = new ImageIcon ("images/Spice.jpg");
	private JLabel title = new JLabel();
	private JLabel noriPrice = new JLabel();
	private JLabel eggPrice = new JLabel();
	private JLabel BambooPrice = new JLabel();
	private JLabel chashuPrice = new JLabel();
	private JButton submit = new JButton();
	private JButton back = new JButton();
	private JPanel p;
	private JLabel noriAdd = new JLabel("EXTRA NORI:");
	private JComboBox<String> noribox = new JComboBox<>();
	private JLabel eggAdd = new JLabel("EXTRA BOILED EGG:");
	private JComboBox<String> eggbox = new JComboBox<>();
	private JLabel BambooAdd = new JLabel("BAMBOO SHOOTS:");
	private JComboBox<String> Bamboobox = new JComboBox<>();
	private JLabel chashuAdd = new JLabel("EXTRA CHASHU:");
	private JComboBox<String> chashubox = new JComboBox<>();
	private String soup;
	private String noodles;
	private String springOnion;
	private String nori;
	private String chashu;
	private String egg;
	private String spiciness;
	
	public void Add (JPanel panel) {		
		p = panel;
		p.removeAll();
		p.repaint();
		
		title.setText("Add Some Spice If You Want!");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new java.awt.Font("Dialog", 1, 20));
		title.setBounds(100,25,500,50);
		
		image.setImage(image.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT ));
		picture.setBounds(75, 120, 200, 200);
		picture.setIcon(image);
		
		noriAdd.setFont(new java.awt.Font("Dialog", 1, 17));
		noriAdd.setBounds(300,105,160,30);
		noribox.addItem("NO");
		noribox.addItem("YES");
		noribox.setBounds(480,110,70,30);
		try {
			if(ReportFuction.findInfo("ticket/price.txt", "Nori Avaliable").equals("NO")) {
				noribox.setEnabled(false);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			noriPrice.setText("£" + ReportFuction.findInfo("ticket/price.txt", "Nori Price"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		noriPrice.setFont(new java.awt.Font("Dialog", 1, 17));
		noriPrice.setBounds(570,110,50,30);
			
		
		eggAdd.setFont(new java.awt.Font("Dialog", 1, 17));
		eggAdd.setBounds(300,165,180,30);
		eggbox.addItem("NO");
		eggbox.addItem("YES");
		eggbox.setBounds(480,170,70,30);
		try {
			if(ReportFuction.findInfo("ticket/price.txt", "Egg Avaliable").equals("NO")) {
				eggbox.setEnabled(false);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			eggPrice.setText("£" + ReportFuction.findInfo("ticket/price.txt", "Egg Price"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		eggPrice.setFont(new java.awt.Font("Dialog", 1, 17));
		eggPrice.setBounds(570,170,50,30);
		
		
		BambooAdd.setFont(new java.awt.Font("Dialog", 1, 17));
		BambooAdd.setBounds(300,225,180,30);
		Bamboobox.addItem("NO");
		Bamboobox.addItem("YES");
		Bamboobox.setBounds(480,230,70,30);
		try {
			if(ReportFuction.findInfo("ticket/price.txt", "Bamboo shoots Avaliable").equals("NO")) {
				Bamboobox.setEnabled(false);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			BambooPrice.setText("£" + ReportFuction.findInfo("ticket/price.txt", "Bamboo shoots Price"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BambooPrice.setFont(new java.awt.Font("Dialog", 1, 17));
		BambooPrice.setBounds(570,230,50,30);
		
		chashuAdd.setFont(new java.awt.Font("Dialog", 1, 17));
		chashuAdd.setBounds(300,285,180,30);
		chashubox.addItem("NO");
		chashubox.addItem("YES");
		chashubox.setBounds(480,290,70,30);
		try {
			if(ReportFuction.findInfo("ticket/price.txt", "Chashu Avaliable").equals("NO")) {
				chashubox.setEnabled(false);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			chashuPrice.setText("£" + ReportFuction.findInfo("ticket/price.txt", "Chashu Price"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		chashuPrice.setFont(new java.awt.Font("Dialog", 1, 17));
		chashuPrice.setBounds(570,290,50,30);
		
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
		p.add(noriAdd);
		p.add(noriPrice);
		p.add(eggPrice);
		p.add(BambooPrice);
		p.add(chashuPrice);
		p.add(noribox);
		p.add(eggAdd);
		p.add(eggbox);
		p.add(BambooAdd);
		p.add(Bamboobox);
		p.add(chashuAdd);
		p.add(chashubox);
		p.add(title);
		p.add(back);
		p.add(submit);
		p.add(picture);
		p.revalidate();
		
		
	}
	private class backAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new OrderPage().Order(p);
			
		}
		
	}
	
	private class submitAction implements ActionListener{
		@SuppressWarnings("resource")
		@Override
		public void actionPerformed(ActionEvent e) {
			String noriAddS =  noribox.getSelectedItem().toString();
			String eggAddS =  eggbox.getSelectedItem().toString();
			String BambooAddS = Bamboobox.getSelectedItem().toString();
			String chashuAddS = chashubox.getSelectedItem().toString();
			
			Constants.setnoriAddS(noriAddS);
			Constants.seteggAddS(eggAddS);
			Constants.setBambooAddS(BambooAddS);
			Constants.setchashuAddS(chashuAddS);
			
			new ChoicePage().choice(p);
		}
		
	}
}
