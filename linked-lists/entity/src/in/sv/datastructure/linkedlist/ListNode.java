package in.sv.datastructure.linkedlist;

public class ListNode {

	private Object data;
	
	private ListNode next;

	public ListNode(Object object) {
		this.data = object;
		this.next = null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
	
	
}
