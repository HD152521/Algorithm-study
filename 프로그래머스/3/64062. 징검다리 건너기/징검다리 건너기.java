class Solution {
    
    public static int len;
    
    public int solution(int[] stones, int k) {
        int answer = 0;
        len = stones.length;
        int mx=0;
        for(int i=0;i<len;i++){
            if(mx<stones[i]) mx = stones[i];
        }
        int l=0,r=mx;
        
        while(l<=r){
            int mid = (l+r)/2;
            int tmp = 0;
            boolean flag = true;
            for(int i=0;i<len;i++){
                if(stones[i]-mid>0) tmp=0;
                else tmp++;
                if(tmp>=k){
                    flag = false;
                    break;
                }
            }
            
            if(flag) l = mid+1;
            else r = mid-1;
        }
        
        return l;
    }
}