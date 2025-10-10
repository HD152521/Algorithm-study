import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int response = 0;
        int n = friends.length;

        Map<String,Integer> mapping = new HashMap<>();
        for(int i=0;i<n;i++) mapping.put(friends[i],i);
    
        int[][] giftMap = new int[n][n];
        for(int i=0;i<gifts.length;i++){
            String[] str = gifts[i].split(" ");
            giftMap[mapping.get(str[0])][mapping.get(str[1])]+=1;
        }
        
        int[] jisu = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                jisu[i]+=giftMap[i][j];
            }
            for(int j=0;j<n;j++){
                if(i==j) continue;
                jisu[i]-=giftMap[j][i];
            }
        }
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(giftMap[i][j]<giftMap[j][i]){
                    answer[j]++;
                }else if(giftMap[i][j]>giftMap[j][i]){
                    answer[i]++;
                }else{
                    if(jisu[i]>jisu[j]) answer[i]++;
                    else if(jisu[i]<jisu[j]) answer[j]++;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(response<answer[i]) response = answer[i];
        }
        
        return response;
    }
}