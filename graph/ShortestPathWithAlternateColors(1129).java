class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] redGraph = new ArrayList[n];
        List<Integer>[] blueGraph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            redGraph[i] = new ArrayList<>();
            blueGraph[i] = new ArrayList<>();
        }
        for (int[] e : redEdges) redGraph[e[0]].add(e[1]);
        for (int[] e : blueEdges) blueGraph[e[0]].add(e[1]);

        int[] res = new int[n];
        Arrays.fill(res, -1);

        boolean[][] visited = new boolean[n][2]; // visited[node][color], 0=red, 1=blue
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0, 0}); // node, steps, lastColor (0=red)
        q.offer(new int[]{0, 0, 1}); // node, steps, lastColor (1=blue)
        visited[0][0] = visited[0][1] = true;
        res[0] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0], steps = cur[1], lastColor = cur[2];

            List<Integer>[] nextGraph = lastColor == 0 ? blueGraph : redGraph;
            int nextColor = 1 - lastColor;

            for (int nei : nextGraph[node]) {
                if (!visited[nei][nextColor]) {
                    visited[nei][nextColor] = true;
                    q.offer(new int[]{nei, steps + 1, nextColor});
                    if (res[nei] == -1) res[nei] = steps + 1;
                }
            }
        }

        return res;
    }
}
