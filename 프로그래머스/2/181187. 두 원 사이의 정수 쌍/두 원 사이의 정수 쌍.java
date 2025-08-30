class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long newR1 =0;
        long R1 = r1,R2 = r2;
        for(int i=1;i<=r2;i++){
            // long inside1 = R1*R1-i*i;
            // long inside2 = R2*R2-i*i;
            if(i<r1) newR1 = (long)Math.ceil(Math.sqrt(Math.pow(R1,2)-Math.pow(i,2)));
            else newR1=0;
            long newR2 = (long)Math.floor(Math.sqrt(Math.pow(R2,2)-Math.pow(i,2)));
            answer += newR2-newR1+1;
        }
        answer*=4;
        
        return answer;
    }
}