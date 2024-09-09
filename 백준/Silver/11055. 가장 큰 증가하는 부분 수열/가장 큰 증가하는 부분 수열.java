import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n,cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        int[] dp = new int[n];
        for(int i=0;i<n;i++) num[i] = Integer.parseInt(st.nextToken());
        dp[0] = num[0];
        for(int i=1;i<n;i++){
            dp[i]=num[i];
            for(int j=0;j<i;j++){

                if(num[j]<num[i] && dp[i]<=dp[j]+num[i]){
                    dp[i] = dp[j]+num[i];
                }
                else if(num[j]==num[i]){
                    dp[i] = dp[j];
                }

            }
        }

        int dpmx=0;
        for(int i=0;i<n;i++){
            if(dpmx<dp[i]) dpmx = dp[i];
            //System.out.print(dpmx+" ");
        }
        System.out.println(dpmx);
    }

}
