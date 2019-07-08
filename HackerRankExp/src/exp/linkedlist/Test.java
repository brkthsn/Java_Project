package exp.linkedlist;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static SinglyLinkedListNode insert(SinglyLinkedListNode head, int data) {
		SinglyLinkedListNode new_node = new SinglyLinkedListNode(data);
		if (head == null) {
			head = new_node;
			return head;
		}

		SinglyLinkedListNode current_node = head;

		while (current_node.getNext() != null) {
			current_node = current_node.getNext();
		}
		current_node.setNext(new_node);

		return head;
	}

}
