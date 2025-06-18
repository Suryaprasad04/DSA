class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<String> originalEdges = new HashSet<>();

        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());

        for (int[] conn : connections) {
            int from = conn[0], to = conn[1];
            graph.get(from).add(to);
            graph.get(to).add(from);

            originalEdges.add(from + "->" + to);  // store original edge direction
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, originalEdges, visited);
    }

    private int dfs(int node, Map<Integer, List<Integer>> graph, Set<String> originalEdges, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                // If original edge was from node to nei, this edge needs to be reversed
                if (originalEdges.contains(node + "->" + nei)) {
                    changes++;
                }
                changes += dfs(nei, graph, originalEdges, visited);
            }
        }
        return changes;
    }
}
