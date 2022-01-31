

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FindString {
	public static int findString(String fileName,String str) throws IOException{
		int flag = 0;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String tmp = br.readLine();
		while(tmp!=null){
			int index = tmp.indexOf(str, 0);
			if(index>=0) {
				flag = 1;
			}
			tmp = br.readLine();
		}
		br.close();
		return flag;
	}
	public static String findStamps(String fileName,String str) throws IOException{
		String str2 = null;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String tmp = br.readLine();
		while(tmp!=null){
			int index = tmp.indexOf(str, 0);
			if(index>=0) {
				//flag = 1;
				tmp = br.readLine();
				tmp = br.readLine();
				tmp = br.readLine();
				tmp = br.readLine();
				String str1=tmp.substring(0, tmp.indexOf(":"));
			    str2=tmp.substring(str1.length()+1, tmp.length());
			}
			tmp = br.readLine();
		}
		br.close();
		return str2;
	}
	//str is loyalty number, num is stamps number
	public static String change(String fileName,String str,String num,int f) throws IOException {
		int a = Integer.parseInt(num);
		if(f==1) 
			a-=10;
		if(f==2)
			a+=1;
		String tickets = Integer.toString(a); //stamps number
		BufferedReader br = new BufferedReader(new FileReader(fileName)); 
		StringBuffer buf = new StringBuffer();
		try {
			String tmp = br.readLine();
	    	while (tmp!=null){	
	    		buf.append(tmp);
	    		int index = tmp.indexOf(str, 0);
				if(index>=0) {
					buf.append("\n");
					tmp = br.readLine();
					buf.append(tmp);
					buf.append("\n");
					tmp = br.readLine();
					buf.append(tmp);
					buf.append("\n");
					tmp = br.readLine();
					buf.append(tmp);
					buf.append("\n");
					tmp = br.readLine();
					String n = "Virtual Stamps:"+tickets;
				    buf.append(n);
				  } 
				buf.append("\n");
				tmp = br.readLine();
			}
		}catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(br!=null) {
					try {
						br.close();
					}catch(IOException e) {
						br=null;
					}
			}	
		}
    	return buf.toString();
    }
	public static void changeStamps(String filePath, String content) throws IOException {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(filePath));
			bw.write(content); 
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(bw!=null) {
				try {
					bw.close();
				}catch(IOException e) {
					bw=null;
				}
			}
		}
	}

} 

