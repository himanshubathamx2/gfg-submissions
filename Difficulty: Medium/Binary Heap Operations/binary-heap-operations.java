class MinHeap {
    int[] harr;
    int cap;
    int size;

    MinHeap(int cap) {
        this.size = 0;
        this.cap = cap;
        this.harr = new int[cap];
    }

    int parent(int i) { return (i - 1) / 2; }

    int left(int i) { return (2 * i + 1); }

    int right(int i) { return (2 * i + 2); }

    void insertKey(int k) {
        if(size == cap)
            return;
        harr[size] = k;
        int i = size;
        size++;
        while(i > 0 && harr[parent(i)] > harr[i]){
            swap(harr, parent(i), i);
            i = parent(i);
        }
    }
    
    
    int extractMin() {
        if(size == 0)
            return -1;
        int val = harr[0];
        harr[0] = harr[size - 1];
        size--;
        MinHeapify(0);
        return val;
    }
    
        
    void deleteKey(int i) {
        if(i >= size)
            return;
        harr[i] = Integer.MIN_VALUE;
        while(i > 0 && harr[parent(i)] > harr[i]){
            swap(harr, parent(i), i);
            i = parent(i);
        }
        extractMin();
    }



    void MinHeapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if(left < size && harr[left] < harr[smallest]) smallest = left;
        if(right < size && harr[right] < harr[smallest]) smallest = right;
        if(smallest != i){
            swap(harr, smallest, i);
            MinHeapify(smallest);
        }
    }
    
    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}