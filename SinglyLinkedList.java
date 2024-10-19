package test;

import java.util.Scanner;

import linkedlist.Node;

public class SinglyLinkedList {
	Node2 head;
	
	
	void insert(int data) {
        Node2 newNode = new Node2(data);
        if (head == null) {
            head = newNode;
        } else {
            Node2 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
	   void displayAlternateNode() {
	        Node2 current = head;
	        int count = 0;
	        while (current != null) {
	            if (count % 2 == 0) {
	                System.out.print(current.data + " ");
	            }
	            count++;
	            current = current.next;
	        }
	    }
	
	public static void main(String[] args) {
	
		 SinglyLinkedList list = new SinglyLinkedList();
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\nMenu:");
	            System.out.println("1. Insert  node");
	            System.out.println("2. Display alternate nodes");
	            System.out.println("3. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter value to insert: ");
	                    int value = scanner.nextInt();
	                    list.insert(value);
	                    System.out.println("Node inserted successfully.");
	                    break;
	                case 2:
	                    System.out.print("Alternate nodes: ");
	                    list.displayAlternateNode();
	                    System.out.println();
	                    break;
	                case 3:
	                    System.out.println("Exiting.");
	                    break;
	                default:
	                    System.out.println("Invalid choice");
	            }
	        } while (choice != 3);

	        scanner.close();
	    }
	}


