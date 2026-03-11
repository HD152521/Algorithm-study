import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try{
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           StringTokenizer st = new StringTokenizer(br.readLine());

           int n = Integer.parseInt(st.nextToken());
           int[] numList = new int[n+1];
           int[] leftCnt = new int[n+1];
           int[] rightCnt = new int[n+1];
           int[] nearNum = new int[n+1];

           st = new StringTokenizer(br.readLine());
           for(int i=0;i<n;i++){
               numList[i] = Integer.parseInt(st.nextToken());
               leftCnt[i]=0; rightCnt[i]=0;nearNum[i]=Integer.MAX_VALUE;
           }

           for(int i=0;i<n;i++){
               int now = i-1;
               while(now>=0){
                   if(numList[i]<numList[now]){
                       leftCnt[i] = leftCnt[now]+1;
                       nearNum[i] = now;
                       break;
                   }
                   now--;
               }
           }

            for(int i=n-1;i>=0;i--){
                int now = i+1;
                while(now<n){
                    if(numList[i]<numList[now]){
                        rightCnt[i] = rightCnt[now]+1;
                        if(Math.abs(nearNum[i]-i)>Math.abs(now-i)) {
                            nearNum[i] = now;
                        }
                        break;
                    }
                    now++;
                }
            }

            for(int i=0;i<n;i++){
                int hap = (leftCnt[i]+rightCnt[i]);
                System.out.print(hap);
                if(hap!=0) System.out.print(" "+(nearNum[i]+1));
                System.out.println();
            }

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