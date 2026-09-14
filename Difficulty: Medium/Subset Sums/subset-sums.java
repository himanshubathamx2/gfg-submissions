

// User function Template for Java//User function Template for Java
class Solution {
    ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        sub(0, new ArrayList<>(), ans, arr, 0);
        return ans;
    }
    public void sub(int i, ArrayList<Integer> sub, ArrayList<Integer> ans, int[] arr, int total){
        if(i==arr.length){
            int sum = 0;
            for(int num : sub){
                sum += num;
            }
            ans.add(sum);
            return;
        }
        sub.add(arr[i]);
        sub(i+1, sub, ans, arr, total + arr[i]);
        sub.remove(Integer.valueOf(arr[i]));
        sub(i+1, sub, ans,arr, total);
    }
}