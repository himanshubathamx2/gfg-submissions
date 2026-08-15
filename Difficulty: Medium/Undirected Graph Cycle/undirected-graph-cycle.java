class Solution {
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] vis = new int[V];
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                if(dfs(i, adj, vis, -1))
                    return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int i, List<List<Integer>> adj, int[] vis, int parent){
        vis[i] = 1;
        for(int adja : adj.get(i)){
            if(vis[adja] == 0){
                if(dfs(adja, adj, vis, i)){
                    return true;
                }
            }else if(vis[adja] == 1 && adja != parent){
                return true;    
            }
        }
        return false;
    }
}