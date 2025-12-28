import java.util.function.Function;
import java.util.*;

class Solution {
    public int solution(int n, Function<Integer, String> submit) {
        Map<Integer,Integer> nums = new HashMap<>();
        int a;
        int num = 1234;
        int numConvert = 0;
    
        List<Integer> totalNums = new ArrayList<>();
        List<Integer> compareNum = new ArrayList<>();
        compareNum.add(1234);
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                if(i==j) continue;
                for(int k=1;k<=9;k++){
                    if(k==i||k==j) continue;
                    for(int t=1;t<=9;t++){
                        if(t==i || t==j || t==k) continue;
                        totalNums.add(i*1000+j*100+k*10+t);
                    }
                }
            }
        }
        
        while(true){
            if(!compareNum.isEmpty()){
                num = compareNum.get(0);
                compareNum.remove(0);
            }else num = totalNums.get((int)(Math.random()*totalNums.size()));
            numConvert = convert(submit.apply(num));
            System.out.println(num+" "+numConvert+" "+totalNums.size());
            if(numConvert == 20) return num;
            List<Integer> delete = new ArrayList<>();
            
            for(Integer nn : totalNums){
                if(compare(nn,num)!=numConvert) delete.add(nn);
            }
            
            totalNums.removeAll(delete);
            if(totalNums.size() == 1) return totalNums.get(0);            
        }
    }
    
    public int convert(String st){
        int s=0;
        int b=0;
        
        String[] str = st.split(" ");
        s = Integer.parseInt(str[0].split("S")[0]);
        b = Integer.parseInt(str[1].split("B")[0]);
        
        return s*5+b;
    }
    
    public int compare(int a, int b){
        String sa = a+"";
        String sb = b+"";
        
        int sum = 0;
        
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(sa.charAt(i)==sb.charAt(j)){
                    if(i==j) sum+=5;
                    else sum+=1;
                }
            }
        }
        
        return sum;
        
    }
    
    
}