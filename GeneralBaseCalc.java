import java.util.HashMap;


public class GeneralBaseCalc {
	int base ;
	HashMap<Integer,String> decToHexa = new HashMap<Integer,String>();
    HashMap<Character,Integer> hexaToDec = new HashMap<Character,Integer>();
    GeneralBaseCalc(int base){
    	this.base = base;
    	
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
    
    /**
     * @param num1
     * @param num2
     * @return Addition of num1 & num2
     */
    public String add(String num1,String num2){
        int first = toDecimal(num1);
        int second = toDecimal(num2);
        
        return toOtherBase(first + second);
    }

    /**
     * @param num1
     * @param num2
     * @return Multiplication of num1 & num2
     */
    public String multiply(String num1,String num2){
        int first = toDecimal(num1);
        int second = toDecimal(num2);
        
        return toOtherBase(first * second);
    }

    /**
     * @param num1
     * @param num2
     * @return Subtraction of num1 & num2
     */
    public String subtract(String num1,String num2){
        int first = toDecimal(num1);
        int second = toDecimal(num2);
        
        return toOtherBase(first - second);
    }

    /**
     * @param num1
     * @param num2
     * @return Division of num1 & num2
     */
    public String divide(String num1,String num2){
        int first = toDecimal(num1);
        int second = toDecimal(num2);
        
        return toOtherBase(first / second);
    }
    
    /**
     * function to convert number to general Base
     * @param number
     * @return String representation of number in general Base arithmetic
     */
    public String toOtherBase(int number){
    	String ans = "";
        while(number > 0){
            int rem = number%base;
            ans += rem > 9 ? decToHexa.get(rem) : Integer.toString(rem);
            number = number / base;
        }
        
        StringBuilder sb = new StringBuilder(ans);
        sb.reverse();
        return sb.toString();
    }
    
    
    /**
     * function to convert in Decimal
     * @param number
     * @return integer representation in Decimal
     */
    public int toDecimal(String number){
        int ans = 0,numLen = number.length(),exp = 1;
        
        for(int i = numLen-1;i >= 0;i--){
            if(number.charAt(i) >= '0' && number.charAt(i) <= '9')
                ans += exp * Integer.parseInt( String.valueOf(number.charAt(i)));
            else
                ans += exp * hexaToDec.get(number.charAt(i));
            
            exp *= this.base;
        

        }
        
        return ans;
        
    }
    
    /**
     * function to check if num1 & num2 are equal values
     * @param num1
     * @param num2
     * @return true if they are equal else false
     */
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
    
    /**
     * function to check if num1 is greater than num2
     * @param num1
     * @param num2
     * @return true if num1 is greater than num2 else false
     */
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
    
    /**
     * function to check if num1 is less than num2
     * @param num1
     * @param num2
     * @return true if num1 is less than num2 else false
     */
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
