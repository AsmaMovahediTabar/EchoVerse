package src;

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
    
    public void insert(int ID , int priority){
        if(capacity == size){
            HeapNode[] newHeap = new HeapNode[heap.length * 2];

            for (int i = 0; i < heap.length; i++) {
                newHeap[i] = heap[i];
            }
            heap = newHeap;
        }
        heap[size] = new HeapNode(ID , priority);
        int s = size;
        size++;
        while(s != 0 && heap[parent(s)].Priority > heap[s].Priority){
            swap(s , parent(s));
            s = parent(s);
        }g
    }
}
