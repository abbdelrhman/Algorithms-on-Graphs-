import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static Queue<Integer> queue ;
    private static int dist[] ;
    private static int prev[] ;
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        //write your code here
        BFS(adj,s);
        int result = 0 ;
        while (t!=s){
            result++;
            if (prev[t] == -1){
                return -1;
            }
            t=prev[t];
        }
        return result ;
    }

    private static void BFS(ArrayList<Integer>[] adj, int s) {
        queue=new LinkedList<>();
        dist = new int[adj.length];
        prev = new int[adj.length];
        for (int i=0 ; i<dist.length;i++){
            dist[i]=Integer.MAX_VALUE;
            prev[i]=-1;
        }
        dist[s]=0;
        queue.add(s);
        while (!queue.isEmpty()){
            int u = queue.remove();
            for (int i=0 ; i<adj[u].size();i++){
                if (dist[adj[u].get(i)] == Integer.MAX_VALUE){
                    queue.add(adj[u].get(i));
                    dist[adj[u].get(i)] = dist[u]+1;
                    prev[adj[u].get(i)] = u;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

