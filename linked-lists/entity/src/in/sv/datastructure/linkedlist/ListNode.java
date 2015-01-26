package in.sv.datastructure.linkedlist;

public class ListNode {
	
	private Long id;

	private Object data;
	
	private ListNode next;

	public ListNode(Object object) {
		this.data = object;
		this.next = null;
	}

	public ListNode() {
		// TODO Auto-generated constructor stub
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
