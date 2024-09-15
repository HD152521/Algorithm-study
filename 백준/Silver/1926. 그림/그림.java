import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int cnt=0,area=0,maxArea=0,n,m;
    //case1 적록o , case2 적록x
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false && map[i][j]==1){
                    visited[i][j]=true;
                    area++; cnt++;
                    dfs1(map, visited, i,j);
                    if(maxArea < area){
                        maxArea = area;
                    }
                    area=0;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(maxArea);

    }

    public static void dfs1(int[][] map,boolean[][] visited, int x,int y){
        for(int i=0;i<4;i++){
            int nowX = x+dx[i];
            int nowY = y+dy[i];
            if(nowX>=0 && nowX<n && nowY>=0 && nowY<m && !visited[nowX][nowY]){
                if(map[nowX][nowY] == 1){
                    visited[nowX][nowY]=true;
                    area++;
                    dfs1(map,visited,nowX,nowY);
                }
            }
        }

    }
}
