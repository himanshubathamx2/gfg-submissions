class Triplet{
    int val;
    int i;
    int j;
    Triplet(int val, int i, int j){
        this.val = val;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        sortDescending(a);
        sortDescending(b);
        PriorityQueue<Triplet> pq = new PriorityQueue<>((x, y) -> y.val - x.val);
        int n = a.length;
        Set<String> set = new HashSet<>();
        pq.offer(new Triplet(a[0] + b[0], 0, 0));
        set.add(0+","+0);        
        ArrayList<Integer> ans = new ArrayList<>();
        int c = 0;
        while(!pq.isEmpty()){
            Triplet popped =  pq.poll();
            int val = popped.val;
            int i = popped.i;
            int j = popped.j;
            c++;
            ans.add(val);
            if(c == k)
                return ans;
            if(i+1 < n && !set.contains((i+1)+","+j)){
                pq.offer(new Triplet(a[i+1] + b[j], i+1, j));
                set.add((i+1)+","+j);
            }
            if(j+1 < n && !set.contains(i+","+(j+1))){
                pq.offer(new Triplet(a[i] + b[j+1], i, j+1));
                set.add(i+","+(j+1));
            }
        }
        return null;
    }
    
    public static void sortDescending(int[] arr) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}