
public class InputValidator {
	
	//to check if val is Integer value
	public static boolean isInt(String val){
	    try
	    {
	        Integer.parseInt(val);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	    	System.out.println("Please enter integer");
	        return false;
	    }
	    
	}
	
	//to check if val is Number(Decimal , Octal , HexaDecimal , Binary)
	public static boolean isNumber(String val){
		
		for(int i=0;i<val.length();i++){
			if((val.charAt(i) >= '0' && val.charAt(i) <= '9') || (val.charAt(i) >= 'A' && val.charAt(i) <= 'F') || (val.charAt(i) >= 97 && val.charAt(i) <= 102)){
				continue;
			}
			else
				return false;
		}
		return true;
	}
}
