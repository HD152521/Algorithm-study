class Solution {
    
    public int solution(int[] diffs, int[] times, long limit) {
        int l=Integer.MAX_VALUE,r=0;
        int answer = Integer.MAX_VALUE;
        int len = times.length;
        
        for(int i=0;i<diffs.length;i++){
            if(l>diffs[i]) l = diffs[i];
            if(r<diffs[i]) r = diffs[i];
        }
        r *= 2;
        
        while(l<r){
            int mid = (l+r)/2;
            long tmp=limit;
            
            
            for(int i=0;i<len;i++){
                if(diffs[i]<=mid) tmp -= times[i];
                else tmp -= (times[i]+times[i-1])*(diffs[i]-mid)+times[i];
                // System.out.println("tmp: "+tmp);
            }
        
            // System.out.println(mid+" "+tmp);
            
            if(tmp>=0){
                if(answer>mid) answer = mid;
                r = mid;
            }
            else l = mid+1;
        
        }
        answer = l;
        return answer;
    }
}