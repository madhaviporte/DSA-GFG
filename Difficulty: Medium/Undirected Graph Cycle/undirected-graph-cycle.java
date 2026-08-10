class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
          // --- STEP 1: Build the Adjacency List ---
        // This is like mapping out exactly which rooms connect to which rooms
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // It's an undirected graph, so the connection goes both ways!
        }
        
        // --- STEP 2: The Visited Array ---
        boolean[] visited = new boolean[V];
        
        // --- STEP 3: Handle Disconnected Components ---
        // A graph might be broken into multiple floating pieces. 
        // We loop through EVERY vertex to make sure we don't miss a piece.
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // Start a DFS. The very first node has no parent, so we pass -1
                if (dfs(i, -1, adj, visited)) {
                    return true; // We found a cycle in this piece of the graph!
                }
            }
        }
        
        return false; // We checked every piece and found no cycles
    }
    
    // --- STEP 4: The DFS Helper ---
    private boolean dfs(int current, int parent, List<List<Integer>> adj, boolean[] visited) {
        // Mark where we are standing as visited
        visited[current] = true;
        
        // Look at all the neighbors connected to this node
        for (int neighbor : adj.get(current)) {
            
            if (!visited[neighbor]) {
                // If it's unvisited, dive deep! 'current' becomes the new 'parent'
                if (dfs(neighbor, current, adj, visited)) {
                    return true; 
                }
            } 
            // CRITICAL CHECK: It IS visited, AND it's NOT the node we just came from!
            else if (neighbor != parent) {
                return true; // Cycle detected!
            }
        }
        
        return false;
    }
}