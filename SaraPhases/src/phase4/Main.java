package src.phase4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MinHeap heap = new MinHeap(50);
        while (true) {
            System.out.println("\n*** Episode Release Queue ***");
            System.out.println("*   1.Insert episode        *");
            System.out.println("*   2.Extract min           *");
            System.out.println("*   3.Delete episode by ID  *");
            System.out.println("*   4.Display heap          *");
            System.out.println("*   5.Heap sort             *");
            System.out.println("*   0.Exit                  *");
            System.out.println("*****************************");
            System.out.print("Enter the desired number to perform the operation: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter episode ID: ");
                    String ID = scanner.next();
                    System.out.print("Enter priority: ");
                    int priority = scanner.nextInt();
                    heap.insert(ID, priority);
                    break;
                case 2:
                    HeapNode e = heap.extractMin();
                    if (e != null) {
                        System.out.println("Extracted episode: "
                                + e.ID + " with priority " + e.priority);
                    } else {
                        System.out.println("Heap is empty");
                    }
                    break;
                case 3:
                    System.out.print("Enter episode ID to delete: ");
                    String deleteID = scanner.next();
                    heap.delete(deleteID);
                    break;
                case 4:
                    heap.disPlay();
                    break;
                case 5:
                    heap.heapSort();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
