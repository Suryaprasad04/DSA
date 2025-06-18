class Solution {
    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int[] parent, int[] rank, int u, int v) {
        int rootU = find(parent, u);
        int rootV = find(parent, v);
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i; // Initialize each node as its own parent
            rank[i] = 1;   // Rank is initially 1
        }

        // Build the Union-Find structure
        for (int[] edge : edges) {
            union(parent, rank, edge[0], edge[1]);
        }

        // Check if source and destination belong to the same component
        return find(parent, source) == find(parent, destination);
    }
}
