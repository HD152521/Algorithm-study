import java.util.*;

class Solution {
    
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    String[] maps;
    int lenX;
    int lenY;
    
    class Lo{
        int x;
        int y;
        
        public Lo(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        int answer = -1;
        boolean flag = false;
        this.maps = maps;
        Lo f=null,s=null,d=null;
        lenX = maps.length;
        lenY = maps[0].length();
        
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                if(maps[i].charAt(j)=='S') f = new Lo(i,j);
                else if(maps[i].charAt(j)=='L') s = new Lo(i,j);
                else if(maps[i].charAt(j)=='E') d = new Lo(i,j);
            }
        }
        // System.out.println(s.x+" "+s.y);
        // System.out.println(bfs(f,s));
        // System.out.println(bfs(s,d));
        
        int an1 = bfs(f,s);
        int an2 = bfs(s,d);
        if(an1 == -1 || an2 == -1) answer = -1;
        else answer = an1+an2;
        
        return answer;
    }
    
    public int bfs(Lo start, Lo finish){
        int answer=0;
        Queue<Lo> location = new LinkedList<>();
        location.add(start);
        Integer[][] visited = new Integer[lenX+1][lenY+1];
        visited[start.x][start.y]=0;
        while(!location.isEmpty()){
            Lo now = location.poll();
            for(int i=0;i<4;i++){
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];
                
                if(nextX<0 || nextX>=lenX || nextY<0 || nextY>=lenY) continue;
                if(maps[nextX].charAt(nextY)=='X') continue;
                if(visited[nextX][nextY] == null || visited[nextX][nextY]>visited[now.x][now.y]+1){
                    visited[nextX][nextY] = visited[now.x][now.y]+1;
                    
                    if(nextX==finish.x && nextY == finish.y){
                        return visited[nextX][nextY];
                    }
                    
                    location.add(new Lo(nextX,nextY));
                }
            }
        }
        return (visited[finish.x][finish.y]==null) ? -1 : visited[finish.x][finish.y];
    }
}