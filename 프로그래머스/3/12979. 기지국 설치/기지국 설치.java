import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int answer=0;
        List<Integer> interval = new ArrayList<>(); 
        
        int beforeF=1;
        for(int station : stations){
            int s = (station-w<1) ? 1 : station-w;
            int f = (station+w>n) ? n : station+w;
            if(beforeF<s) interval.add(s-beforeF);
            beforeF = f+1;
        }
        if(beforeF<=n) interval.add(n-beforeF);
        
        for(int num : interval){
            int width = w*2+1;
             
            if(num%width==0 && num!=0) answer+= num/width;
            else answer += (num/width)+1;
        }
        
        return answer;
    }
}