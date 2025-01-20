import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int roadLen = roads.length;
        int sourceLen = sources.length;
        
        int[] answer = new int[sourceLen];
        List<Integer>[] map = new List[n+1];
        for(int i=0;i<=n;i++) map[i] = new ArrayList<>();
        
        for(int i=0;i<roadLen;i++){
            int x = roads[i][0];
            int y = roads[i][1];
            
            map[x].add(y);
            map[y].add(x);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        
        int[] scores = new int[n+1];
        Arrays.fill(scores, -1);
        scores[destination] = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int des : map[now]){
                if(scores[des]==-1){
                    scores[des] = scores[now]+1;
                    q.add(des);
                }
            }
        }
        
        for(int i=0;i<sourceLen;i++) answer[i] = scores[sources[i]];
        
        
        return answer;
    }
}