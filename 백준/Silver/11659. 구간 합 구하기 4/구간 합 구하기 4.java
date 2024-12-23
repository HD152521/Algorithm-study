import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int num[] = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) num[i] = Integer.parseInt(st.nextToken());

        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                num[i]+=num[j];
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int tmpA = (a<=0)?0:num[a-1];
            System.out.println(num[b]-tmpA);
        }
    }

}
