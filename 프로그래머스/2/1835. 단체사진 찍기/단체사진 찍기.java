class Solution {
    char[] tmpList = new char[8];
    char[] friends = {'A','C','F','J','M','N','R','T'};
    int answer = 0;
    String[] data;
    
    public int solution(int n, String[] data) {
        this.data = data;
        
        calCase(0, 0);
        
        return answer;
    }
    
    public void calCase(int cnt,int num){
        if(cnt == 8){
           if(checkData()){
               answer++;
               // for(int i=0;i<8;i++) System.out.print(tmpList[i]);
               // System.out.println();
           }
            return;
        }
        
        for(int i=0;i<8;i++){
            if((num &(1<<i))!=0) continue;
            tmpList[cnt]=friends[i];
            calCase(cnt+1,num|(1<<i));
        }
    }
    
    public boolean checkData(){
        for(int i=0;i<data.length;i++){
            int first=0,second=0;
            for(int j=0;j<8;j++){
                if(data[i].charAt(0)==tmpList[j]) first = j;
                if(data[i].charAt(2)==tmpList[j]) second = j;
            }
            int cha = (first>second) ? first-second:second-first;
            cha-=1;
            
            int condition = data[i].charAt(4) - '0';
            
            switch(data[i].charAt(3)){
                case '=':
                    if(cha!=condition) return false;
                    break;
                case '<':
                    if(cha>=condition) return false;
                    break;
                case '>':
                    if(cha<=condition) return false;
                    break;
            }
        }
        
        return true;
    }
    
}