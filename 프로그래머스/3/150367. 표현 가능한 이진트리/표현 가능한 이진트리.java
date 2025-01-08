import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
       class Test{
            int num;
            int level;

            public Test(int num, int level){
                this.num = num;
                this.level = level;
            }
        }

        int size = numbers.length;

        int[] answer = new int[size];

        for(int i=0;i<size;i++){
            boolean flag = true;
            long num = numbers[i];
            List<String> binary = new ArrayList<>();
            while(true){
                if(num<1) break;
                binary.add(String.valueOf(num%2));
                num/=2;
            }

            int len = binary.size();
            int tmp=1,depth=1;

            while(true){
                if(tmp<=len && len<tmp*2) break;
                tmp*=2;
                depth++;
            }

            for(int j=len;j<Math.pow(2,depth)-1;j++)  binary.add("0");
            len = binary.size();

            int[] tree = new int[len+1];

            Queue<Test> queue = new LinkedList<>();
            queue.add(new Test(len/2,depth-2));

            int qCnt=1;
            while(!queue.isEmpty()){
                Test test = queue.poll();                
                tree[qCnt++] = Integer.parseInt(binary.get(test.num));
                
                if(test.level==-1) continue;

                int cha = (int) Math.pow(2, test.level);

                if(test.num+test.level<=len) queue.add(new Test(test.num+cha,test.level-1));
                if(test.num-test.level>=0) queue.add(new Test(test.num-cha,test.level-1));
            }

            if(tree[1]==0){
                answer[i]=0;
                continue;
            }
            
            for(int j=2;j<=len;j++){
                if(tree[j]==1 && tree[j/2]==0){
                    flag=false;
                    break;
                }
            }
            answer[i] = (flag)? 1:0;
        }
        return answer;
    }
}