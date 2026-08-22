class MinHeap {
    int[] arr;
    int cap;
    int size;

    MinHeap(int cap) {
        size = 0;
        this.cap = cap;
        arr = new int[cap];
    }
    
    public int parent(int i){return (i-1)/2;}
    public int left(int i){return 2*i + 1;}
    public int right(int i){return 2*i + 2;}

  
    int extractMin() {
        if(size == 0)
            return -1;
        int val = arr[0];
        arr[0] = arr[size-1];
        size--;
        MinHeapify(0);
        return val;
    }

    void insertKey(int k) {
        if(size == cap)
            return;
        arr[size] = k;
        int i = size;
        size++;
        while(parent(i) >= 0 && arr[parent(i)] > arr[i]){
            swap(arr, parent(i), i);
            i = parent(i);
        }
    }

    void deleteKey(int i) {
        if(i >= size)
            return;
        arr[i] = Integer.MIN_VALUE;
        while(parent(i) >= 0 && arr[parent(i)] > arr[i]){
            swap(arr, parent(i), i);
            i = parent(i);
        }
        extractMin();
    }

    void decreaseKey(int i, int new_val) {
     
    }

    void MinHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;
        if(left <= size && arr[left] < arr[smallest]) smallest = left;
        if(right <= size && arr[right] < arr[smallest]) smallest = right;
        if(smallest != i){
            swap(arr, i, smallest);
            MinHeapify(smallest);
        }
    }
    
    public void swap(int nums[], int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}