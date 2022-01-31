

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.HeadlessException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

class InfoTest {

	@Test

void testinfo() {
	Constants test = new Constants();
	
	test.Return0();		
	assertEquals(test.getsoup(),"") ;
	assertEquals(test.getnoodles(),"") ;
	assertEquals(test.getspringOnion(),"") ;
	assertEquals(test.getway(),0) ;
	assertEquals(test.getnori(), "" ) ;
	assertEquals(test.getBambooAddS(), "" ) ;
	assertEquals(test.getchashu(), "" ) ;
	assertEquals(test.getegg(), "" ) ;
	assertEquals(test.getspiciness(),"0") ;
	
}
	
	
 void testmemberno() {
	 
	 Scanner in = new Scanner(System.in);//定义scanner，等待输入
		System.out.println("Please enter memberno:");
		String value = in.nextLine();//字符类型的输入方式
		
		try {
			if(FindString.findString("ticket/pInfo.txt",value)==1) {
					String str = FindString.findStamps("ticket/pInfo.txt",value);
					Constants.settemp(str);
					System.out.println(Constants.gettemp());
					
					System.out.println("login successfully");
					
					} else {
						System.out.println("please enter again");
					}
		} catch (HeadlessException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	 
 void testphoneno() {
	 
	 inputdata data = new inputdata();
	 
	 assertTrue(data.Judge("15810850315"));
	 assertFalse(data.Judge("1501803947565"));
	 assertFalse(data.Judge("17364"));
 }
 
 void testemail() {
	 
	 inputdata email = new inputdata();
	 assertTrue(email.Judge1("anjingyi@bupt.edu.cn"));
	 assertFalse(email.Judge1("1501803947565"));
	 assertFalse(email.Judge1("anjingyi"));
 }
 }

