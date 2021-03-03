import java.util.*;
public class Main{

	public static void main (String[] args) {
		Scanner sc= new Scanner(System.in);		
		boolean flag = true;

		while(flag == true){
		    String input;

		    System.out.println("1. Hexadecimal Driver");
		    System.out.println("2. General Base Driver");
		    System.out.println("3. JobScheduler Driver");
		    System.out.println("4. Exit");
		    
		    input = sc.nextLine();
		    if(InputValidator.isInt(input)){
		    	int in = Integer.parseInt(input);
			    if(in == 1){
			    	HexCalcDriver();
			    }
			    
			    else if(in == 2){
			    	generalBaseDriver();
			    }
			    
			    else if(in == 3){
			    	JSDriver();
			    }
			    
			    else if(in == 4){
			    	flag = false;
			    }
	
			    else {
			    	System.out.println("Enter valid choice");
			    }
		    }
		}
	}
	
	/**
	 * utility function to find index of first space (" ")
	 * @param nums
	 * @return index 
	 */
	static int getSpaceInd(String nums){
		int ind = -1;
		for(int i=0;i<nums.length();i++){
			if(nums.charAt(i) == ' '){
				ind = i;
				break;
			}
		}
		return ind == -1 ? -1 : ind + 4;
	}
	
	//Driver code for HexCalc
	static void HexCalcDriver(){
		System.out.print("Commands Guide : \nADD num1 num2\nSubtract :- SUB num1 num2\nMultiply :- MUL num1 num2\nDivide :- DIV num1 num2\nConvert To Hexadecimal :- HEX num1\nConvert To Decimal :-DEC num1\nCheck isEqual :- ISE num1 num2\nCheck isGreater :- ISG num1 num2\nCheck isLess :- ISL num1 num2\nExit :- EXI \n");
		Scanner sc1= new Scanner(System.in);
		HexCalc hc = new HexCalc();
		while(true){
			String command = sc1.nextLine();
			
			if(command.substring(0,3).equals("ADD")){
				
				int spaceInd = getSpaceInd(command.substring(4));
				if(spaceInd == -1){
					System.out.println("Please give a valid input");
					continue;
				}
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				if(InputValidator.isNumber(num1) && InputValidator.isNumber(num2))
					System.out.println("Result :- " + hc.add(num1, num2));
				else
					System.out.println("Please give a valid input");
			}
			else if(command.substring(0,3).equals("SUB")){
				int spaceInd = getSpaceInd(command.substring(4));
				if(spaceInd == -1){
					System.out.println("Please give a valid input");
					continue;
				}
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				if(InputValidator.isNumber(num1) && InputValidator.isNumber(num2))
					System.out.println("Result :- " + hc.subtract(num1, num2));
				else
					System.out.println("Please give a valid input");
			}
			else if(command.substring(0,3).equals("MUL")){
				int spaceInd = getSpaceInd(command.substring(4));
				if(spaceInd == -1){
					System.out.println("Please give a valid input");
					continue;
				}
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				if(InputValidator.isNumber(num1) && InputValidator.isNumber(num2))
					System.out.println("Result :- " + hc.multiply(num1, num2));
				else
					System.out.println("Please give a valid input");
			}
			else if(command.substring(0,3).equals("DIV")){
				int spaceInd = getSpaceInd(command.substring(4));
				if(spaceInd == -1){
					System.out.println("Please give a valid input");
					continue;
				}
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				if(InputValidator.isNumber(num1) && InputValidator.isNumber(num2))
					System.out.println("Result :- " + hc.divide(num1, num2));
				else
					System.out.println("Please give a valid input");
			}
			else if(command.substring(0,3).equals("HEX")){

				String num1 = command.substring(4);
				if(InputValidator.isNumber(num1))
					System.out.println("Result :- " + hc.toHexaDecimal(Integer.parseInt(num1)));
				else
					System.out.println("Please give a valid input");
			}
			else if(command.substring(0,3).equals("DEC")){
				String num1 = command.substring(4);
				if(InputValidator.isNumber(num1))
					System.out.println("Result :- " + hc.toDecimal(num1));
				else
					System.out.println("Please give a valid input");
			}
			else if(command.substring(0,3).equals("ISE")){
				int spaceInd = getSpaceInd(command.substring(4));
				if(spaceInd == -1){
					System.out.println("Please give a valid input");
				}
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				if(InputValidator.isNumber(num1) && InputValidator.isNumber(num2))
					System.out.println("Result :- " + hc.isEqual(num1, num2));
				else
					System.out.println("Please give a valid input");

			}
			else if(command.substring(0,3).equals("ISG")){
				int spaceInd = getSpaceInd(command.substring(4));
				if(spaceInd == -1){
					System.out.println("Please give a valid input");
				}
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				if(InputValidator.isNumber(num1) && InputValidator.isNumber(num2))
					System.out.println("Result :- " + hc.isGreaterThan(num1, num2));
				else
					System.out.println("Please give a valid input");
			}
			else if(command.substring(0,3).equals("ISL")){
				int spaceInd = getSpaceInd(command.substring(4));
				if(spaceInd == -1){
					System.out.println("Please give a valid input");
				}
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				if(InputValidator.isNumber(num1) && InputValidator.isNumber(num2))
					System.out.println("Result :- " + hc.isLessThan(num1, num2));
				else
					System.out.println("Please give a valid input");

			}
			else if(command.substring(0,3).equals("EXI")){
				break;
			}
			else{
				System.out.println("Please enter a valid command");
			}
		}
	}
	
	//driver of general base 
	static void generalBaseDriver(){
		System.out.print("Commands Guide : \nADD num1 num2\nSubtract :- SUB num1 num2\nMultiply :- MUL num1 num2\nDivide :- DIV num1 num2\nConvert To base :- BAS num1\nConvert To Decimal :-DEC num1\nCheck isEqual :- ISE num1 num2\nCheck isGreater :- ISG num1 num2\nCheck isLess :- ISL num1 num2\nExit :- EXI \n");
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter base of your arithmetic System");
		String base = sc1.nextLine();
		String x = sc1.nextLine();
		if(!InputValidator.isInt(base)){
			System.out.println("Please Enter a valid input!");
			return;
		}
		GeneralBaseCalc gbOps = new GeneralBaseCalc(Integer.parseInt(base));
		while(true){
			String command = sc1.nextLine();
			
			if(command.substring(0,3).equals("ADD")){
				
				int spaceInd = getSpaceInd(command.substring(4));
				if(spaceInd == -1){
					System.out.println("Please give a valid input");
					continue;
				}
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				if(InputValidator.isNumber(num1) && InputValidator.isNumber(num2))
					System.out.println("Result :- " + gbOps.add(num1, num2));
				else
					System.out.println("Please give a valid input");
			}
			else if(command.substring(0,3).equals("SUB")){
				int spaceInd = getSpaceInd(command.substring(4));
				if(spaceInd == -1){
					System.out.println("Please give a valid input");
					continue;
				}
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				if(InputValidator.isNumber(num1) && InputValidator.isNumber(num2))
					System.out.println("Result :- " + gbOps.subtract(num1, num2));
				else
					System.out.println("Please give a valid input");
			}
			else if(command.substring(0,3).equals("MUL")){
				int spaceInd = getSpaceInd(command.substring(4));
				if(spaceInd == -1){
					System.out.println("Please give a valid input");
					continue;
				}
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				if(InputValidator.isNumber(num1) && InputValidator.isNumber(num2))
					System.out.println("Result :- " + gbOps.multiply(num1, num2));
				else
					System.out.println("Please give a valid input");
			}
			else if(command.substring(0,3).equals("DIV")){
				int spaceInd = getSpaceInd(command.substring(4));
				if(spaceInd == -1){
					System.out.println("Please give a valid input");
					continue;
				}
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				if(InputValidator.isNumber(num1) && InputValidator.isNumber(num2))
					System.out.println("Result :- " + gbOps.divide(num1, num2));
				else
					System.out.println("Please give a valid input");
			}
			else if(command.substring(0,3).equals("HEX")){

				String num1 = command.substring(4);
				if(InputValidator.isNumber(num1))
					System.out.println("Result :- " + gbOps.toOtherBase(Integer.parseInt(num1)));
				else
					System.out.println("Please give a valid input");
			}
			else if(command.substring(0,3).equals("DEC")){
				String num1 = command.substring(4);
				if(InputValidator.isNumber(num1))
					System.out.println("Result :- " + gbOps.toDecimal(num1));
				else
					System.out.println("Please give a valid input");
			}
			else if(command.substring(0,3).equals("ISE")){
				int spaceInd = getSpaceInd(command.substring(4));
				if(spaceInd == -1){
					System.out.println("Please give a valid input");
				}
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				if(InputValidator.isNumber(num1) && InputValidator.isNumber(num2))
					System.out.println("Result :- " + gbOps.isEqual(num1, num2));
				else
					System.out.println("Please give a valid input");

			}
			else if(command.substring(0,3).equals("ISG")){
				int spaceInd = getSpaceInd(command.substring(4));
				if(spaceInd == -1){
					System.out.println("Please give a valid input");
				}
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				if(InputValidator.isNumber(num1) && InputValidator.isNumber(num2))
					System.out.println("Result :- " + gbOps.isGreaterThan(num1, num2));
				else
					System.out.println("Please give a valid input");
			}
			else if(command.substring(0,3).equals("ISL")){
				int spaceInd = getSpaceInd(command.substring(4));
				if(spaceInd == -1){
					System.out.println("Please give a valid input");
				}
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				if(InputValidator.isNumber(num1) && InputValidator.isNumber(num2))
					System.out.println("Result :- " + gbOps.isLessThan(num1, num2));
				else
					System.out.println("Please give a valid input");

			}
			else if(command.substring(0,3).equals("EXI")){
				break;
			}
			else{
				System.out.println("Please enter a valid command");
			}
		}	
	}
	
	//utility function to print time of all process
	static void printTimes(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.println("Process"+(i+1)+ " :- " + arr[i]);
		}
	}
	
	//job scheduler driver
	static void JSDriver(){
		System.out.println("Enter number of processes :-");
		Scanner sc = new Scanner(System.in); 
		String n = sc.nextLine();
		if(!InputValidator.isInt(n)){
			System.out.println("Please Enter a valid input!");
			return;
		}
		int noOfProcess = Integer.parseInt(n);
		int[][] process = new int[noOfProcess][2];
		
		for(int i=0;i<noOfProcess;i++){
			System.out.println("Enter Arrival Time & Burst Time of Process " + (i+1));
			String at = sc.nextLine();
			String bt = sc.nextLine();
			if(InputValidator.isInt(at) && InputValidator.isInt(bt)){
				process[i][0] = Integer.parseInt(at);
				process[i][1] = Integer.parseInt(bt);
			}
			else{
				System.out.println("Please Enter a valid input!");
				i--;
			}

		}
		JobScheduler js = new JobScheduler(process,noOfProcess);
		System.out.println("Completion Time :-");
		printTimes(js.fetchCompletionTime());
		System.out.println("Waiting Time :-");
		printTimes(js.fetchWaitingTime());
		System.out.println("Turn Around Time :-");
		printTimes(js.fetchTurnAroundTime());
		System.out.println("Maximum Waiting Time :- " + js.fetchMaximumWaitingTime());
		System.out.println("Average Waiting Time :- " + js.fetchAverageWaitingTime());
		
		
	}
	
}