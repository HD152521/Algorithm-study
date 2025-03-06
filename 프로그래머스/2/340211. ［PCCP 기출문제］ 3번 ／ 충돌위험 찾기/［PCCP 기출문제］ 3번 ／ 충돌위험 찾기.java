import java.util.*;

class Solution {
    
    Map<Integer, Location> pointList = new HashMap<>();
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        pointInit(points);
        int len = routes.length;
        List<Location>[] routeList = new List[len];
        
        for(int i=0;i<len;i++){
            routeList[i] = new LinkedList<>();
            for(int j=0;j<routes[i].length;j++){
                int num = routes[i][j];
                routeList[i].add(new Location(pointList.get(num).x,pointList.get(num).y));
            }
        }
        
        Location[] nowLo = new Location[len];
        for(int i=0;i<len;i++) nowLo[i] = routeList[i].get(0);
        int cnt = 0;
        
            Set<Location> dupli = new HashSet<>();
            //겹치는거 몇개인지 확인
            for(int i=0;i<len;i++){
                for(int j=i+1;j<len;j++){
                    if(nowLo[i].equals(nowLo[j])) dupli.add(nowLo[i]);
                }
            }
            answer+=dupli.size();
        
        while(cnt<len){        
            //현재 정해진 목적지에 도착했는지 & 이게 끝이 맞는지 확인
            for(int i=0;i<len;i++){
                if(routeList[i].isEmpty()) continue;
                
                if(nowLo[i].x==routeList[i].get(0).x && nowLo[i].y==routeList[i].get(0).y){
                    //지금 위치가 다음 목적지랑 같을 경우
                    if(routeList[i].size() == 1){
                        //목적지까지 도착한경우 해결할 것
                        routeList[i].remove(0);
                        cnt++;
                    }else{
                        nowLo[i] = routeList[i].get(0);
                        routeList[i].remove(0);   
                    }
                }
            }
            
            //한칸씩 이동하기
            for(int i=0;i<len;i++){
                if(routeList[i].isEmpty()) continue;
                
                int desX = routeList[i].get(0).x;
                if(nowLo[i].x!=desX){
                    nowLo[i].x += desX>nowLo[i].x ? 1 : -1;
                    continue;
                }
                
                int desY = routeList[i].get(0).y;
                if(nowLo[i].y!=desY){
                    nowLo[i].y += desY>nowLo[i].y ? 1 : -1;
                }
                
            }
            
            dupli = new HashSet<>();
            //겹치는거 몇개인지 확인
            for(int i=0;i<len;i++){
                if(routeList[i].isEmpty()) continue;
                for(int j=i+1;j<len;j++){
                    if(routeList[j].isEmpty()) continue;
                    if(nowLo[i].equals(nowLo[j])) dupli.add(nowLo[i]);
                }
            }
            // System.out.println("===========");
            // for(Location l : dupli){
            //     System.out.println(l.x+" "+l.y);
            // }
            answer+=dupli.size();
        }

        return answer;
    }
    
    public void pointInit(int[][] points){
        for(int i=0;i<points.length;i++){
            pointList.put(i+1, new Location(points[i][0],points[i][1]));
        }
    }
    
    class Location{
        int x;
        int y;
        
        Location(int x,int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Location location = (Location) obj;
            return x == location.x && y == location.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}