class Solution {
    
    public static int[][] rectangle;
    public static int[][] map = new int[101][101];
    public static boolean[][] visited = new boolean[101][101];
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int itemX,itemY;
    public static int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        this.rectangle = rectangle;
        this.itemX = itemX*2;
        this.itemY = itemY*2;
        init();
        
        // for(int i=0;i<=100;i++){
        //     for(int j=0;j<=100;j++){
        //         if(map[i][j]==2) System.out.print("#");
        //         else if(map[i][j]==1) System.out.print("*");
        //         else System.out.print(".");
        //     }
        //     System.out.println();
        // }
        
        dfs(characterX*2,characterY*2,0);
        return answer/2;
    }
    
    public void dfs(int x,int y,int cnt){
        // System.out.println(x+" "+y);
        
        if(x == itemX && y == itemY){
            if(cnt<answer) answer = cnt;
            return;
        }
        visited[x][y] = true;
        
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(!isRange(nx,ny) || visited[nx][ny] || !isSide(nx,ny)) continue;
            dfs(nx,ny,cnt+1);
        }
    }
    
    public boolean isRange(int x,int y){
        return (x>=0 && x<=100 && y>=0 && y<=100);
    }
    
    public boolean isSide(int x,int y){
        return map[x][y]==2;
    }
    
    public void init(){
        int len = rectangle.length;
        for(int k=0;k<len;k++){
            int[] rec = rectangle[k];
            for(int i = rec[0]*2;i<=rec[2]*2;i++){
                for(int j=rec[1]*2;j<=rec[3]*2;j++){
                    
                    if(i==rec[0]*2 || i==rec[2]*2 || j==rec[1]*2 || j==rec[3]*2){
                        if(map[i][j]==1) continue;
                        map[i][j] = 2;
                    }
                    else map[i][j] = 1;
                    
                }
            }
        }
    }

}