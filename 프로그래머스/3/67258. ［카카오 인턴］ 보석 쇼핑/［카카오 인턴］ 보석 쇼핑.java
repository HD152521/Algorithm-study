import java.util.*;

class Solution {
    int[] answer = new int[2];
    int nums = 100001;
    
    public int[] solution(String[] gems) {
        
        Set<String> str = new HashSet<>(Arrays.asList(gems));
        Map<String,Integer> map = new HashMap<>();
        

        int gemsLen = gems.length;
        int strLen = str.size();
        int[] check = new int[strLen];
        for(int i=0;i<strLen;i++) check[i]=-1;

        int tmp=0;
        
        for(String s : str){
            map.put(s,tmp++);
        }
        
        boolean status=false;
        int cnt=0;
        for(int i=0;i<gemsLen;i++){
             if(check[map.get(gems[i])]==-1) cnt++;
            check[map.get(gems[i])]=i;

            if(cnt==strLen){
                check[map.get(gems[i])]=i;
                cal(check,strLen);
            }
        }
        answer[0]++;
        answer[1]++;
        return answer;
    }
    
    public void cal(int[] check,int len){
         int mn = check[0], mx = check[0];
         for(int j=1;j<len;j++){
                    if(mx<check[j]) mx = check[j];
                    if(mn>check[j]) mn = check[j];
                }
                if(nums>mx-mn){
                    nums = mx-mn;
                    answer[0]=mn;
                    answer[1]=mx;
                }
    }
}