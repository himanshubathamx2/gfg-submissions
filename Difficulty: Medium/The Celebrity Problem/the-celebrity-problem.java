

class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int m  = mat[0].length;
        int[] knowMe = new int[n];
        int[] iKnow = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i != j && mat[i][j]==1){
                    knowMe[j]++;
                    iKnow[i]++;    
                }
            }
        }
        for(int j=0; j<m; j++){
            // System.out.print(iKnow[j]+" ");
            if(iKnow[j]==0 && knowMe[j]==n-1)
                return j;
        }
        //  System.out.println();
        //  for(int j=0; j<m; j++){
        //     System.out.print(knowMe[j]+" ");
        // }
        // System.out.println();
        return -1;
    }
}