import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{1,-1,0,0};
        int answer = 0;
        Set<Integer> size;
        
        int leny = land.length;
        int lenx = land[0].length;
        
        boolean[][] visited = new boolean[leny][lenx];
        int[] weight = new int[lenx];
            
        Queue<int[]> q = new LinkedList<>();
        int cnt=0;
        for(int i=0;i<leny;i++){
            for(int j=0;j<lenx;j++){
                if(!visited[i][j] && land[i][j]==1){
                    size = new HashSet<>();
                    q.add(new int[]{i,j});
                    size.add(j);
                    visited[i][j]=true;
                    cnt=1;
                    while(!q.isEmpty()){
                        int[] tmp = q.poll();
                        int x = tmp[0],y=tmp[1];
                        for(int k=0;k<4;k++){
                            int nowX = dx[k]+x;
                            int nowY = dy[k]+y;
                            if(check(nowX,nowY,leny,lenx)){
                                if(!visited[nowX][nowY] && land[nowX][nowY]==1){
                                    q.add(new int[]{nowX,nowY});
                                    size.add(nowY);
                                    visited[nowX][nowY]=true;
                                    cnt++;
                                }
                            }
                        }
                    }
                    for(int si : size) weight[si] += cnt;
                }
            }
        }
        for(int i=0;i<lenx;i++){
            // System.out.print(weight[i]+" ");
            if(weight[i]>answer) answer = weight[i];
        }   
        return answer;
    }
    
    public boolean check(int x,int y,int n,int m){
         if(x>=0 && x<n && y>=0 && y<m) return true;
        return false;
    }
}