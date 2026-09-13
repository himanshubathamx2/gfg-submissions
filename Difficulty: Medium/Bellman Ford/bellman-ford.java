class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        int[] dis = new int[V];
        Arrays.fill(dis, (int)1e8);
        dis[src] = 0;
        for(int i=0; i<V-1; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dis[u] != (int)1e8 && dis[u] + wt < dis[v]){
                    dis[v] = dis[u] + wt;    
                }
            }
        }
        
        for(int[] edge : edges){
            int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dis[u] != (int)1e8 && dis[u] + wt < dis[v]){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(-1);
                return list;    
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int distance : dis){
            ans.add(distance);
        }
        return ans;
    }
}
