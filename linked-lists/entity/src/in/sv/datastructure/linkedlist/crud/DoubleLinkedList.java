package in.sv.datastructure.linkedlist.crud;

import in.sv.datastructure.linkedlist.DLLNode;

public class DoubleLinkedList {

	public DLLNode insertDLLNode(DLLNode head, DLLNode nodeToInsert, int position){
		
		if (head == null){
			return nodeToInsert;
		}
		
		int length = getDLLLength(head);
		
		if (position > length +1 || position < 0){
			System.out.println("Invalid position");
			return head;
		}
		
		if (position == 1){
			nodeToInsert.setNext(head);
			head.setPrevious(nodeToInsert);
		}
		else{
			DLLNode previousNode = this.getDLLNode(head, position-1); 
						
			DLLNode nodeToReplace = previousNode.getNext();
			
			nodeToReplace.setPrevious(nodeToInsert);
			
			nodeToInsert.setNext(nodeToReplace);
			
			previousNode.setNext(nodeToInsert);
			
			nodeToInsert.setPrevious(previousNode);
						
		}
		
		return nodeToInsert;
		
	}
	
	public DLLNode deleteNode(DLLNode head, int position){
		
		if (head == null){
			System.out.println("Invalid List");
			return head;
		}
		int length = getDLLLength(head);
		if (position > length+1 || position < 1){
			System.out.println("Invalid Position");
			return head;
		}
		if (position == 1){
			head.getNext().setPrevious(null);
			head = head.getNext();			
		}
		else{
			DLLNode previousNode = getDLLNode(head, position-1);
			DLLNode nodeToDelete = previousNode.getNext();
			DLLNode nextNode = nodeToDelete.getNext();
			
			previousNode.setNext(nextNode);
			nextNode.setPrevious(previousNode);
			nodeToDelete = null;
			
		}
		return head;
		
	}
	
	public Integer getDLLLength(DLLNode head){
		int count = 0;
		if (head == null)
			return count;
		DLLNode node = head;
		while (node != null){
			count++;
			node = node.getNext();
		}
		
		return count;
		
	}
	
public DLLNode getDLLNode(DLLNode head, int position){
		
		if (head == null)return null;
		
		int count = 0;
		
		DLLNode node = head;
		
		while (count < position){
			count++;
			node = head.getNext();
		}
		return node;
		
	}
	
}
