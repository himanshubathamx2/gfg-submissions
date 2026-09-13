class DisjointSetBySize {
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    DisjointSetBySize(int nodes){
        for(int i=0;i<nodes;i++){
            size.add(1);
            parent.add(i);
        }
    }


    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}


class Solution {
    public int spanningTree(int V, int[][] edges) {
        Arrays.sort(edges, (e1, e2) -> e1[2] - e2[2]);
        DisjointSetBySize ds = new DisjointSetBySize(V);
        int wt = 0;
        for(int[] edge : edges){
            int ult_u = ds.findUPar(edge[0]);
            int ult_v = ds.findUPar(edge[1]);
            if(ult_u == ult_v){
                continue;
            }else{
                ds.unionBySize(edge[0], edge[1]);
                wt += edge[2];
            }
        }
        return wt;
    }
}
