import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,m,cnt=0,dfsCnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String[] arr = st.nextToken().split("");
            if(check(arr)) cnt++;
        }
        System.out.println(cnt*(cnt-1));
    }

    public static boolean check(String[] arr){
        int len = arr.length;
        for(int i=0;i<len/2;i++){
            if(!arr[i].equals(arr[len-1-i])) return false;
        }
        return true;
    }

    public static int cal(int n){
        int num=0;
        for(int i=1;i<=n;i++) num += i;
        return num*2;
    }
}
