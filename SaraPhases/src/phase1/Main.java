package src.phase1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AvlTree avl = new AvlTree();
        while (true) {
            System.out.println("\n*** Manage Approved Channel ***");
            System.out.println("*   1.Insert channel          *");
            System.out.println("*   2.Delete channel          *");
            System.out.println("*   3.Search channel          *");
            System.out.println("*   4.Display                 *");
            System.out.println("*   0.Exit                    *");
            System.out.println("*******************************");
            System.out.print("Enter the desired number to perform the operation: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter channel ID: ");
                    int insertID = scanner.nextInt();
                    avl.insert(insertID);
                    break;
                case 2:
                    System.out.print("Enter channel ID: ");
                    int deleteID = scanner.nextInt();
                    avl.delete(deleteID);
                    break;
                case 3:
                    System.out.print("Enter channel ID: ");
                    int searchID = scanner.nextInt();
                    boolean found = avl.search(searchID);
                    System.out.println("Channel " + searchID + " is " + (found ? "" : "NOT ") + "authorized");
                    break;
                case 4:
                    avl.disPlay();
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