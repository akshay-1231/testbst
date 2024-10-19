//Write menu driven program  for Binary Search Tree. The menu includes 
//	Create a Binary Search Tree
//	Display
//	Delete a given element from Binary Search Tree




package test;

import java.util.Scanner;

public class BinarySearch2 {
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

	void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.value + " ");
			inorder(node.right);
		}
	}

	Node delete(Node root, int value) {
		if (root == null)
			return root;

		if (value < root.value) {
			root.left = delete(root.left, value);
		} else if (value > root.value) {
			root.right = delete(root.right, value);
		} else {

			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			root.value = minValue(root.right);
			root.right = delete(root.right, root.value);
		}
		return root;
	}

	int minValue(Node node) {
		int minValue = node.value;
		while (node.left != null) {
			minValue = node.left.value;
			node = node.left;
		}
		return minValue;
	}

	public static void main(String[] args) {
		BinarySearch2 bst = new BinarySearch2();
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\nMenu:");
			System.out.println("1. Create a BST");
			System.out.println("2. Display");
			System.out.println("3. Delete an element from BST");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter values separated by spaces: ");
				while (true) {
					int value = scanner.nextInt();
					if (value == -1)
						break;
					bst.insert(value);
				}
				System.out.println("BST created successfully.");
				break;
			case 2:
				System.out.print("BST Elements: ");
				bst.inorder(bst.root);
				System.out.println();
				break;
			case 3:
				System.out.print("Enter element to delete: ");
				int elementToDelete = scanner.nextInt();
				bst.root = bst.delete(bst.root, elementToDelete);
				System.out.println("Element deleted if it existed.");
				break;
			case 4:
				System.out.println("Exiting.");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} while (choice != 4);

		scanner.close();
	}

}
