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
            char[] c1 = st.nextToken().toCharArray();
            int c1len = c1.length;

            st = new StringTokenizer(br.readLine());
            char[] c2 = st.nextToken().toCharArray();
            int c2len = c2.length;

            int[][] arr = new int[c1len][c2len];

            for(int i=0;i<c1len;i++){
                for(int j=0;j<c2len;j++){
                    if(c1[i]==c2[j]) arr[i][j] = (i-1<0 || j-1<0) ? 1 :arr[i-1][j-1]+1;
                    else{
                        if(i==0 && j==0) arr[i][j]=0;
                        else if(i==0) arr[i][j] = arr[i][j-1];
                        else if(j==0) arr[i][j] = arr[i-1][j];
                        else arr[i][j] = mx(arr[i-1][j],arr[i][j-1]);
                    }
                }
            }

            System.out.println(arr[c1len-1][c2len-1]);
        }

        public static int mx(int a,int b){
            if(a>b) return a;
            return  b;
        }
    }
