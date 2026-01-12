import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int len = people.length;
        boolean[] visited = new boolean[len];
        
        Arrays.sort(people);
        int start=0,end=len-1;
        while(start <= end){
            // System.out.println(start+" "+end);
            answer++;
            //하나만 되는지 확인
            if(start==end) break;
            
            if(limit-people[end]<40){
                end--;
                continue;
            }
            if(limit-(people[start]+people[end])>=0){
                start++;
                end--;
                continue;
            }else{
                end--;
                continue;
            }
            
            
            
            
        }
        
        return answer;
    }
}