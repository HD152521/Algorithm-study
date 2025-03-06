import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        List<Integer> apple = new ArrayList<>();
        for(int i=0;i<t;i++) apple.add(Integer.parseInt(br.readLine()));

        int[][][] dp = new int[t][w+1][3];
        if(apple.get(0)==2) dp[0][1][2]=1;
        else dp[0][0][1] = 1;

        for(int i=1;i<t;i++){
            dp[i][0][1] = dp[i-1][0][1]+((apple.get(i)==1)?1:0);
            dp[i][0][2] = dp[i-1][0][2]+((apple.get(i)==2)?1:0);
        }

        for(int i=1;i<t;i++){
            for(int j=1;j<=w;j++){

                if(j>i) continue;

                int tmp;
                tmp = (apple.get(i)==1) ? 1:0;
                dp[i][j][1] = Math.max(dp[i-1][j][1]+tmp,dp[i-1][j-1][2]+tmp);
                tmp = (apple.get(i)==2) ? 1:0;
                dp[i][j][2] = Math.max(dp[i-1][j][2]+tmp,dp[i-1][j-1][1]+tmp);
            }
        }

//        for(int i=0;i<t;i++){
//            for(int j=0;j<=w;j++){
//                System.out.print(dp[i][j][1]+" ");
//            }
//            System.out.print("=======");
//            for(int j=0;j<=w;j++){
//                System.out.print(dp[i][j][2]+" ");
//            }
//            System.out.println();
//        }
        int answer = 0;
        for(int i=0;i<=w;i++) {
            answer = Math.max(answer,dp[t-1][i][1]);
            answer = Math.max(answer,dp[t-1][i][2]);
        }
        System.out.println(answer);
    }
}

