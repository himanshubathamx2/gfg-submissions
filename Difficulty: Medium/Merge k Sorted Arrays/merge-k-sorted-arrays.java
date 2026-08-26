class Triplet{
    int val;
    int index;
    int arrayIndex;
    Triplet(int val, int index , int arrayIndex){
        this.val = val;
        this.index = index;
        this.arrayIndex = arrayIndex;
    }
}

class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Triplet> q = new PriorityQueue<>((a, b)-> a.val-b.val);
        for(int i=0; i <mat.length; i++){
            q.offer(new Triplet(mat[i][0], 0, i));
        }
        
        while(!q.isEmpty()){
            Triplet popped = q.poll();
            int val = popped.val;
            int index = popped.index;
            int arrayIndex = popped.arrayIndex;
            list.add(val);
            if(index + 1 < mat[arrayIndex].length){
                q.offer(new Triplet(mat[arrayIndex][index + 1], index + 1, arrayIndex));
            }
        }
        return list;
    }
}