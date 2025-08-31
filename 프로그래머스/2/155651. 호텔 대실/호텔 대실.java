import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] book_time_int = new int[book_time.length][2];
        for(int i=0;i<book_time.length;i++){
            for(int j=0;j<2;j++){
                String[] tmp = book_time[i][j].split(":");
                int h = Integer.parseInt(tmp[0]);
                int m = Integer.parseInt(tmp[1]);
                book_time_int[i][j] = h*60+m+(j*10);
            }
        }
        
        Arrays.sort(book_time_int,(a,b)->{
           return a[1]-b[1]; 
        });
        
        // for(int i=0;i<book_time_int.length;i++){
        //     System.out.println(book_time_int[i][0]+" "+book_time_int[i][1]);
        // }
        
        for(int i=0;i<book_time_int.length;i++){
            int time = book_time_int[i][1];
            int an = 0;
            for(int j=i;j<book_time_int.length;j++){
                if(book_time_int[j][0]<time && time<=book_time_int[j][1]){
                    an++;
                }
                // else if(book_time_int[j][0]>time) break;
            }
            if(answer<an) answer = an;
        }
        
        
        return answer;
    }
}