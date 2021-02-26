import java.util.HashMap;


public class HexCalc {
    HashMap<Integer,String> decToHexa = new HashMap<Integer,String>();
    HashMap<Character,Integer> hexaToDec = new HashMap<Character,Integer>();
    HexCalc(){
        decToHexa.put(10,"A");
        decToHexa.put(11,"B");
        decToHexa.put(12,"C");    
        decToHexa.put(13,"D");
        decToHexa.put(14,"E");
        decToHexa.put(15,"F");    
        
        hexaToDec.put('A',10);
        hexaToDec.put('B',11);
        hexaToDec.put('C',12);
        hexaToDec.put('D',13);
        hexaToDec.put('E',14);
        hexaToDec.put('F',15);
    }
    
    public String add(String num1,String num2){
        int first = toDecimal(num1);
        int second = toDecimal(num2);
        
        return toHexaDecimal(first + second);
    }

    public String multiply(String num1,String num2){
        int first = toDecimal(num1);
        int second = toDecimal(num2);
        
        return toHexaDecimal(first * second);
    }

    public String subtract(String num1,String num2){
        int first = toDecimal(num1);
        int second = toDecimal(num2);
        
        return toHexaDecimal(first - second);
    }

    public String divide(String num1,String num2){
        int first = toDecimal(num1);
        int second = toDecimal(num2);
        
        return toHexaDecimal(first / second);
    }
    
    public String toHexaDecimal(int number){
        String ans = "";
        while(number > 0){
            int rem = number%16;
            ans += rem > 9 ? decToHexa.get(rem) : Integer.toString(rem);
            number = number / 16;
        }
        
        StringBuilder sb = new StringBuilder(ans);
        sb.reverse();
        return sb.toString();
    }
    
    public int toDecimal(String number){
        int ans = 0,numLen = number.length(),exp = 1;
        
        for(int i = numLen-1;i >= 0;i--){
            if(number.charAt(i) >= '0' && number.charAt(i) <= '9')
                ans += exp * Integer.parseInt( String.valueOf(number.charAt(i)));
            else
                ans += exp * hexaToDec.get(number.charAt(i));
            
            exp *= 16;
        

        }
        
        return ans;
        
    }
    
    public boolean isEqual(String num1,String num2){
    	if(num1.length() != num2.length())
    		return false;
    	boolean ans = true;
    	for(int i=0;i<num1.length();i++){
    		if(num1.charAt(i) != num2.charAt(i)){
    			ans = false;
    			break;
    		}
    	}
    	return ans;
    }
    
    public boolean isGreaterThan(String num1,String num2){
    	if(num1.length() != num2.length()){
    		if(num1.length() > num2.length())
    			return true;
    		else
    			return false;
    	}
    	for(int i=0;i < num1.length();i++){
    		if(num1.charAt(i) < num2.charAt(i)){
    			return false;
    		}
    		else if(num1.charAt(i) > num2.charAt(i)){
    			return true;
    		}
    	}
    	return true;
    }
    
    public boolean isLessThan(String num1,String num2){
    	if(num1.length() != num2.length()){
    		if(num1.length() < num2.length())
    			return true;
    		else
    			return false;
    	}
    	for(int i=0;i < num1.length();i++){
    		if(num1.charAt(i) > num2.charAt(i)){
    			return false;
    		}
    		else if(num1.charAt(i) < num2.charAt(i)){
    			return true;
    		}
    	}
    	return true;
    }
}
