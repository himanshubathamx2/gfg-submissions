class Triplet{
    int val;
    int array;
    int index;
    Triplet(int val, int array, int index){
        this.val = val;
        this.array = array;
        this.index = index;
    }
}

class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        int n = mat.length;
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i=0; i<n; i++){
            pq.offer(new Triplet(mat[i][0], i, 0));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!pq.isEmpty()){
            Triplet popped = pq.poll();
            int val = popped.val;
            int array = popped.array;
            int index = popped.index;
            
            ans.add(val);
            
            if(index + 1 < mat[array].length)
                pq.offer(new Triplet(mat[array][index + 1], array, index + 1));
        }
        return ans;
    }
}