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
	 * NthNode points to nth node from end of list Time Complexity: O(n) Space
	 * Complexity: O(1)
	 * 
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
	 * Problem - 6 Brute Force Approach - fails if the list endup in infinite
	 * loop Problem-7: Check whether a given linked list is either NULL
	 * terminated or ends in a cycle Hashing technique Time Complexity: O(n)
	 * Space Complexity: O(n) Problem-8: Sorting technique - fails if the list
	 * endup in infinite loop
	 * 
	 * @return
	 */
	public boolean checkListIsNullTerminatedMethod1(ListNode head) {

		Map<Long, ListNode> map = new HashMap<Long, ListNode>();

		ListNode node = head;

		boolean isCycle = false;

		while (true) {

			if (node != null) {

				map.put(node.getId(), node);

				node = node.getNext();

				if (map.get(node.getId()) != null) {
					isCycle = true;
					break;
				}
			}
		}
		return isCycle;
	}

	/**
	 * Problem-9 Efficient approach - Floyd Cycle Finding algorithm Time
	 * Complexity: O(n) Space Complexity: O(1) Problem-10 Same as Problem-6
	 * 
	 * @param head
	 * @return
	 */
	public boolean checkListIsNullTerminatedMethod2(ListNode head) {

		ListNode slowPtr = head;

		ListNode fastPtr = head;

		while (slowPtr != null && fastPtr != null) {

			fastPtr = fastPtr.getNext();

			if (fastPtr == slowPtr)
				return true;

			if (fastPtr == null)
				return false;

			fastPtr = fastPtr.getNext();

			if (fastPtr == slowPtr)
				return true;

			slowPtr = slowPtr.getNext();
		}

		return false;

	}

	/**
	 * Problem-11 Check whether the given linked list is either NULL terminated
	 * or not. If there's a cyecle, find the start node of loop Time Complexity:
	 * O(N); Space Complexity: O(1) Extension of above solution. Once the loop
	 * is identified, initialize slowPtr to head & move both pointers one step
	 * at a time. By the time both node becomes equal, it'll be starting point
	 * of loop
	 * 
	 * Problem-12: Theory: In Floyd cycle finding algorithm, the hare & tortoise
	 * will meet when they're n*L, where L is loop length One of them already in
	 * the loop, so we just move the other one in single step until it enters
	 * the loop, keeping the other n*L away from it all times
	 * 
	 * @param head
	 * @return
	 */
	public ListNode checkAndFindStartNodeOfListLoop(ListNode head) {

		ListNode slowPtr = head;

		ListNode fastPtr = head;

		boolean isLoopExists = false;

		while (slowPtr != null && fastPtr != null) {

			fastPtr = fastPtr.getNext();

			if (fastPtr == slowPtr) {
				isLoopExists = true;
				break;
			}

			if (fastPtr == null) {
				isLoopExists = false;
				break;
			}

			fastPtr = fastPtr.getNext();

			if (fastPtr == slowPtr) {
				isLoopExists = true;
				break;
			}

			slowPtr = slowPtr.getNext();
		}

		if (isLoopExists) {
			slowPtr = head;
			while (slowPtr != fastPtr) {
				slowPtr = slowPtr.getNext();
				fastPtr = fastPtr.getNext();
			}
			return slowPtr;
		}

		return null;

	}

	/**
	 * Problem-14 If there's a cycle, find the length of loop
	 * 
	 * Time Complexity: O(n); Space Complexity: O(1)
	 * 
	 * @param head
	 * @return
	 */
	public Integer getLengthOfLoopinLinkedList(ListNode head) {

		int length = 0;
		boolean isLoopExists = false;

		ListNode slowPtr = head, fastPtr = head;

		while (slowPtr != null && fastPtr != null) {

			fastPtr = fastPtr.getNext();

			if (fastPtr == null) {
				isLoopExists = false;
				break;
			}

			if (fastPtr == slowPtr) {
				isLoopExists = true;
				break;
			}

			fastPtr = fastPtr.getNext();

			if (fastPtr == slowPtr) {
				isLoopExists = true;
				break;
			}

			slowPtr = slowPtr.getNext();
		}

		if (isLoopExists) {
			slowPtr = fastPtr;
			while (slowPtr != fastPtr) {
				fastPtr = fastPtr.getNext();
				length++;
			}
		}

		return length;

	}

	/**
	 * Problem-15 Insert Node in sorted list Time Complexity: O(n) Space
	 * Complexity: O(1)
	 * 
	 * @param head
	 * @param nodeToInsert
	 * @return
	 */
	public ListNode insertNodeInSortedList(ListNode head, ListNode nodeToInsert) {

		ListNode node = head;

		while (node != null && node.getData().equals(nodeToInsert.getData())) {
			node = node.getNext();
		}

		nodeToInsert.setNext(node.getNext());
		node.setNext(nodeToInsert);

		return head;
	}

	/**
	 * Problem-16 Reverse Single Linked List Time Complexity: O(n) Space
	 * Complexity: O(1)
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseSLL(ListNode head) {

		ListNode currentNode = head;

		ListNode nextNode = null;

		ListNode prevNode = null;

		while (currentNode != null) {

			nextNode = currentNode.getNext();

			currentNode.setNext(prevNode);

			prevNode = currentNode;

			head = currentNode;

			currentNode = nextNode;
		}
		return head;
	}

	/**
	 * Problem-17 - Two single linked lists intersect at some point & become a
	 * single linked list. Head or start pointers of both lists are known, but
	 * the intersecting node is unknown. Also, no.of nodes in each list before
	 * they intersect aer unknown. List1 may have n nodes & List2 may have m
	 * nodes where m & n may be m=n,m<n,m>n Bruteforce approach: Compare each
	 * nodes from list1 with list2 i.e Time complexity: O(mn) Space Complexity:
	 * O(1)
	 */
	public ListNode getIntersectionNodeMethod1(ListNode node1, ListNode node2) {

		ListNode intersectNode = null;

		while (node1 != null) {
			while (node2 != null) {
				if (node1.getId() == node2.getId()) {
					intersectNode = node1;
					break;
				}
				node2 = node2.getNext();
			}
			if (intersectNode != null)
				break;
			node1 = node1.getNext();
		}

		return intersectNode;
	}

	/**
	 * Problem-18 Sorting technique - Not possible Take first list & keep in
	 * some array, sort them Take second list & keep in some array, sort them
	 * Use two indexes one for first array & other for second Start comparing
	 * values at the indexes & increment the index whichever is having lower. At
	 * any point, if two index are same, then that node would be returned Time
	 * Complexity: Time for sorting O(mlogm) + O(nlogn) + Time for scanning
	 * O(m+n) Space Complexity: O(1)
	 */

	/**
	 * Problem-19 Hashing technique Time Complexity: O(m) + O(n) Space
	 * Complexity: O(m) or O(n)
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	public ListNode getIntersectionNodeMethod2(ListNode node1, ListNode node2) {

		ListNode intersectNode = null;

		Map<Long, ListNode> map = new HashMap<Long, ListNode>();

		while (node1 != null) {
			map.put(node1.getId(), node1);
			node1 = node1.getNext();
		}

		while (node2 != null) {
			if (map.get(node2.getId()) != null) {
				intersectNode = node2;
				break;
			}
			node2 = node2.getNext();
		}

		return intersectNode;
	}

	/**
	 * Problem-20 Solve using stack Time Complexity: O(m+n) Space Complexity:
	 * O(m+n).
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	// public ListNode getIntersectionNodeMethod3(ListNode node1, ListNode
	// node2) {
	//
	// ListNode intersectNode = null;
	//
	// LLStack stack1 = new LLStack();
	// LLStack stack2 = new LLStack();
	//
	// while (node1 != null) {
	// stack1.push(node1);
	// node1 = node1.getNext();
	// }
	//
	// while (node2 != null) {
	// stack2.push(node2);
	// node2 = node2.getNext();
	// }
	//
	// while (true) {
	// ListNode node11 = (ListNode) stack1.pop();
	// ListNode node22 = (ListNode) stack2.pop();
	// if (node11.getId() == node22.getId()) {
	// intersectNode = node11;
	// } else {
	// break;
	// }
	// }
	// return intersectNode;
	// }

	/**
	 * Problem-21: Find the first repeating number approach in an array
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	public ListNode getIntersectionNodeMethod4(ListNode node1, ListNode node2) {

		ListNode intersectNode = null;

		return intersectNode;

	}

	/**
	 * Problem-22:
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	public ListNode getIntersectionNodeMethod5(ListNode node1, ListNode node2) {

		ListNode intersectNode = null;

		return intersectNode;

	}

	/**
	 * Problem-23:
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	public ListNode getIntersectionNodeMethod6(ListNode node1, ListNode node2) {
		ListNode intersectNode = null;

		return intersectNode;
	}

	/**
	 * Problem-24
	 * 
	 * @param node
	 * @return
	 */
	public ListNode getMiddleOfLinkedListMethod1(ListNode node) {

		return null;
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	public ListNode getMiddleOfLinkedListMethod2(ListNode node) {

		return null;
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	public ListNode getMiddleOfLinkedListMethod3(ListNode node) {

		return null;
	}

	/**
	 * Problem-27
	 * 
	 * @param node
	 * @return
	 */
	public ListNode getMiddleOfLinkedListMethod4(ListNode node) {

		return null;
	}

	/**
	 * Problem-28
	 * 
	 * @param head
	 */
	public void printListFromEnd(ListNode head) {

	}

	/**
	 * Problem-29
	 * 
	 * @param head
	 * @return
	 */
	public boolean isListEven(ListNode head) {

		return false;
	}

	/**
	 * Problem-30
	 * 
	 * @param head
	 * @return
	 */
	public ListNode getElementBeforeKth(ListNode head) {

		return null;
	}

	/**
	 * Problem-31
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	public ListNode mergeSortedList(ListNode node1, ListNode node2) {

		return null;
	}

	/**
	 * Problem-32
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseInPairs(ListNode head) {

		return null;
	}

	/**
	 * Problem-33 will be implemented in Tree chapter
	 */
	public void convertBinaryTreeToDLL() {

	}

	/**
	 * Problem-34 will be implemented in sorting chapter
	 */
	public void sortLinkedList() {

	}

	/**
	 * Problem-35 LinkedList concatenation - which one gives complexity O(1) SLL
	 * DLL CLL - CLL as SLL & DLL need to traverse the first list till end &
	 * append the second list. in CLL, we don't have to traverse
	 */

	/**
	 * Problem-36 Split a CLL into two equal parts. If the number of nodes are
	 * odd, then make first list one node extra than the second list
	 * 
	 * @param node
	 */
	public void splitCLL(ListNode node) {

	}
	
	/**
	 * Problem-37 Check if the list is palindrome
	 * @param node
	 * @return
	 */
	public boolean isPalindrome(ListNode node){
		
		return false;
	}

	/**
	 * 
	 * Problem-38 Exchange adjacement elements in link list
	 * @param node
	 */
	public void exchangeAdjacentNodes(ListNode node){
		
	}
	
	
	/**
	 * 
	 * Problem-39 Reverse block of K nodes
	 * @param node
	 * @param K
	 */
	public void reverseBlockOfKNodes(ListNode node, int K){
		
	}
	
	/**
	 * Problem-40 Is it possible to get O(1) access time to linked list
	 */
	
	
	/** 
	 */
	public ListNode getJosephusPosition(int N, int M){
		
		return null;
	}
}
