import java.util.Scanner;
import java.util.*;

public class Solution {
    
    static int mod = 1000000007;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1; // Assuming input is 1-indexed
            int v = scanner.nextInt() - 1; // Adjusting to 0-indexed for the array
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        System.out.println(countShortestPaths(graph, n, 0, n - 1));
        scanner.close();
    }
    
    public static int countShortestPaths(List<List<Integer>> graph, int n, int src, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        int[] paths = new int[n];
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        
        queue.offer(src);
        dist[src] = 0;
        paths[src] = 1; // Path from start to start is 1
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            for (int v : graph.get(u)) {
                if (dist[v] == -1) {
                    queue.offer(v);
                    dist[v] = dist[u] + 1;
                    paths[v] = paths[u];
                } else if (dist[v] == dist[u] + 1) {
                    paths[v] = (paths[v] + paths[u]) % mod;
                }
            }
        }
        
        return paths[dest];
    }
}
