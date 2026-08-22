class Solution {
    public int kthSmallest(int[] arr, int k) {
        int n = arr.length;
        for(int i=n/2; i>=0; i--){
            minH(arr, i, n-1);
        }
        
        for(int i=1; i<k; i++){
            arr[0] = arr[n-1];
            n--;
            minH(arr, 0, n);
        }
        return arr[0];
    }
    
    public void minH(int[] arr, int i, int n){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if(left <= n && arr[left] < arr[smallest]) smallest = left;
        if(right <= n && arr[right] < arr[smallest]) smallest = right;
        if(smallest != i){
            int tmp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = tmp;
            minH(arr, smallest, n);
        }
    }
}
