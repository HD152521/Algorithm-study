import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {Integer.MAX_VALUE,Integer.MAX_VALUE};

        int[] num = new int[n+1];
        Arrays.fill(num,-1);

        Queue<Integer> q = new LinkedList<>();

        List<int[]>[] mp = new List[n+1];
        for(int i=1;i<=n;i++) mp[i] = new ArrayList<>();

        for(int[] path : paths) {
            mp[path[0]].add(new int[]{path[1],path[2]});
            mp[path[1]].add(new int[]{path[0],path[2]});
        }

        for(int cnt : gates){
            q.add(cnt);
            num[cnt]=0;
        }
//여기서 부터 또 바꿔야함.
        while(!q.isEmpty()){

            int now = q.poll();

           for(int[] graph : mp[now]) {
                int des = graph[0];
                int vlaue = graph[1];

                if (contains(gates, graph[0])) continue;
                if (num[des] == -1) {
                    num[des] = max(vlaue, num[now]);
                    if (!contains(summits, now)) q.add(des);
                    continue;
                }

                int mx = max(num[now],vlaue);
                if (num[des] > mx) {
                    num[des] = mx;
                    if (!contains(summits, now)) q.add(des);
                }
            }
        }

        
        // for(int i=0;i<=n;i++) System.out.print(num[i] + " ");
        for(int s : summits){
            
            if(num[s] == -1) continue;
            
            if(num[s]<answer[1]){
                answer[0]=s;
                answer[1]=num[s];
            }
            else if(num[s]==answer[1] && answer[0]>s) answer[0]=s;
            
        }
        return answer;
    }
    int max(int a,int b){
        return (a>b)?a:b;
    }
    
    boolean contains(int[] arr, int num){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==num) return true;
        }
        return false;
    }
}