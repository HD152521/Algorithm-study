class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int[][] convertTime = new int[4][2];
        slice(convertTime,0,video_len);
        slice(convertTime,1,pos);
        slice(convertTime,2,op_start);
        slice(convertTime,3,op_end);
        
        for(String command : commands){
            if(betweenOp(convertTime)){
                convertTime[1][0] = convertTime[3][0];
                convertTime[1][1] = convertTime[3][1];
            }
            
            if(command.equals("next")) cal(convertTime,1,10);
            else if(command.equals("prev")) cal(convertTime,1,-10);
            
        }
        
        if(betweenOp(convertTime)){
                convertTime[1][0] = convertTime[3][0];
                convertTime[1][1] = convertTime[3][1];
        }
        
        answer = (convertTime[1][0]<10) ? "0"+convertTime[1][0]+":" : convertTime[1][0]+":";
        answer += (convertTime[1][1]<10) ? "0"+convertTime[1][1]: convertTime[1][1];
        return answer;
    }
    
    public void slice(int[][] time, int i, String str){
        time[i][0] = Integer.parseInt(str.split(":")[0]);
        time[i][1] = Integer.parseInt(str.split(":")[1]);
    }
    
    public boolean betweenOp(int[][] time){
        int nowM = time[1][0];
        int nowS = time[1][1];
        if(time[2][0]>nowM) return false;
        else if(time[2][0] == nowM){
            if(time[2][1]>nowS) return false;
        }
        
        if(time[3][0]<nowM) return false;
        else if(time[3][0] == nowM){
            if(time[3][1]<nowS) return false;
        }
        return true;
    }
    
    public void cal(int[][] time, int i, int num){
        time[i][1]=time[i][1]+num;
        //음수인데 0보다 작을경우
        if(time[i][1]<0){
            if(time[i][0]==0){
                time[i][0] = 0; time[i][1]=0;
                return;
            }else{
                time[i][0] -= 1;
                time[i][1] = 60+time[i][1];
            }
            return;
        }
        else if(time[i][1]>60){
            time[i][0]++;
            time[i][1] %= 60;
        }
        int vm = time[0][0];
        int vs = time[0][1];
        if(time[i][0]>=vm){
                if(time[i][1]>=vs){
                    time[i][0]=vm;
                    time[i][1]=vs;
                }
            }
    }
}

    