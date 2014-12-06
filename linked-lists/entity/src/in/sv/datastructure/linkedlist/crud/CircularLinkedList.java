package in.sv.datastructure.linkedlist.crud;

import in.sv.datastructure.linkedlist.ListNode;

public class CircularLinkedList {

	public Integer getCLLListLength(ListNode headNode) {

		int length = 0;

		if (headNode == null)
			return 0;

		ListNode node = headNode;

		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
			length++;
			if (node == headNode)
				break;
		}
		return length;
	}

	public ListNode insertCLLNode(ListNode headNode, ListNode nodeToInsert,
			int position) {
		if (headNode == null) {
			nodeToInsert.setNext(nodeToInsert);
			return nodeToInsert;
		}
		int length = getCLLListLength(headNode);
		if (position > length + 1 || position < 1) {
			System.out.println("Invalid position");
			return headNode;
		}
		if (position == 1) {
			ListNode lastNode = getNode(headNode, length);
			lastNode.setNext(nodeToInsert);
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
		} else {
			ListNode previousNode = getNode(headNode, position - 1);
			ListNode currentNode = previousNode.getNext();
			nodeToInsert.setNext(currentNode);
			previousNode.setNext(nodeToInsert);
		}
		return headNode;
	}

	public ListNode deleteCLLNode(ListNode headNode, int position) {

		if (headNode == null) {
			System.out.println("List is empty");
			return null;
		}
		int length = getCLLListLength(headNode);
		if (position < 1 || position > length + 1) {
			System.out.println("Invalid position");
			return headNode;
		}

		if (position == 1) {
			ListNode lastNode = getNode(headNode, length);
			lastNode.setNext(headNode.getNext());
			headNode = headNode.getNext();
		} else if (position == length) {
			ListNode previousNode = getNode(headNode, position - 1);
			previousNode.setNext(headNode);
		} else {
			ListNode previousNode = getNode(headNode, position - 1);
			ListNode currentNode = previousNode.getNext();
			previousNode.setNext(currentNode.getNext());
			currentNode = null;
		}

		return headNode;

	}

	public ListNode getNode(ListNode headNode, int position) {

		if (headNode == null)
			return null;

		int count = 0;

		ListNode node = headNode;

		while (count < position) {
			count++;
			node = headNode.getNext();
		}
		return node;

	}

}
