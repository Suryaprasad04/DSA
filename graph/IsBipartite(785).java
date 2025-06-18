import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];  // Array to store the colors of the nodes
        Arrays.fill(color, -1);  // Initially, all nodes are uncolored

        // Try to color each component of the graph
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {  // If the node is not colored, start BFS
                if (!bfs(graph, i, color)) {
                    return false;  // If any component is not bipartite, return false
                }
            }
        }

        return true;  // If we reach here, the graph is bipartite
    }

    private boolean bfs(int[][] graph, int start, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;  // Start coloring the first node with color 0

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    // If the neighbor is uncolored, color it with the opposite color
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    // If the neighbor has the same color as the current node, return false
                    return false;
                }
            }
        }

        return true;
    }
}
