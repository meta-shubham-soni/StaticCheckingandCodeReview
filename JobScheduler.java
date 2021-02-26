


public class JobScheduler{
    
    int[][] processDesc ;
    int noOfProcess;
    JobScheduler(int[][] abc,int n){
    	processDesc = abc;
    	noOfProcess = n;
    }
    
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
    
    float fetchAverageWaitingTime(){
        int[] waitingTimeList = fetchWaitingTime();
        float ans = 0;
        for(int i=0;i<noOfProcess;i++){
            ans += waitingTimeList[i];
        }
        return ans/noOfProcess;
    }
    
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