    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class Main {

        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            char[] arr = st.nextToken().toCharArray();
            int[] dp = new int[arr.length+1];

            dp[0] = 1;
            dp[1] = (arr[0]=='0') ? 0 : 1;

            for(int i=2;i<arr.length+1;i++){

                int pre = arr[i-2]-'0';
                int now = arr[i-1]-'0';

                if(now!=0){
                    dp[i]= dp[i-1];
                    if(pre == 0) continue;

                    if(pre*10+now<=26 && pre*10+now>0){
                        dp[i] = dp[i-1]+dp[i-2];
                        dp[i] %= 1000000;
                    }
                }else{
                    if(pre*10+now>26 || pre*10+now==0) break;
                    else dp[i]=dp[i-2];
                }

            }

            System.out.println(dp[dp.length-1]);
        }
    }
