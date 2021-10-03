import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int visited[]= new int[adj.length];
        //write your code here
        return DFS(adj,visited);
    }
    private static void explore(ArrayList<Integer>[] adj,int[]visited,int x){
        visited[x]=1;
        for (int i=0;i<adj[x].size();i++){
            if (visited[adj[x].get(i)]==0){
                explore(adj,visited,adj[x].get(i));
            }
        }
    }
    private static int DFS(ArrayList<Integer>[] adj,int []visited){
        int label=0;
        for (int i=0;i<adj.length;i++){
            if (visited[i]==0){
                explore(adj,visited,i);
                label++;
            }
        }
        return label;
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
        System.out.println(numberOfComponents(adj));
    }
}

