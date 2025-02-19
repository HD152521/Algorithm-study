class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        
        for(int i=0;i<n;i++){
            int len = timelogs[i].length;
            int myH = schedules[i]/100;
            int myM = schedules[i]%100;
            
            if(myM+10>=60){
                myH+=1;
                myM=(myM+10)%60;
            }else myM+=10;
        
            System.out.println(myH+":"+myM);
            
            int tmp=0;
            for(int j=0;j<len;j++){
                int day = j+startday;
                if(day%7==6 || day%7==0) continue;
                int h = timelogs[i][j]/100;
                int m = timelogs[i][j]%100;
                
                if(h<myH) tmp++;
                else if(h==myH){
                    if(m<=myM) tmp++;
                }
                
            }
            if(tmp>=5) answer++;
        }
        
        return answer;
    }
}