//Write menu driven program  for Binary Search Tree. The menu includes 
//	Create a Binary Search Tree
//	Traverse it by using Preorder and Post order traversing technique

package test;

import java.util.Scanner;

public class BinarySearch {
	Node root;

	void insert(int value) {
		root = insertRec(root, value);
	}

	Node insertRec(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}
		if (value < root.value) {
			root.left = insertRec(root.left, value);
		} else {
			root.right = insertRec(root.right, value);
		}
		return root;
	}

	void preorder(Node node) {
		if (node != null) {
			System.out.print(node.value + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	void postorder(Node node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.value + " ");
		}
	}

	public static void main(String[] args) {
		BinarySearch bst = new BinarySearch();
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\nMenu:");
			System.out.println("1. Create a Binary Search Tree");
			System.out.println("2. Preorder Travers");
			System.out.println("3. Postorder Travers");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter values separated by spaces (end with -1): ");
				while (true) {
					int value = sc.nextInt();
					if (value == -1)
						break;
					bst.insert(value);
				}
				System.out.println("BST created successfully.");
				break;
			case 2:
				System.out.print("Preorder Traversal: ");
				bst.preorder(bst.root);
				System.out.println();
				break;
			case 3:
				System.out.print("Postorder Traversal: ");
				bst.postorder(bst.root);
				System.out.println();
				break;
			case 4:
				System.out.println("Exiting.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 4);

		sc.close();
	}
}
