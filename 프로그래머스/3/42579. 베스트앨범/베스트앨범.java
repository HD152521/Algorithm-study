import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        
        Map<String,Integer> h = new HashMap<>();
        
        for(int i=0;i<len;i++){
            if(!h.containsKey(genres[i])){
                h.put(genres[i],plays[i]);
            }else{
                int tmp = h.get(genres[i]);
                h.put(genres[i],plays[i]+tmp);
            }
        }
        
        //장르별로 2개씩 출력
        List<String> genre = new ArrayList<>(h.keySet());
        Collections.sort(genre, (String a,String b)->{
           return h.get(b)-h.get(a); 
        });
        
        // for(String g : genre){
        //     System.out.println(g+" "+h.get(g));
        // } 
        List<Integer> an = new ArrayList<>();
        
        for(int i=0;i<genre.size()*2;i++){
            String k = genre.get(i/2);
            int mx = -1;
            int mxI=-1;
            for(int j=0;j<len;j++){
                if(genres[j].equals(k)){
                    if(mx<plays[j]){
                        // System.out.println(k+" "+j+" "+plays[j]);
                        mx = plays[j];
                        mxI=j;
                    }
                }
            }
            if(plays[mxI]!=0) an.add(mxI);
            plays[mxI]=0;
        }
        int[] answer = new int[an.size()];
        for(int i=0;i<an.size();i++) answer[i]=an.get(i);
        return answer;
    }
}