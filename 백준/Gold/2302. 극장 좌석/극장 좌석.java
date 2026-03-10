import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            if(n==1){
                System.out.println(1);
                return;
            }

            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1]=1;
            dp[2]=2;
            if(n>=3){
                for(int i=3;i<=n;i++) dp[i] = dp[i-1]+dp[i-2];
            }

            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                list.add(Integer.parseInt(st.nextToken()));
            }

            int answer = 1;
            int tmp =0;
            for(int i=1;i<=n;i++){
                if(list.contains(i)){
                    answer *= dp[tmp];
                    tmp=0;
                    continue;
                }
                tmp++;
            }
            if(tmp!=0){
                answer *= dp[tmp];
            }

            System.out.println(answer);

        }catch(Exception e){
            System.out.println("error");
        }
    }

//    public static int n,m;
//    public static int[][] map;
//    public static boolean[][] visited;
//    public static List<int[]> virus;
//    public static int emptyCnt = 0;
//    public static int[] dx = new int[]{0,0,1,-1};
//    public static int[] dy = new int[]{1,-1,0,0};
//
//    public static void main(String[] args) {
//
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            n = Integer.parseInt(st.nextToken());
//            m = Integer.parseInt(st.nextToken());
//
//            map = new int[n][n];
//            visited = new boolean[n][n];
//
//            for(int i=0;i<n;i++){
//                st = new StringTokenizer(br.readLine());
//                for(int j=0;j<n;j++){
//                    map[i][j] = Integer.parseInt(st.nextToken());
//                    if(map[i][j] == 2){
//                        virus.add(new int[]{i,j});
//                        visited[i][j] = true;
//                    }else if(map[i][j] == 1) emptyCnt++;
//                }
//            }
//
//        }catch (Exception e){
//            return;
//        }
//    }
//
//    public static void turn(){
//        int[][] newMap = new int[n][n];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                newMap[i][j] = map[i][j];
//            }
//        }
//
//    }
//
//    public static void bfs(){
//        for(int[] lo : virus){
//            for(int i=0;i<4;i++){
//                int nx = lo[0]+dx[i];
//                int ny = lo[1]+dy[i];
//
//                if(isMap(nx,ny)){
//
//                }
//            }
//        }
//
//    }
//
//    public static boolean isMap(int x,int y){
//        return (x>=0&&x<n&&y>=0&&y<n);
//    }

}