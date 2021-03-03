


public class JobScheduler{
    
    int[][] processDesc ;
    int noOfProcess;
    JobScheduler(int[][] abc,int n){
    	processDesc = abc;
    	noOfProcess = n;
    }
    
    /**
     * function to fetch time for each process when it enter's in system for execution
     * @return array of integer
     */
    int[] fetchEnterTime(){
        int[] enterList;
        enterList = new int[noOfProcess];
        for(int i=0;i<noOfProcess;i++){
            if(i == 0){
                enterList[i] = processDesc[0][0];
            }
            else{
                
                int temp = enterList[i-1] + processDesc[i-1][1] ;
                if(temp < processDesc[i][0]){
                    enterList[i] = processDesc[i][0];
                }
                else{
                    enterList[i] = temp ;
                }
            }
        }
        
        return enterList;
    }
    
    /**
     * function to fetch waiting time for each process 
     * @return array of integer
     */
    int[] fetchWaitingTime(){
        int[] waitingTimeList;
        int[] enterTime;
        enterTime = fetchEnterTime();
        waitingTimeList = new int[noOfProcess];
        for(int i=0;i<noOfProcess;i++){
            waitingTimeList[i] = enterTime[i] - processDesc[i][0];
        }
        return waitingTimeList;
    }
    
    /**
     * function to fetch Completion time for each process 
     * @return array of integer
     */
    int[] fetchCompletionTime(){
        int[] completionTimeList;
        int[] enterTime;
        enterTime = fetchEnterTime();
        completionTimeList = new int[noOfProcess];
        for(int i=0;i<noOfProcess;i++){
            completionTimeList[i] = enterTime[i] + processDesc[i][1];
        }
        return completionTimeList;
    }
    
    /**
     * function to fetch Turn Around time for each process 
     * @return array of integer
     */
    int[] fetchTurnAroundTime(){
        int[] turnAroundTimeList;
        int[] completionTime;
        completionTime = fetchCompletionTime();
        turnAroundTimeList = new int[noOfProcess];
        for(int i=0;i<noOfProcess;i++){
            turnAroundTimeList[i] = completionTime[i] - processDesc[i][0];
        }
        return turnAroundTimeList;
    }
    
    /**
     * function to fetch Average waiting time  
     * @return float value 
     */
    float fetchAverageWaitingTime(){
        int[] waitingTimeList = fetchWaitingTime();
        float ans = 0;
        for(int i=0;i<noOfProcess;i++){
            ans += waitingTimeList[i];
        }
        return ans/noOfProcess;
    }
    
    /**
     * function to fetch Maximum waiting time  
     * @return int value 
     */
    int fetchMaximumWaitingTime(){
        int[] waitingTimeList = fetchWaitingTime();
        int maxWaitingTime = 0;
        for(int i=0;i<noOfProcess;i++){
            if(maxWaitingTime < waitingTimeList[i]){
                maxWaitingTime = waitingTimeList[i];
            }
        }
        return maxWaitingTime;
    }
    
    
}