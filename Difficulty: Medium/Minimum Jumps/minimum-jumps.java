class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        int far = 0;
        int currEnd = 0;
        int jumps = 0;
        for(int i=0; i<n; i++){
            if(far < i)
                return -1;
            far = Math.max(far, i + nums[i]);
            if(currEnd == i){
                jumps++;
                currEnd = far;
                if(far >= n-1)
                    return jumps;
            }
        }
        return -1;
    }
}