package in.sv.datastructure.linkedlist.problems;

import in.sv.datastructure.linkedlist.ListNode;
import in.sv.datastructure.linkedlist.crud.SingleLinkedList;

import java.util.HashMap;
import java.util.Map;

public class LinkedListProblems {

	
	public void stackByLL(){
		/**
		 * Stack Implementation using Linkedlist. Refer LLStack.java
		 */
	}
	
	/**
	 * Problem -2: Find nth node from end of linked list - BruteForce approach
	 * 1. Start with first node, 
	 * 2. count number of nodes after that
	 * 3. If count(n) < n-1, return error saying less number of nodes
	 * 4. If count(n> > n-1, goto next node
	 * 5.  Repeat 2 until count(n) = n-1 
	 * Time Complexity: O(n2) - Scanning remaining nodes for each node
	 * Space Complexity: O(1)
	 */
	public ListNode findNthNodeFromEndMethod1(ListNode node, int position){
	
		SingleLinkedList sll = new SingleLinkedList();
		
		ListNode resultNode = null;
		
		while(true){
			
			int length = sll.sllLength(node);
			
			int lengthExcl = length - 1;
			
			if (lengthExcl == position-1){
				resultNode = node;
				break;
			}
			else if (lengthExcl > position - 1){
				node = node.getNext();
			}
			else{
				System.out.println("Invalid position");
				break;
			}
		}
		
		return resultNode;
		
	}
	
	/**
	 * Problem-3: Improve the complexity of Problem-2
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * @param node
	 * @param position
	 * @return
	 */
	public ListNode findNthNodeFromEndMethod2(ListNode node, int position){
		
		ListNode resultNode = null;
		
		Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
		
		int i = 0;
		
		/** Below while block is O(n) */
		while (node != null){
			
			i++;
			
			map.put(i, node);
			
			node = node.getNext();
			
		}
		
		resultNode = map.get(i-position);
		
		return resultNode;
	}
	
}
