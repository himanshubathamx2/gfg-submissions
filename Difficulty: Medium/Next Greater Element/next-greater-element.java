class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] nge = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        
        for(int num : nge){
            ans.add(num);
        }
        return ans;
    }
}