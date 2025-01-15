import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int n = routes.length;
        boolean visited[] = new boolean[n];
        int tmp =-30001;
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] route1, int[] route2) {
                return route1[1] - route2[1];
            }
        });
        
        for(int i=0;i<n;i++){
            if(tmp<routes[i][0]){
                tmp = routes[i][1];
                answer++;
            }
        }
                
        return answer;
    }
}