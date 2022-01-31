
public class inputdata {
	
	public  boolean Judge(String phoneno) {
		
		
		
		if (phoneno.matches("^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$")) {
			
			return true;
		}
		else
			return false;
		
	}

public  boolean Judge1(String email) {
		
		if (email.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")) {
			
			return true;
		}
		else
			return false;
		
	}

}
