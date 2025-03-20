class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int nowDe=n-1,nowPi=n-1;
        int tmpCap=cap;
        
        while(nowDe>=0){
            if(deliveries[nowDe]==0) nowDe--;
            else break;
        }
        
        while(nowPi>=0){
            if(pickups[nowPi]==0) nowPi--;
            else break;
        }
        
        while(nowDe>=0 || nowPi>=0){
            answer+=Math.max(nowDe+1,nowPi+1)*2;
            while(nowDe >= 0){
                if(deliveries[nowDe]<=tmpCap){
                    tmpCap-=deliveries[nowDe];
                    deliveries[nowDe--]=0;
                }else{
                    deliveries[nowDe]-=tmpCap;
                    break;
                }
            }
            tmpCap=0;
            while(nowPi>=0){
                if(pickups[nowPi]+tmpCap <= cap){
                    tmpCap += pickups[nowPi];
                    pickups[nowPi--]=0;
                }else{
                    pickups[nowPi]-=(cap-tmpCap);
                    break;
                }
            }
            tmpCap=cap;
            // System.out.println(answer+" "+nowDe+" "+nowPi);
        }
        
        
        return answer;
    }
}