class Solution {
    public int countSCC(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] vis = new int[V];
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                dfs(i, adj, stack, vis);
            }
        }
        //---------------------------------------------
        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i=0; i<V; i++){
            revAdj.add(new ArrayList<>());
        }  
        for(int[] edge : edges){
            revAdj.get(edge[1]).add(edge[0]);
        } 
        
        int c = 0;
        vis = new int[V];
        while(!stack.isEmpty()){
            int i = stack.pop();
            if(vis[i] == 0){
                c++;
                dfs2(i, revAdj, vis);
            }
        }
        return c;
    }
    
    public void dfs(int i, List<List<Integer>> adj, Stack<Integer> stack, int[] vis){
        vis[i] = 1;
        for(int adja : adj.get(i)){
            if(vis[adja] == 0){
                dfs(adja, adj, stack, vis);
            }
        }
        stack.push(i);
    }
    
    public void dfs2(int i, List<List<Integer>> adj, int[] vis){
        vis[i] = 1;
        for(int adja : adj.get(i)){
            if(vis[adja] == 0){
                dfs2(adja, adj, vis);
            }
        }
    }
}