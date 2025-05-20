import java.util.*;

class Solution {
    
    // boolean[] check;
    List<Integer>[] list;
    Set<Set<Integer>> setLists = new HashSet<>();
    List<Integer> tmp = new ArrayList<>();
    int answer;
    
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        list = new List[banned_id.length];
        for(int i=0;i<banned_id.length;i++) list[i] = new ArrayList<>();
        
        for(int i=0;i<user_id.length;i++){
            for(int j=0;j<banned_id.length;j++){
                if(user_id[i].length()!=banned_id[j].length()) continue;
                int cnt=0;
                for(int k=0;k<banned_id[j].length();k++){
                    if(banned_id[j].charAt(k)=='*' || banned_id[j].charAt(k)==user_id[i].charAt(k)) cnt++;
                    else break;
                }
                if(cnt==banned_id[j].length()){
                    list[j].add(i);
                }
            }
        }
        
        //경우의 수 구해야함.
        // check = new boolean[user_id.length];
        
        bfs(0);
        
        // for(int i=0;i<banned_id.length;i++){
        //     for(int num : list[i]){
        //         System.out.print(num+" ");
        //     }
        //     System.out.println("ect");
        // }
        
        return setLists.size();
    }
    
    public void bfs(int n){
        
        if(n==list.length){
            Set<Integer> sets = new HashSet<>(tmp);
            if(sets.size()==list.length) setLists.add(sets);
            return;
        }
        for(int num : list[n]){
            if(!tmp.contains(num)){
                tmp.add(num);
                bfs(n+1);
                tmp.remove(n);
            }
        }
        
    }
}