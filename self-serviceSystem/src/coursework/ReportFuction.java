package coursework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReportFuction {
	//Before
	public static String beforeDayByNowDay(String pattern,int n){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -n); 
		Date date = calendar.getTime();
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
		
	}
	//After
	public static String afterDayByNowDay(String pattern,int n){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, +n); 
		Date date = calendar.getTime();
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}
	//week?
	public static int dayForWeek(String pTime)throws Exception{
		Date dt=new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(pTime));
        int dfw = 0;
        if(c.get(Calendar.DAY_OF_WEEK)==1) {
        	dfw=7;
        }else {
        	dfw=c.get(Calendar.DAY_OF_WEEK)-1;
        }
        return dfw;     
	}
	//Judge date range
	public static boolean DateJudge(String d) throws Exception{
		Date dt=new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String formatdate=df.format(dt);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(dayForWeek(formatdate)==1) {
        	Date date1=simpleDateFormat.parse(formatdate);
        	Date date2=simpleDateFormat.parse(afterDayByNowDay("yyyy-MM-dd",6));
            Date date3=simpleDateFormat.parse(d);
            if(date1.getTime()<=date3.getTime() && date2.getTime()>=date3.getTime()){
                return true;
            }
            else
            	return false;
        }
        else if(dayForWeek(formatdate)==2) {
        	Date date1=simpleDateFormat.parse(beforeDayByNowDay("yyyy-MM-dd",1));
        	Date date2=simpleDateFormat.parse(afterDayByNowDay("yyyy-MM-dd",5));
            Date date3=simpleDateFormat.parse(d);
            if(date1.getTime()<=date3.getTime() && date2.getTime()>=date3.getTime()){
                return true;
            }
            else
            	return false;
        }
        else if(dayForWeek(formatdate)==3) {
        	Date date1=simpleDateFormat.parse(beforeDayByNowDay("yyyy-MM-dd",2));
        	Date date2=simpleDateFormat.parse(afterDayByNowDay("yyyy-MM-dd",4));
            Date date3=simpleDateFormat.parse(d);
            if(date1.getTime()<=date3.getTime() && date2.getTime()>=date3.getTime()){
                return true;
            }
            else
            	return false;
        }
        else if(dayForWeek(formatdate)==4) {
        	Date date1=simpleDateFormat.parse(beforeDayByNowDay("yyyy-MM-dd",3));
        	Date date2=simpleDateFormat.parse(afterDayByNowDay("yyyy-MM-dd",3));
            Date date3=simpleDateFormat.parse(d);
            if(date1.getTime()<=date3.getTime() && date2.getTime()>=date3.getTime()){
                return true;
            }
            else
            	return false;
        }
        else if(dayForWeek(formatdate)==5) {
        	Date date1=simpleDateFormat.parse(beforeDayByNowDay("yyyy-MM-dd",4));
        	Date date2=simpleDateFormat.parse(afterDayByNowDay("yyyy-MM-dd",2));
            Date date3=simpleDateFormat.parse(d);
            if(date1.getTime()<=date3.getTime() && date2.getTime()>=date3.getTime()){
                return true;
            }
            else
            	return false;
        }
        else if(dayForWeek(formatdate)==6) {
        	Date date1=simpleDateFormat.parse(beforeDayByNowDay("yyyy-MM-dd",5));
        	Date date2=simpleDateFormat.parse(afterDayByNowDay("yyyy-MM-dd",1));
            Date date3=simpleDateFormat.parse(d);
            if(date1.getTime()<=date3.getTime() && date2.getTime()>=date3.getTime()){
                return true;
            }
            else
            	return false;
        }
        else {
        	Date date1=simpleDateFormat.parse(beforeDayByNowDay("yyyy-MM-dd",6));
        	Date date2=simpleDateFormat.parse(formatdate);
            Date date3=simpleDateFormat.parse(d);
            if(date1.getTime()<=date3.getTime() && date2.getTime()>=date3.getTime()){
                return true;
            }
            else
            	return false;
        }  
	}
	public static int findString(String fileName,String str) throws Exception{
		int count = 0;
		int flag = 0;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String tmp = br.readLine();
		// String regex = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		while(tmp!=null){
			if(tmp.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")&& DateJudge(tmp)) {
				flag = 1;
			}
				
			if(flag == 1) {
				if(tmp.equals(str)) {
					count+=1;
				}	
			}
			tmp = br.readLine();
		}
		br.close();
		return count;
	}
	
	public static String findInfo(String fileName,String str) throws IOException {
		String str2 = null;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String tmp = br.readLine();
		while(tmp!=null){
			int index = tmp.indexOf(str, 0);
			if(index>=0) {
				String str1=tmp.substring(0, tmp.indexOf(":"));
			    str2=tmp.substring(str1.length()+1, tmp.length());
			}
			tmp = br.readLine();
		}
		br.close();
		return str2;	
	}
	public static String change(String fileName,String str1,String str2) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName)); 
		StringBuffer buf = new StringBuffer();
		try {
			String tmp = br.readLine();
	    	while (tmp!=null){	
	    		int index = tmp.indexOf(str1, 0);
				if(index>=0) {
					String n = str1+":"+str2;
				    buf.append(n);
				  } 
				else {
					buf.append(tmp);
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
	public static void changeOptions(String filePath, String content) throws IOException {
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
