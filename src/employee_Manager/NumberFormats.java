package employee_Manager;

public class NumberFormats {
	
	public boolean isInt(String str) {
		try {
			int test = Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e) {
			System.out.println(str + " is not an int.");
			return false;
		}
	}
	
	public boolean isLength(String str, int num) {
		if(str.length() < num) {
			return true;
		}else { 
			return false;
		}
	}

}
