import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,m,cnt,dfsCnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            m = Integer.parseInt(br.readLine());
            cnt=m;
            boolean[] visited = new boolean[m];
            boolean[] finished   = new boolean[m];
            int[] wantList = new int[m];
            dfsCnt=0;
            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) wantList[j] = Integer.parseInt(st.nextToken());

            for(int j=0;j<m;j++){
                if(finished[j]) continue;
                dfs(wantList, visited,j+1,finished);
            }
            System.out.println(cnt-dfsCnt);
        }
    }

    public static void dfs(int[] wantList, boolean[] visited,int num,boolean[] finished){

        if(finished[num-1]) return;
        if(visited[num-1]){
            finished[num-1]=true;
            dfsCnt++;
        }

        visited[num-1]=true;
        dfs(wantList,visited,wantList[num-1],finished);
        visited[num-1]=false;
        finished[num-1]=true;

    }
}
