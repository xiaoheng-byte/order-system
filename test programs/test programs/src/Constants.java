
	
	public class Constants {
		private static int flag = 0;
		private static double money = 0;
		private static String temp = "0";//stamps
		private static String member;
		//ticket part
		private static String soup;
		private static String noodles;
		private static String springOnion;
		private static String nori;
		private static String chashu;
		private static String egg;
		private static String spiciness;
		private static String noriAddS;
		private static String eggAddS;
		private static String BambooAddS;
		private static String chashuAddS;
		private static String DiningOptions;
		private static int way;
		
		public static void setflag(int num) {
			flag = num;
		}
		public static int getflag() {
			return flag;
		}
		public static void setmoney(double outcome) {
			money = outcome;
		}
		public static double getmoney() {
			return money;
		}
		public static void settemp(String s) {
			temp = s;
		}
		public static String gettemp() {
			return temp;
		}
		public static void setmember(String s) {
			member = s;
		}
		public static String getmember() {
			return member;
		}
		
		public static void setsoup(String s) {
			soup = s;
		}
		public static String getsoup() {
			return soup;
		}
		public static void setnoodles(String s) {
			noodles = s;
		}
		public static String getnoodles() {
			return noodles;
		}
		public static void setspringOnion(String s) {
			springOnion = s;
		}
		public static String getspringOnion() {
			return springOnion;
		}
		public static void setnori(String s) {
			nori = s;
		}
		public static String getnori() {
			return nori;
		}
		public static void setchashu(String s) {
			chashu = s;
		}
		public static String getchashu() {
			return chashu;
		}
		public static void setegg(String s) {
			egg = s;
		}
		public static String getegg() {
			return egg;
		}
		public static void setspiciness(String s) {
			spiciness = s;
		}
		public static String getspiciness() {
			return spiciness;
		}
		public static void setnoriAddS(String s) {
			noriAddS = s;
		}
		public static String getnoriAddS() {
			return noriAddS;
		}
		public static void seteggAddS(String s) {
			eggAddS = s;
		}
		public static String geteggAddS() {
			return eggAddS;
		}
		public static void setBambooAddS(String s) {
			BambooAddS = s;
		}
		public static String getBambooAddS() {
			return BambooAddS;
		}
		public static void setchashuAddS(String s) {
			chashuAddS = s;
		}
		public static String getchashuAddS() {
			return chashuAddS;
		}
		public static void setway(int num) {
			way = num;
			if(num == 1) {
				setDiningOptions("Eat in");
			}
			else if(num == 2) {
				setDiningOptions("Take away");
			}
			
		}
		public static int getway() {
			return way;
		}
		public static void setDiningOptions(String s) {
			DiningOptions = s;
		}
		public static String getDiningOptions() {
			return DiningOptions;
		}
		
		public static void Return0() {
			setflag(0);
			setmoney(0);
			settemp("0");
			setmember("");
			setsoup("");
			setnoodles("");
			setspringOnion("");
			setnori("");
			setchashu("");
			setegg("");
			setspiciness("0");
			setnoriAddS("");
			seteggAddS("");
			setBambooAddS("");
			setchashuAddS("");
			setway(0);
			setDiningOptions("");	
			
		}
	}

