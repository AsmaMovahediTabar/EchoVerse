package src.phase4;

public class MinHeap {
    private HeapNode[] heap;
    private int size;
    private int capacity;
    
    public MinHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        heap = new HeapNode[capacity];
    }
    
    public int parent(int i){
        return (i -1)/2;
    }
    
    public int left(int i){
        return 2 * i +1;
    }
    
    public int right(int i){
        return 2 * i + 2;
    }
    
    public void swap(int i , int j){
        HeapNode temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    public void insert(String ID , int priority){
        if(capacity == size){
            HeapNode[] newHeap = new HeapNode[heap.length * 2];
            for(int i = 0; i < heap.length; i++) {
                newHeap[i] = heap[i];
            }
            heap = newHeap;
        }
        heap[size] = new HeapNode(ID , priority);
        int s = size;
        size++;
        while(s != 0 && heap[parent(s)].priority > heap[s].priority){
            swap(s , parent(s));
            s = parent(s);
        }
    }
    
    public HeapNode extractMin(){
            if (size <= 0){return null;}
            if (size == 1){
                size--;
                return heap[0];
            }
            HeapNode root = heap[0];
            heap[0] = heap[size - 1];
            size--;
            downHeap(0);
            return root;
        
    }
    
    public void downHeap(int i){
        int l = left(i);
        int r = right(i);
        int small = i;
        if (l < size && heap[l].priority < heap[small].priority){small = l;}
        if (r < size && heap[r].priority < heap[small].priority){small = r;}
        if (small != i){
            swap(i, small);
            downHeap(small);
        }
    }
    
    public void delete(String ID){
        int index = -1;
        for(int i = 0 ; i < size ; i++){
            if(heap[i].ID.equals(ID)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("The episode not found");
            return;
        }
        System.out.println("Episode " + heap[index].ID + " deleted");
        heap[index] = heap[size -1];
        size--;
        downHeap(index);
    }

    public void disPlay(){
        if (size == 0){ 
            System.out.println("Heap is empty!"); 
            return; 
        }
        for(int i = 0; i < size; i++){ 
            System.out.print(heap[i].ID + "(" + heap[i].priority + ") "); 
        }
    }

    public void heapSort(){
        int originalSize = size;

        while (size > 1) {
            swap(0, size - 1);
            size--;
            downHeap(0);
        }
        System.out.println("Sorted episodes by priority:");
        for (int i = originalSize - 1 ; i <= 0 ; i--) {
                System.out.print(heap[i].ID + "(" + heap[i].priority + ") ");
        }
        System.out.println();
        size = originalSize;
    }
}
