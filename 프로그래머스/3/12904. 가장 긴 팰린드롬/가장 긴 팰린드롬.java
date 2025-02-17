class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        String[] str = s.split("");
        int len = str.length;

        for(int i=0;i<len;i++){
            for(int j=len-1;j>i;j--){
                
                if(j-i+1<answer) break;
                
                if(str[i].equals(str[j])){
                    int st=i+1; int des=j-1;
                    boolean status=true;
                    while(st<des){
                        if(!str[st++].equals(str[des--])){
                            status=false;
                            break;
                        }
                    }
                    if(status){
                        if(answer<j-i+1) answer = j-i+1;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}