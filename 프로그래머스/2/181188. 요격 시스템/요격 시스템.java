import java.util.*;

class Solution {
    boolean[] visited;
    int len;
    public int solution(int[][] targets) {
        int answer = 0;
        len = targets.length;
        visited = new boolean[len];
        Arrays.sort(targets,(a,b)->{
           return a[1]-b[1]; 
        });
        
        for(int i=0;i<len;i++){
            if(visited[i]) continue;
            calVisited(targets,targets[i][1]);
            answer++;
        }

        return answer;
    }

    public void calVisited(int[][] targets, int n){
        for(int i=0;i<len;i++){
            if(visited[i]) continue;
            if(targets[i][0]<n&&n<=targets[i][1]) visited[i]=true;
            else if(n>targets[i][1]) return;
        }
    }
    
    public void print(int[][] targets){
        for(int i=0;i<targets.length;i++){
            for(int j=0;j<2;j++){
                System.out.print(targets[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public void printVisited(){
        for(int i=0;i<len;i++) System.out.print(visited[i]+" ");
        System.out.println();
    }
}