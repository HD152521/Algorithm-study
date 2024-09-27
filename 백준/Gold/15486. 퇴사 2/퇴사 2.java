    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class Main {

        static int n;
        static int[] arr;
        static int[] t;
        static int[] p;

        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            n = Integer.parseInt(br.readLine());

            t = new int[n];
            p = new int[n];
            arr = new int[n];

            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                t[i] = Integer.parseInt(st.nextToken());
                p[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=t[0]-1;i<n;i++) arr[i] = p[0];

            for(int i=1;i<n;i++){
                cal(i);
            }
            System.out.println(arr[n-1]);
        }

        public static void cal(int num){
            int lo = num + t[num]-1;
            int sum = arr[num-1]+p[num];

            if(arr[num]<arr[num-1]) arr[num] = arr[num-1];
            if(lo>n-1) return;

            if(sum>arr[lo]) arr[lo] = sum;
        }

    }
