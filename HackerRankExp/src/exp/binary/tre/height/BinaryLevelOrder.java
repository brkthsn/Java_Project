package exp.binary.tre.height;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import exp.binary.tre.height.BinaryTreeFindHeight.Node;

public class BinaryLevelOrder {
	public static class Node {
		int data; // Data of current Node.
		Node left; // Pointer to left child Node.
		Node right; // Pointer to right child Node.

		public Node(int data) {
			this.data = data;
		}
	}
	
	
	 static void levelOrder(Node root){
		    //Write your code here
		      Queue<Node> queue = new LinkedList<Node>();
		      queue.add(root);
		      while(queue.peek()!=null)
		          {
		          Node node =queue.remove();
		          System.out.print(""+node.data+" ");
		          if(node.left!=null)
		              queue.add(node.left);
		          if(node.right!=null)
		              queue.add(node.right);
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
		  levelOrder(root);
		
	}
}
