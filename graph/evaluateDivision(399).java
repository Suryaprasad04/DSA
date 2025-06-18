import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Build the graph as an adjacency list
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            double value = values[i];
            
            // Add the forward relation (numerator / denominator = value)
            graph.putIfAbsent(numerator, new HashMap<>());
            graph.putIfAbsent(denominator, new HashMap<>());
            graph.get(numerator).put(denominator, value);
            graph.get(denominator).put(numerator, 1 / value);
        }
        
        // Step 2: Process each query
        double[] result = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;  // If the variables are not in the graph, return -1.0
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, start, end, visited);
            }
        }
        
        return result;
    }
    
    // Step 3: DFS function to find the path from start to end and calculate the result
    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        // Base case: If start equals end, return 1.0
        if (start.equals(end)) {
            return 1.0;
        }
        
        visited.add(start);
        
        // Traverse all neighbors of the current node (start)
        for (String neighbor : graph.get(start).keySet()) {
            if (!visited.contains(neighbor)) {
                double value = graph.get(start).get(neighbor);
                double result = dfs(graph, neighbor, end, visited);
                
                // If a path exists, multiply the value along the path
                if (result != -1.0) {
                    return value * result;
                }
            }
        }
        
        // If no path exists, return -1.0
        return -1.0;
    }
}
