import java.util.*;
public class Main{

	public static void main (String[] args) {
		Scanner sc= new Scanner(System.in);		
		boolean flag = true;

		while(flag == true){
		    int in;

		    System.out.println("1. Hexadecimal Driver");
		    System.out.println("2. JobScheduler Driver");
		    System.out.println("3. Exit");
		    
		    in = sc.nextInt();
		    
		    if(in == 1){
		    	
		    	HexCalcDriver();

		    }
		    else if(in == 2){
		    	JSDriver();
		    }
		    else if(in == 3){
		        
		    	flag = false;
		    }

		    else {
		    	System.out.println("Enter valid choice");
		    }
		}
	}
	
	static int getSpaceInd(String nums){
		int ind = -1;
		for(int i=0;i<nums.length();i++){
			if(nums.charAt(i) == ' '){
				ind = i;
				break;
			}
		}
		return ind+4;
	}
	
	static void HexCalcDriver(){
		System.out.print("Commands Guide : \nADD num1 num2\nSubtract :- SUB num1 num2\nMultiply :- MUL num1 num2\nDivide :- DIV num1 num2\nConvert To Hexadecimal :- HEX num1\nConvert To Decimal :-DEC num1\nCheck isEqual :- ISE num1 num2\nCheck isGreater :- ISG num1 num2\nCheck isLess :- ISL num1 num2\nExit :- EXI \n");
		Scanner sc1= new Scanner(System.in);
		HexCalc hc = new HexCalc();
		while(true){
			String command = sc1.nextLine();
//			System.out.print(command.substring(0,3) == "ADD");
			if(command.substring(0,3).equals("ADD")){
				
				int spaceInd = getSpaceInd(command.substring(4));
//				System.out.print(spaceInd);
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				System.out.println("Result :- " + hc.add(num1, num2));
			}
			else if(command.substring(0,3).equals("SUB")){
				int spaceInd = getSpaceInd(command.substring(4));
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				System.out.println("Result :- " + hc.subtract(num1, num2));
			}
			else if(command.substring(0,3).equals("MUL")){
				int spaceInd = getSpaceInd(command.substring(4));
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				System.out.println("Result :- " + hc.multiply(num1, num2));
			}
			else if(command.substring(0,3).equals("DIV")){
				int spaceInd = getSpaceInd(command.substring(4));
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				System.out.println("Result :- " + hc.divide(num1, num2));
			}
			else if(command.substring(0,3).equals("HEX")){

				String num1 = command.substring(4);
				
				System.out.println("Result :- " + hc.toHexaDecimal(Integer.parseInt(num1)));
			}
			else if(command.substring(0,3).equals("DEC")){
				String num1 = command.substring(4);
				
				System.out.println("Result :- " + hc.toDecimal(num1));
				
			}
			else if(command.substring(0,3).equals("ISE")){
				int spaceInd = getSpaceInd(command.substring(4));
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				System.out.println("Result :- " + hc.isEqual(num1, num2));
			}
			else if(command.substring(0,3).equals("ISG")){
				int spaceInd = getSpaceInd(command.substring(4));
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				System.out.println("Result :- " + hc.isGreaterThan(num1, num2));
			}
			else if(command.substring(0,3).equals("ISL")){
				int spaceInd = getSpaceInd(command.substring(4));
				String num1 = command.substring(4, spaceInd);
				String num2 = command.substring(spaceInd+1);
				System.out.println("Result :- " + hc.isLessThan(num1, num2));
			}
			else if(command.substring(0,3).equals("EXI")){
				break;
			}
		}
	}
	
	static void printTimes(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.println("Process"+(i+1)+ " :- " + arr[i]);
		}
	}
	
	static void JSDriver(){
		System.out.println("Enter number of processes :-");
		Scanner sc = new Scanner(System.in); 
		int noOfProcess = sc.nextInt();
		int[][] process = new int[noOfProcess][2];
		
		for(int i=0;i<noOfProcess;i++){
			System.out.println("Enter Arrival Time & Burst Time of Process " + (i+1));
			int at = sc.nextInt();
			int bt = sc.nextInt();
			process[i][0] = at;
			process[i][1] = bt;
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