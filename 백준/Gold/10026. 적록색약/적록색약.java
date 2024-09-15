import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int case1=0,case2=0,n;
    //case1 적록o , case2 적록x
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        String[][] map = new String[n][];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = Arrays.asList(st.nextToken().split("")).toArray(String[]::new);
        }

        boolean[][]  visited1 = new boolean[n][n];
        boolean[][]  visited2 = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited1[i][j]==false){
                    case1++;
                    visited1[i][j] = true;
                    bfs(map,visited1,i,j,true);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited2[i][j]==false){
                    case2++;
                    visited2[i][j] = true;
                    bfs(map,visited2,i,j,false);
                }
            }
        }

        System.out.println(case2+" "+case1);



    }

    public static void bfs(String[][] map, boolean[][] visited, int x,int y, boolean isRedGreenBlind){
        for(int i=0;i<4;i++){
            int nowX = x+dx[i];
            int nowY = y+dy[i];

            if(nowX>=0 && nowX<n && nowY>=0 && nowY<n && !visited[nowX][nowY]){
                if(check(map[x][y],map[nowX][nowY],isRedGreenBlind)){
                    visited[nowX][nowY] = true;
                    bfs(map,visited,nowX,nowY,isRedGreenBlind);
                }
            }
        }
    }

    public static boolean check(String a, String next, boolean check){
        if(a.equals(next)) return true;
        if(check == true) {
            //적록색약일 ㅕㄱㅇ우
            if(a.equals("R") || a.equals("G")){
                if (next.equals("R") || next.equals("G")) return true;
                else return false;
            }
        }

        return false;
    }

}
