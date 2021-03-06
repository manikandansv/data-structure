package in.sv.datastructure.linkedlist.crud;

import in.sv.datastructure.linkedlist.ListNode;

public class SingleLinkedList {

	/**
	 * Time Complexity : 
	 * Space Complexity: 
	 * @param node
	 * @return
	 */
	public int sllLength(ListNode node){
		int count = 0;
		if (node != null){
			while (node != null){
				count++;
				node = node.getNext();
			}
			System.out.println("Length:" + count);
		}
		return count;
	}
	
	/**
	 * Time Complexity:
	 * Space Complexity:
	 * @param head
	 * @param nodeToInsert
	 * @param position
	 * @return
	 */
	public ListNode insertInSLL(ListNode head, ListNode nodeToInsert, int position){
		
		if (head == null)
			return nodeToInsert;
		int length = this.sllLength(head);
		if (position > length+1 || position < 1 ){
			System.out.println("Invalid position");
			return head;
		}
		
		if (position == 1){
			nodeToInsert.setNext(head);
			return nodeToInsert;
		}else{
			ListNode currentNode = head;
			int i=1;
			while (i < position-1){
				currentNode = currentNode.getNext();
				i++;			
			}
			nodeToInsert.setNext(currentNode.getNext());
			currentNode.setNext(nodeToInsert);
			return head;
		}
	}
	
	/**
	 * Time Complexity:
	 * Space Complexity:
	 * @param head
	 * @param position
	 * @return
	 */
	public ListNode deleteInSLL(ListNode head, int position){
		
		int length = this.sllLength(head);
		
		if (position > length || position < 1){
			System.out.println("Invalid");
			return head;
		}
		if (position == 1){
			ListNode currentNode = head.getNext();
			head = null;
			return currentNode;
		}else{
			int count = 1;
			ListNode previousNode = head;
			while (count == position-1){
				previousNode = previousNode.getNext();
				count ++;
			}
			ListNode currentNode = previousNode.getNext();
			previousNode.setNext(currentNode.getNext());
			currentNode = null;
		}
		return head;		
	}
	
	/**
	 * Time Complexity:
	 * Space Complexity:
	 * @param head
	 * @param position
	 * @return
	 */
	public ListNode getSLLNode(ListNode head, int position){
		
		if (head == null)return null;
		
		int count = 0;
		
		ListNode node = head;
		
		while (count < position){
			count++;
			node = head.getNext();
		}
		return node;
		
	}
	
}
