import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    private static int color[];

    private static int bipartite(ArrayList<Integer>[] adj) {
        //write your code here
        color = new int[adj.length]; // 1 for white , 2 for black
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        color[0]=1;
        int currentColor = 1;
        while (!queue.isEmpty()){
            int u = queue.remove();
            currentColor = color[u];
            for (int i=0 ; i<adj[u].size();i++){
                int v= adj[u].get(i);
                if (color[v] == currentColor){
                    //not bipartite
                    return 0;
                }else if (color[v]==0) {
                    queue.add(v);
                    if (currentColor == 1){
                        color[v]=2;
                    }else {
                        color[v]=1;
                    }
                }
            }

        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
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
        System.out.println(bipartite(adj));
    }
}

