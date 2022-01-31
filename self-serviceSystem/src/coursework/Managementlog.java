package coursework;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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

public class Managementlog extends JPanel{
	
	private JLabel title = new JLabel();
	private JLabel notice = new JLabel();
	
	JTextField jt1=new JTextField();
	JTextField jt2=new JTextField();
	
    private JPanel p = new JPanel();

   
    
    public void login(JPanel panel) {
		p = panel;
		p.removeAll();
		p.repaint();
		
		
		JLabel TitleLabel = new JLabel("Manager Login");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setFont(new java.awt.Font("Dialog", 1, 20));
		TitleLabel.setBounds(100,25,500,100);
		p.add(TitleLabel);
		
		
		
		JLabel Label1 = new JLabel("Manager ID:");
		Label1.setFont(new java.awt.Font("Dialog", 1, 17));
		Label1.setBounds(60,120,100,50);
		jt1.setBounds(160,130,200,30);
		p.add(Label1);
		p.add(jt1);
		
		JLabel Label2 = new JLabel("Password:");
		Label2.setHorizontalAlignment(SwingConstants.CENTER);
		Label2.setFont(new java.awt.Font("Dialog", 1, 17));
		Label2.setBounds(50,250,100,50);
		p.add(Label2);
		jt2.setBounds(160,260,200,30);
		p.add(jt2);
		
		ImageIcon image = new ImageIcon ("images/manager.jpg");
		JLabel picture1 = new JLabel();
		image.setImage(image.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT ));
		picture1.setBounds(380, 120, 250, 250);
		picture1.setIcon(image);
		p.add(picture1);
		
		
		JButton EnterButton1 = new JButton("BACK");
		EnterButton1.setFont(new java.awt.Font("Dialog", 1, 20));
		//EnterButton.setBackground(SystemColor.inactiveCaption);
		EnterButton1.setBounds(100,370,240,50);		
		p.add(EnterButton1);
		
		EnterButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new HomePage().Home(p);		
				}
		});
		
		JButton EnterButton = new JButton("SUBMIT");
		EnterButton.setFont(new java.awt.Font("Dialog", 1, 20));
		//EnterButton.setBackground(SystemColor.inactiveCaption);
		EnterButton.setBounds(350,370,240,50);		
		p.add(EnterButton);
		
		EnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jt1.getText().equals("Miyazaki")&&jt2.getText().equals("123456")) {
					new Managementlog().ManageMenu(p);
				}
				else {
					TitleLabel.setText("<html><body><p align=\"center\">Manager Login: <br>Entered the wrong information!Please try again.</p></body></html>");
				}
					
	        } 
	
		});
    }
		
    
    public void ManageMenu(JPanel panel) {
		p = panel;
		p.removeAll();
		p.repaint();
		
		JLabel TitleLabel = new JLabel("Management Function Menu");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setFont(new java.awt.Font("Dialog", 1, 20));
		TitleLabel.setBounds(100,25,500,50);
		p.add(TitleLabel);
		
		ImageIcon image2 = new ImageIcon ("images/change.png");
 		JLabel picture2 = new JLabel();
 		image2.setImage(image2.getImage().getScaledInstance(290, 200,Image.SCALE_DEFAULT ));
 		picture2.setBounds(30, 110, 400, 200);
 		picture2.setIcon(image2);
 		p.add(picture2);
 		
 		ImageIcon image3 = new ImageIcon ("images/report.jpg");
 		JLabel picture3 = new JLabel();
 		image3.setImage(image3.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT ));
 		picture3.setBounds(420, 90, 300, 250);
 		picture3.setIcon(image3);
 		p.add(picture3);
		
		JButton btn1 = new JButton("Modify Menu");
		btn1.setFont(new java.awt.Font("Dialog", 1, 20));
		btn1.setBounds(30,310,290,40);	
		p.add(btn1);
		
		
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Managementlog().optionManage(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		JButton btn2 = new JButton("View Stats");
		btn2.setFont(new java.awt.Font("Dialog", 1, 20));
		btn2.setBounds(360,310,290,40);	
		p.add(btn2);
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  try {
				new Managementlog().optionStats(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		
		JButton ReturnCSbtn = new JButton("BACK");
		ReturnCSbtn.setFont(new java.awt.Font("Dialog", 1, 20));
		ReturnCSbtn.setBounds(200,370,300,50);	
		p.add(ReturnCSbtn);
		
		ReturnCSbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  new Managementlog().login(p);
			}
		});
	
	}
  
    public void optionManage(JPanel panel) throws IOException {
 		p = panel;
 		p.removeAll();
 		p.repaint();
 		
 		JLabel TitleLabel = new JLabel("<html><body><p align=\\\"center\\\">Modify Menu: <br>Please modify the information you need to change.</p></body></html>");
 		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
 		TitleLabel.setFont(new java.awt.Font("Dialog", 1, 20));
 		TitleLabel.setBounds(100,25,500,70);
 		p.add(TitleLabel);
		
		JLabel jl21 = new JLabel("Extra Nori");
		jl21.setFont(new Font("Dialog",1,16));
		jl21.setBounds(60,120,150,50);
		JLabel jl22 = new JLabel("Prize:");
		jl22.setBounds(250,120,150,50);
		jl22.setFont(new Font("Dialog",1,14));
		JTextField jtf21 = new JTextField(5);
		jtf21.setBounds(320,120,60,40);
		jtf21.setText(ReportFuction.findInfo("ticket/price.txt", "Nori Price"));
		JLabel jl23 = new JLabel("  Availability:");
		jl23.setFont(new Font("Dialog",1,14));
		jl23.setBounds(390,120,200,50);
		
		JComboBox<String> jtf22  = new JComboBox<>();
		if(ReportFuction.findInfo("ticket/price.txt", "Nori Avaliable").equals("YES")) {
			jtf22.addItem("YES");
			jtf22.addItem("NO");
		}
		else {
			jtf22.addItem("NO");
			jtf22.addItem("YES");
		}
		jtf22.setBounds(500,120,60,40);
		p.add(jl21);
		p.add(jl22);
		p.add(jtf21);
		p.add(jl23);
		p.add(jtf22);
 		
		
		JLabel jl31 = new JLabel("Extra boiled egg");
		jl31.setFont(new Font("Dialog",1,16));
		jl31.setBounds(60,190,150,50);
		JLabel jl32 = new JLabel("Prize:");
		jl32.setBounds(250,190,150,50);
		jl32.setFont(new Font("Dialog",1,14));
		JTextField jtf31 = new JTextField(5);
		jtf31.setBounds(320,190,60,40);
		jtf31.setText(ReportFuction.findInfo("ticket/price.txt", "Egg Price"));
		JLabel jl33 = new JLabel("  Availability:");
		jl33.setBounds(390,190,200,50);
		jl33.setFont(new Font("Dialog",1,14));
		
		JComboBox<String> jtf32  = new JComboBox<>();
		if(ReportFuction.findInfo("ticket/price.txt", "Egg Avaliable").equals("YES")) {
			jtf32.addItem("YES");
			jtf32.addItem("NO");
		}else {
			jtf32.addItem("NO");
			jtf32.addItem("YES");
		}
		jtf32.setBounds(500,190,60,40);
		
		p.add(jl31);
		p.add(jl32);
		p.add(jtf31);
		p.add(jl33);
		p.add(jtf32);
		
		JLabel jl41 = new JLabel("Bamboo shoots");
		jl41.setFont(new Font("Dialog",1,16));
		jl41.setBounds(60,260,150,50);
		JLabel jl42 = new JLabel("Prize:");
		jl42.setBounds(250,260,150,50);
		jl42.setFont(new Font("Dialog",1,14));
		JTextField jtf41 = new JTextField(5);
		jtf41.setBounds(320,260,60,40);
		jtf41.setText(ReportFuction.findInfo("ticket/price.txt", "Bamboo shoots Price"));
		JLabel jl43 = new JLabel("  Availability:");
		jl43.setFont(new Font("Dialog",1,14));
		jl43.setBounds(390,260,200,50);
		
		JComboBox<String> jtf42  = new JComboBox<>();
		if(ReportFuction.findInfo("ticket/price.txt", "Bamboo shoots Avaliable").equals("YES")) {
			jtf42.addItem("YES");
			jtf42.addItem("NO");
		}else {
			jtf42.addItem("NO");
			jtf42.addItem("YES");
		}
		jtf42.setBounds(500,260,60,40);
		p.add(jl41);
		p.add(jl42);
		p.add(jtf41);
		p.add(jl43);
		p.add(jtf42);
		
		JLabel jl51 = new JLabel("Extra Chashu");
		jl51.setFont(new Font("Dialog",1,16));
		jl51.setBounds(60,320,150,50);
		JLabel jl52 = new JLabel("Prize:");
		jl52.setBounds(250,320,150,50);
		jl52.setFont(new Font("Dialog",1,14));
		JTextField jtf51 = new JTextField(5);
		jtf51.setBounds(320,320,60,40);
		jtf51.setText(ReportFuction.findInfo("ticket/price.txt", "Chashu Price"));
		JLabel jl53 = new JLabel("  Availability:");
		jl53.setFont(new Font("Dialog",1,14));
		jl53.setBounds(390,320,200,50);
		JComboBox<String> jtf52  = new JComboBox<>();
		if(ReportFuction.findInfo("ticket/price.txt", "Chashu Avaliable").equals("YES")) {
			jtf52.addItem("YES");
			jtf52.addItem("NO");
		}else {
			jtf52.addItem("NO");
			jtf52.addItem("YES");
		}
		jtf52.setBounds(500,320,60,40);
		p.add(jl51);
		p.add(jl52);
		p.add(jtf51);
		p.add(jl53);
		p.add(jtf52);
		
		JButton btn1 = new JButton("SAVE");
		btn1.setFont(new java.awt.Font("Dialog", 1, 20));
		btn1.setBounds(350,370,240,50);
		p.add(btn1);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(!ReportFuction.findInfo("ticket/price.txt", "Nori Price").contentEquals(jtf21.getText())){
						ReportFuction.changeOptions("ticket/price.txt", ReportFuction.change("ticket/price.txt","Nori Price", jtf21.getText()));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(!ReportFuction.findInfo("ticket/price.txt", "Egg Price").contentEquals(jtf31.getText())) {
						ReportFuction.changeOptions("ticket/price.txt", ReportFuction.change("ticket/price.txt","Egg Price", jtf31.getText()));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(!ReportFuction.findInfo("ticket/price.txt", "Bamboo shoots Price").contentEquals(jtf41.getText())) {
						ReportFuction.changeOptions("ticket/price.txt", ReportFuction.change("ticket/price.txt","Bamboo shoots Price", jtf41.getText()));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(!ReportFuction.findInfo("ticket/price.txt", "Chashu Price").contentEquals(jtf51.getText())) {
						ReportFuction.changeOptions("ticket/price.txt", ReportFuction.change("ticket/price.txt","Chashu Price", jtf51.getText()));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String noriAddS = jtf22.getSelectedItem().toString();
				try {
					if(!ReportFuction.findInfo("ticket/price.txt", "Nori Avaliable").contentEquals(noriAddS)) {
						ReportFuction.changeOptions("ticket/price.txt", ReportFuction.change("ticket/price.txt","Nori Avaliable", noriAddS));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String eggAddS = jtf32.getSelectedItem().toString();
				try {
					if(!ReportFuction.findInfo("ticket/price.txt", "Egg Avaliable").contentEquals(eggAddS)) {
						ReportFuction.changeOptions("ticket/price.txt", ReportFuction.change("ticket/price.txt","Egg Avaliable", eggAddS));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String BambooAddS = jtf42.getSelectedItem().toString();
				try {
					if(!ReportFuction.findInfo("ticket/price.txt", "Bamboo shoots Avaliable").contentEquals(BambooAddS)) {
						ReportFuction.changeOptions("ticket/price.txt", ReportFuction.change("ticket/price.txt","Bamboo shoots Avaliable", BambooAddS));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String chashuAddS = jtf52.getSelectedItem().toString();
				try {
					if(!ReportFuction.findInfo("ticket/price.txt", "Chashu Avaliable").contentEquals(chashuAddS)) {
						ReportFuction.changeOptions("ticket/price.txt", ReportFuction.change("ticket/price.txt","Chashu Avaliable", chashuAddS));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TitleLabel.setText("<html><body><p align=\"center\">Modify Menu: <br>Modify saved!</p></body></html>");
			}
		});
		
		
		JButton ReturnCSbtn = new JButton("BACK");
		ReturnCSbtn.setFont(new java.awt.Font("Dialog", 1, 20));
		ReturnCSbtn.setBounds(100,370,240,50);		
		p.add(ReturnCSbtn);
		
		ReturnCSbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  new Managementlog().ManageMenu(p);
			}
		});
		
 	}
    
    
    public static Date geLastWeekMonday(Date date) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTime(getThisWeekMonday(date));
		cal.add(Calendar.DATE, -7);
		return cal.getTime();
	}
	
	public static Date geLastWeekSunday(Date date) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTime(getThisWeekMonday(date));
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}
	
	public static Date getThisWeekMonday(Date date) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTime(date);
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		return cal.getTime();
	}
    
    public void optionStats(JPanel panel) throws Exception {
 		p = panel;
 		p.removeAll();
 		p.repaint();
 		JLabel TitleLabel = new JLabel("<html><body><p align=\\\"center\\\">View Status: Sales in the past week.</p></body></html>");
 		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
 		TitleLabel.setFont(new java.awt.Font("Dialog", 1, 20));
 		TitleLabel.setBounds(50,20,500,30);
 		p.add(TitleLabel);
 
		int soup1 = ReportFuction.findString("ticket/ticket.txt", "Soup:Tonkotsu");
		int soup2 = ReportFuction.findString("ticket/ticket.txt", "Soup:Shoyu");
		int soup3 = ReportFuction.findString("ticket/ticket.txt", "Soup:Shio");
		int noodles1 = ReportFuction.findString("ticket/ticket.txt", "Noodles:Soft");
		int noodles2 = ReportFuction.findString("ticket/ticket.txt", "Noodles:Medium");
		int noodles3 = ReportFuction.findString("ticket/ticket.txt", "Noodles:Firm");
		int spring1 = ReportFuction.findString("ticket/ticket.txt", "Spring onion:No Please!");
		int spring2 = ReportFuction.findString("ticket/ticket.txt", "Spring onion:Just a Little!");
		int spring3 = ReportFuction.findString("ticket/ticket.txt", "Spring onion:a Lot!");
		int nori = ReportFuction.findString("ticket/ticket.txt", "Nori:YES");
		int chashu = ReportFuction.findString("ticket/ticket.txt", "Chashu:YES");
		int egg = ReportFuction.findString("ticket/ticket.txt", "Boiled egg:YES");
		int spicness0 = ReportFuction.findString("ticket/ticket.txt", "Spiciness:0");
		int spicness1 = ReportFuction.findString("ticket/ticket.txt", "Spiciness:1");
		int spicness2 = ReportFuction.findString("ticket/ticket.txt", "Spiciness:2");
		int spicness3 = ReportFuction.findString("ticket/ticket.txt", "Spiciness:3");
		int spicness4 = ReportFuction.findString("ticket/ticket.txt", "Spiciness:4");
		int spicness5 = ReportFuction.findString("ticket/ticket.txt", "Spiciness:5");
		int enori = ReportFuction.findString("ticket/ticket.txt", "Extra Nori:YES");;
		int eegg = ReportFuction.findString("ticket/ticket.txt", "Extra boiled egg:YES");
		int bamboo = ReportFuction.findString("ticket/ticket.txt", "Bamboo shoots:YES");
		int echashu = ReportFuction.findString("ticket/ticket.txt", "Extra Chashu:YES");
		
		JLabel jl11 = new JLabel("Soup");
		jl11.setFont(new Font("Dialog",1,18));
		jl11.setBounds(70,60,150,50);
		JLabel jl12 = new JLabel("Tonkotsu: "+soup1);
		jl12.setFont(new Font("Dialog",1,14));
		jl12.setBounds(210,60,150,50);
		JLabel jl13 = new JLabel("Shoyu: "+soup2);
		jl13.setFont(new Font("Dialog",1,14));
		jl13.setBounds(330,60,150,50);
		JLabel jl14 = new JLabel("Shio: "+soup3);
		jl14.setFont(new Font("Dialog",1,14));
		jl14.setBounds(460,60,150,50);
		p.add(jl11);
		p.add(jl12);
		p.add(jl13);
		p.add(jl14);
		
		
		JLabel jl21 = new JLabel("Noodles");
		jl21.setFont(new Font("Dialog",1,18));
		jl21.setBounds(70,110,150,50);
		JLabel jl22 = new JLabel("Soft: "+noodles1);
		jl22.setFont(new Font("Dialog",1,14));
		jl22.setBounds(210,110,150,50);
		JLabel jl23 = new JLabel("Medium: "+noodles2);
		jl23.setFont(new Font("Dialog",1,14));
		jl23.setBounds(330,110,150,50);
		JLabel jl24 = new JLabel("Firm: "+noodles3);
		jl24.setFont(new Font("Dialog",1,14));
		jl24.setBounds(460,110,150,50);
		p.add(jl21);
		p.add(jl22);
		p.add(jl23);
		p.add(jl24);
	
		
		JLabel jl31 = new JLabel("Spring onion");
		jl31.setFont(new Font("Dialog",1,18));
		jl31.setBounds(70,160,150,50);
		JLabel jl32 = new JLabel("No please: "+spring1);
		jl32.setFont(new Font("Dialog",1,14));
		jl32.setBounds(210,160,150,50);
		JLabel jl33 = new JLabel("Just a little: "+spring2);
		jl33.setFont(new Font("Dialog",1,14));
		jl33.setBounds(330,160,150,50);
		JLabel jl34 = new JLabel("A lot: "+spring3);
		jl34.setFont(new Font("Dialog",1,14));
		jl34.setBounds(460,160,150,50);
		p.add(jl31);
		p.add(jl32);
		p.add(jl33);
		p.add(jl34);

		JLabel jl41 = new JLabel("Spiciness");
		jl41.setFont(new Font("Dialog",1,18));
		jl41.setBounds(70,210,150,50);
		JLabel jl42 = new JLabel("0(No): "+spicness0);
		jl42.setFont(new Font("Dialog",1,14));
		jl42.setBounds(210,210,150,50);
		JLabel jl43 = new JLabel("1: "+spicness1);
		jl43.setFont(new Font("Dialog",1,14));
		jl43.setBounds(280,210,150,50);
		JLabel jl44 = new JLabel("2: "+spicness2);
		jl44.setFont(new Font("Dialog",1,14));
		jl44.setBounds(330,210,150,50);
		JLabel jl45 = new JLabel("3: "+spicness3);
		jl45.setFont(new Font("Dialog",1,14));
		jl45.setBounds(380,210,150,50);
		JLabel jl46 = new JLabel("4: "+spicness4);
		jl46.setFont(new Font("Dialog",1,14));
		jl46.setBounds(430,210,150,50);
		JLabel jl47 = new JLabel("5(Max): "+spicness5);
		jl47.setFont(new Font("Dialog",1,14));
		jl47.setBounds(490,210,150,50);
		p.add(jl41);
		p.add(jl42);
		p.add(jl43);
		p.add(jl44);
		p.add(jl45);
		p.add(jl46);
		p.add(jl47);
		
		
		JLabel jl51 = new JLabel("Nori:");
		jl51.setFont(new Font("Dialog",1,18));
		jl51.setBounds(70,260,150,50);
		JLabel jl52 = new JLabel(""+nori);
		jl52.setFont(new Font("Dialog",1,14));
		jl52.setBounds(170,260,150,50);
		JLabel jl53 = new JLabel("Chashu:");
		jl53.setFont(new Font("Dialog",1,18));
		jl53.setBounds(270,260,150,50);
		JLabel jl54 = new JLabel(""+chashu);
		jl54.setFont(new Font("Dialog",1,14));
		jl54.setBounds(370,260,150,50);
		JLabel jl55 = new JLabel("Boiled egg:");
		jl55.setFont(new Font("Dialog",1,18));
		jl55.setBounds(470,260,150,50);
		JLabel jl56 = new JLabel(""+egg);
		jl56.setFont(new Font("Dialog",1,14));
		jl56.setBounds(570,260,150,50);
		p.add(jl51);
		p.add(jl52);
		p.add(jl53);
		p.add(jl54);
		p.add(jl55);
		p.add(jl56);
		
		
		JLabel jl61 = new JLabel("Extra Nori:");
		jl61.setFont(new Font("Dialog",1,18));
		jl61.setBounds(70,310,150,50);
		JLabel jl62 = new JLabel(""+enori);
		jl62.setFont(new Font("Dialog",1,14));
		jl62.setBounds(170,310,150,50);
		JLabel jl63 = new JLabel("Extra boiled egg:");
		jl63.setFont(new Font("Dialog",1,18));
		jl63.setBounds(310,310,150,50);
		JLabel jl64 = new JLabel(""+eegg);
		jl64.setFont(new Font("Dialog",1,14));
		jl64.setBounds(460,310,150,50);
		p.add(jl61);
		p.add(jl62);
		p.add(jl63);
		p.add(jl64);
	
		
		JLabel jl71 = new JLabel("Bamboo shoots:");
		jl71.setFont(new Font("Dialog",1,18));
		jl71.setBounds(70,360,150,50);
		JLabel jl72 = new JLabel(""+bamboo);
		jl72.setFont(new Font("Dialog",1,14));
		jl72.setBounds(220,360,50,50);
		JLabel jl73 = new JLabel("Extra Chashu:");
		jl73.setFont(new Font("Dialog",1,18));
		jl73.setBounds(310,360,150,50);
		JLabel jl74 = new JLabel(""+echashu);
		jl74.setFont(new Font("Dialog",1,14));
		jl74.setBounds(460,360,150,50);
		p.add(jl71);
		p.add(jl72);
		p.add(jl73);
		p.add(jl74);
		
		JButton ReturnCSbtn = new JButton("BACK");
		ReturnCSbtn.setFont(new java.awt.Font("Dialog", 1, 20));
		ReturnCSbtn.setBounds(240,400,250,40);	
		p.add(ReturnCSbtn);
		
		ReturnCSbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  new Managementlog().ManageMenu(p);
			}
		});
		
 		
 	}
 }
    