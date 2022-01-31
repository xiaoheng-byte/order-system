package coursework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateTicket {
	public static void printTicket() throws IOException {	
		BufferedWriter wt = null;
		try {
			wt = new BufferedWriter(new FileWriter("ticket/ticket.txt",true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date dt=new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String formatdate=df.format(dt);
		wt.write(formatdate+"\n");
		wt.write("Soup:"+Constants.getsoup()+"\n");
		wt.write("Noodles:"+Constants.getnoodles()+"\n");
		wt.write("Spring onion:"+Constants.getspringOnion()+"\n");
		wt.write("Nori:"+Constants.getnori()+"\n");
		wt.write("Chashu:"+Constants.getchashu()+"\n");
		wt.write("Boiled egg:"+Constants.getegg()+"\n");
		wt.write("Spiciness:"+Constants.getspiciness()+"\n");
		wt.write("Extra Nori:"+Constants.getnoriAddS()+"\n");
		wt.write("Extra boiled egg:"+Constants.geteggAddS()+"\n");
		wt.write("Bamboo shoots:"+Constants.getBambooAddS()+"\n");
		wt.write("Extra Chashu:"+Constants.getchashuAddS()+"\n");
		wt.write("Dining Options:"+Constants.getDiningOptions()+"\n");
		wt.write("\n");	
		wt.close();
	}
	public static void calcu() throws NumberFormatException, IOException{
		double m = 9.99;
		int nori = Integer.parseInt(ReportFuction.findInfo("ticket/price.txt", "Nori Price"));
		int egg = Integer.parseInt(ReportFuction.findInfo("ticket/price.txt", "Egg Price"));
		int bamboo = Integer.parseInt(ReportFuction.findInfo("ticket/price.txt", "Bamboo shoots Price"));
		int chashu = Integer.parseInt(ReportFuction.findInfo("ticket/price.txt", "Chashu Price"));
		if(Constants.getnoriAddS().contentEquals("YES")) {
			m += nori;
		}
		if(Constants.geteggAddS().contentEquals("YES")) {
			m += egg;
		}
		if(Constants.getBambooAddS().contentEquals("YES")) {
			m += bamboo;
		}
		if(Constants.getchashuAddS().contentEquals("YES"))	{
			m += chashu;
		}
		Constants.setmoney(m);
	}
}
