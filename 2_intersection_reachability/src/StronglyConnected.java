import java.util.*;

public class StronglyConnected {
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        //write your code here
        int visited[] = new int[adj.length];
        Stack<Integer> order = new Stack<>();
        for (int i = 0; i < adj.length; i++) {
            if (visited[i] == 0) {
                DFS(i, order, visited, adj);
            }
        }
        visited = new int[adj.length];
        ArrayList<Integer>[] reverseG = reverseGraph(adj);
        int ans=0;
        while (!order.isEmpty()){
            int vertex = order.pop();
            if (visited[vertex] == 0){
                DFS(vertex,new Stack<>(),visited,reverseG);
                ans++;
            }
        }
        return ans;
    }


    private static ArrayList<Integer>[] reverseGraph(ArrayList<Integer>[] adj) {
        ArrayList<Integer>[] reverseG = (ArrayList<Integer>[]) new ArrayList[adj.length];
        for (int i = 0; i < adj.length; i++) {
            reverseG[i] = new ArrayList<>();
        }
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                reverseG[adj[i].get(j)].add(i);
            }
        }
        return reverseG;
    }

    private static void DFS(int start, Stack<Integer> order, int visited[], ArrayList<Integer>[] adj) {
        visited[start] = 1;
        for (int i = 0; i < adj[start].size(); i++) {
            if (visited[adj[start].get(i)]==0){

                DFS(adj[start].get(i),order,visited,adj);
            }
        }
        order.push(start);
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
        }
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}

