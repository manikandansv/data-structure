package in.sv.datastructure.linkedlist.problems;

import in.sv.datastructure.linkedlist.ListNode;
import in.sv.datastructure.linkedlist.crud.SingleLinkedList;

import java.util.HashMap;
import java.util.Map;

public class LinkedListProblems {

	public void stackByLL() {
		/**
		 * Stack Implementation using Linkedlist. Refer LLStack.java
		 */
	}

	/**
	 * Problem -2: Find nth node from end of linked list - BruteForce approach
	 * 1. Start with first node, 2. count number of nodes after that 3. If
	 * count(n) < n-1, return error saying less number of nodes 4. If count(n> >
	 * n-1, goto next node 5. Repeat 2 until count(n) = n-1 Time Complexity:
	 * O(n2) - Scanning remaining nodes for each node Space Complexity: O(1)
	 */
	public ListNode findNthNodeFromEndMethod1(ListNode node, int position) {

		SingleLinkedList sll = new SingleLinkedList();

		ListNode resultNode = null;

		while (true) {

			int length = sll.sllLength(node);

			int lengthExcl = length - 1;

			if (lengthExcl == position - 1) {
				resultNode = node;
				break;
			} else if (lengthExcl > position - 1) {
				node = node.getNext();
			} else {
				System.out.println("Invalid position");
				break;
			}
		}

		return resultNode;

	}

	/**
	 * Problem-3: Improve the complexity of Problem-2 via HashMap Time
	 * Complexity: 2*O(n) => O(n) Space Complexity: O(n)
	 * 
	 * @param node
	 * @param position
	 * @return
	 */
	public ListNode findNthNodeFromEndMethod2(ListNode node, int position) {

		ListNode resultNode = null;

		Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();

		int i = 0;

		/** Below while block is O(n) */
		while (node != null) {

			i++;

			map.put(i, node);

			node = node.getNext();

		}

		resultNode = map.get(i - position);

		return resultNode;
	}

	/**
	 * Problem-4: Implement above without hashmap with improved complexity Time
	 * Complexity: O(n) Space Complexity: O(1)
	 * 
	 * @param node
	 * @param position
	 * @return
	 */
	public ListNode findNthNodeFromEndMethod3(ListNode node, int position) {

		ListNode resultNode = null;

		SingleLinkedList sll = new SingleLinkedList();

		int listLength = sll.sllLength(node);

		int n = listLength - position;

		int i = 0;

		while (i != n) {

			i++;

			if (i == n) {
				resultNode = node;
				break;
			}

			node = node.getNext();

		}

		return resultNode;

	}

	/**
	 * Problem -5: Solve Problem-2 in one scan Use two pointers NthNode & temp;
	 * Point both pointers to head; NthNode starts moving only after temp made n
	 * moves; From there both moves forward until temp reaches end. As a result,
	 * NthNode points to nth node from end of list
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * @param node
	 * @param position
	 * @return
	 */
	public ListNode findNthNodeFromEndMethod4(ListNode head, int position) {

		ListNode pNthNode = null;

		ListNode pTemp = null;

		int i = 0;

		for (pTemp = head; pTemp != null;) {

			i++;

			if (i - position == 0)
				pNthNode = head;
			else if (i - position > 0)
				pNthNode = pNthNode.getNext();

			pTemp = pTemp.getNext();
		}

		if (pNthNode != null)
			return pNthNode;

		return null;

	}

	/**
	 * Problem-6: Check whether a given linked list is either NULL terminated or
	 * ends in a cycle
	 * Brute force approach
	 * @return
	 */
	public boolean checkListIsNullTerminated() {
		return false;

		
		
	}

}
