import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int n,m,k;
    public static int[][] a;
    public static int[][] a_copy;
//    public static List<Tree> trees;
//    public static List<Tree> deletedList = new ArrayList<>();

//    public static List<Integer>[][] trees;
    public static PriorityQueue<Integer>[][] qTrees;

    public static int[] dx = new int[]{0,1,1,1,0,-1,-1,-1};
    public static int[] dy = new int[]{-1,-1,0,1,1,1,0,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int answer=0;

//        trees = new List[n][n];
        qTrees = new PriorityQueue[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                qTrees[i][j] = new PriorityQueue<>();
//                trees[i][j] = new ArrayList<>();
            }
        }
        a = new int[n][n];
        a_copy = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                a[i][j] = 5;
                a_copy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int treeX = Integer.parseInt(st.nextToken())-1;
            int treeY = Integer.parseInt(st.nextToken())-1;
            int treeAge = Integer.parseInt(st.nextToken());
            qTrees[treeX][treeY].add(treeAge);
        }

        for(int i=0;i<k;i++){
            springAndSummer();
            fall();
            winter();
//            printTree();
//            printA();
        }

        printAnswer();

    }

    public static void printAnswer(){
        int answer =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                answer += qTrees[i][j].size();
            }
        }
        System.out.println(answer);
    }

    public static void printA(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }System.out.println();
        }
    }

    public static void printTree(){
        System.out.println("=====나무 출력===== ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int q: qTrees[i][j]){
                    System.out.println(i+" "+j+" "+q);
                }
            }
        }
    }

    public static void winter(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j] += a_copy[i][j];
            }
        }
    }

    public static boolean checkBox(int x,int y){
        return x>=0&&y>=0&&x<n&&y<n;
    }

    public static void fall(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int tree : qTrees[i][j]){
                    if(tree%5==0){
                        for(int k=0;k<8;k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];
                            if(checkBox(nx,ny)) qTrees[nx][ny].add(1);
                        }
                    }
                }
            }
        }
    }

    public static void springAndSummer(){
        Queue<Integer> tmp = new LinkedList<>();
        Queue<Integer> deleted = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                while(!qTrees[i][j].isEmpty()){
                    int t = qTrees[i][j].poll();
                    if(a[i][j]>=t){
                        a[i][j] -= t;
                        tmp.add(t+1);
                    }else deleted.add(t/2);
                }
                while(!tmp.isEmpty()){
                    int tmpT = tmp.poll();
                    qTrees[i][j].add(tmpT);
                }
                while(!deleted.isEmpty()) {
                    int tmpDe = deleted.poll();
                    a[i][j] += tmpDe;
                }
            }
        }
    }
}