import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;
    int tmp=0;
    
    public int solution(int k, int n, int[][] reqs) {
        //0부터 다 구하고 조합으로 개수찾기 하자
        int len = reqs.length;
        n-=k;
        int[][] wait = new int[k][n+1];
        
        PriorityQueue<Integer>[] 
            minHeap = new PriorityQueue[k];;
        
        for(int i=0;i<n+1;i++){ 
            for(int j=0;j<k;j++) minHeap[j] = new PriorityQueue<>();
            int cnt = i+1;
            for(int j=0;j<len;j++){
                int s = reqs[j][0];
                int f = reqs[j][1];
                int num = reqs[j][2]-1;
                
                if(minHeap[num].isEmpty() || cnt>minHeap[num].size()) minHeap[num].add(s+f);
                else{
                    int now = minHeap[num].poll();
                    
                    if(now<=s) minHeap[num].add(s+f);
                    
                    else{
                        wait[num][i]+=now-s;
                        minHeap[num].add(now+f);
                    }
                }
        
            }
        }
           
        cal(wait,0,k,n);
        
        return answer;
    }
    
    void cal(int[][] wait,int now, int k, int m){
        if(now == k){
            if(tmp<answer) answer = tmp;
            return;
        }
        
        for(int i=0;i<=m;i++){
            tmp+=wait[now][i];
            cal(wait,now+1,k,m-i);
            tmp-=wait[now][i];
        }
    }
}