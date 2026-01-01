class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        //2중 배열 하나 정해서 0은 첫번째꺼 안한거 1은 첫번째 꺼
        int[][] map = new int[2][len];
        
        for(int i=0;i<len;i++){
            if(i<2) map[0][i] = money[i];
            else if(i==2) map[0][i] = map[0][0]+money[i];
            else if(i== len-1) map[0][i] = map[0][i-1];
            else{
                int a=0;
                if(map[0][i-2]<map[0][i-3]) a=money[i]+map[0][i-3];
                else a=money[i]+map[0][i-2];
            
                map[0][i] = a>map[0][i-1]?a:map[0][i-1];
            }
            
        }
        
        for(int i=1;i<len;i++){
            if(i<3) map[1][i] = money[i];
            else{
                int b=0;
                if(map[1][i-2]<map[1][i-3]) b=money[i]+map[1][i-3];
                else b=money[i]+map[1][i-2];
            
                map[1][i] = b>map[1][i-1]?b:map[1][i-1];
            }
            
        }
        
        
        // for(int i=0;i<len;i++){
        //     System.out.print(map[0][i]+" ");
        // }System.out.println();
        // for(int i=0;i<len;i++){
        //     System.out.print(map[1][i]+" ");
        // }System.out.println();
        
        answer = map[0][len-1]>map[1][len-1]?map[0][len-1]:map[1][len-1];
        return answer;
    }
    
    
}