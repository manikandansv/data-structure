
package in.sv.datastructure.queue;

import in.sv.datastructure.linkedlist.ListNode;

public class LLQueue {

	private ListNode frontNode;
	
	private ListNode rearNode;
	
	public LLQueue(){
		frontNode = null;
		rearNode = null;
	}
	
	public static LLQueue createQueue(){
		return new LLQueue();
	}
	
	public boolean isEmpty(){
		return (frontNode == null);
	}
	
	public void enQueue(Object data){
		ListNode newNode = new ListNode(data);
		if (rearNode != null){
			rearNode.setNext(newNode);
		}
		rearNode = newNode;
		if (frontNode == null)
			frontNode = rearNode;
	}
	
	public Object deQueue(){
		Object data = null;
		
		if (isEmpty())
			System.out.println("Queue empty");
		else{
			data = frontNode.getData();
			frontNode = frontNode.getNext();
		}
		return data;
	}
	
}
