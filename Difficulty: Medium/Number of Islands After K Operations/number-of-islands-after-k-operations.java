class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
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
    public ArrayList<Integer> numOfIslands(int n, int m, int[][] operators) {
        DisjointSet ds = new DisjointSet(n*m);
        ArrayList<Integer> ans = new ArrayList<>();
        int[][] mat = new int[n][m];
        int c = 0;
        int[] drow = {1, -1, 0, 0};
        int[] dcol = {0, 0, 1, -1};
        for(int[] pair : operators){
            int i = pair[0];
            int j = pair[1];
            if(mat[i][j] == 1){
                ans.add(c);
                continue;
            }
            mat[i][j] = 1;
            c++;
            for(int k=0; k<4; k++){
                int nrow = i + drow[k];
                int ncol = j + dcol[k];
                if(nrow >=0 && nrow < n && ncol >=0 && ncol <m && mat[nrow][ncol]==1){
                    if(ds.findUPar(i*m+j) != ds.findUPar(nrow*m+ncol)){
                        ds.unionBySize(i*m+j, nrow*m+ncol);
                        c--;
                    }
                }
            }
            ans.add(c);
        }
        return ans;
    }
}