import java.util.*;

class Solution {
    
    public int n=0;
    public int emoticonCnt=0;
    public int[][] users;
    public int[] emoticons;
    public int[] answer = new int[]{0,0};
    public int[] emoticonStatus;
    public int[] PERCENTS = new int[]{90,80,70,60};
    
    public int[] solution(int[][] users, int[] emoticons) {
        n = users.length;
        emoticonCnt = emoticons.length;
        this.users = users;
        this.emoticons = emoticons;
        emoticonStatus = new int[emoticonCnt]; 
    
        dfs(0);
        
        return answer;
    }
    
    public void dfs(int cnt){
        if(cnt == emoticonCnt){
            cal();
            return;
        }
        for(int i=0;i<4;i++){
            emoticonStatus[cnt] = i;
            dfs(cnt+1);
        }
    }
    
    public void cal(){
        int cnt=0;
        int price=0;
        for(int i=0;i<n;i++){
            int hap=0;
            for(int j=0;j<emoticonCnt;j++){
                if(users[i][0]> 100-PERCENTS[emoticonStatus[j]]) continue;
                hap += emoticons[j] * PERCENTS[emoticonStatus[j]] / 100;
            }
            if(hap>=users[i][1]) cnt++;
            else price += hap;
        }
        
        // System.out.println(cnt+" "+price);
        
        if(answer[0] < cnt || (answer[0]==cnt && answer[1]<price)){
            // for(int i=0;i<emoticonCnt;i++){
            //     System.out.print(emoticonStatus[i]+" ");
            // }System.out.println();
            answer[0] = cnt;
            answer[1] = price;
        }
    }
    
    public void print(int[] arr,int n){
        for(int i=0;i<n;i++) System.out.print(arr[i]+" ");
        System.out.println();
    }
}