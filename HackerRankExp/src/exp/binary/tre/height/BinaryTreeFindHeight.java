package exp.binary.tre.height;

import java.util.Scanner;

public class BinaryTreeFindHeight {

	public static class Node {
		int data; // Data of current Node.
		Node left; // Pointer to left child Node.
		Node right; // Pointer to right child Node.

		public Node(int data) {
			this.data = data;
		}
	}
	
	
	
	static Node lca(Node root, int v1, int v2) {
	    if (root == null) return null;
	    if (v1 > v2) {          
	        int temp = v2;
	        v2 = v1;
	        v1 = temp;
	    }
	    while (root.data < v1 || root.data > v2) {
	        if (root.data < v1) root = root.right;
	        else if (root.data > v2) root = root.left;
	    }       
	    return root;
	}


	public static int getHeight(Node root) {
		if (root == null) {
			return -1;
		} else {
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		int height = getHeight(root);
		System.out.println(height);
		
		System.out.println("***");
		
		 int v1 = sc.nextInt();
	      	int v2 = sc.nextInt();
	      	sc.close();
	        Node ans = lca(root,v1,v2);
	        System.out.println(ans.data);
		
	}
}
