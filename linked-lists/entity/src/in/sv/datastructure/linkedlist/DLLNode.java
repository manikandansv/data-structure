package in.sv.datastructure.linkedlist;

public class DLLNode {
	
	private Object data;
	
	private DLLNode next;
	
	private DLLNode previous;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	public DLLNode getPrevious() {
		return previous;
	}

	public void setPrevious(DLLNode previous) {
		this.previous = previous;
	}
	
}
