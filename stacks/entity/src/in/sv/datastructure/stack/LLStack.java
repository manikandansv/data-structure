package in.sv.datastructure.stack;

import java.util.EmptyStackException;

import in.sv.datastructure.linkedlist.ListNode;

public class LLStack {

	private ListNode headNode;
	
	public LLStack(){
		this.headNode = new ListNode(null);
	}
	
	public void push(Object data){
		if (headNode == null){
			headNode= new ListNode(data); 
		}
		else if(headNode.getData() == null){
			headNode.setData(null);
		}
		else{
			ListNode listNode = new ListNode(data);
			listNode.setNext(headNode);
			headNode = listNode;
		}
	}
	
	public Object top(){
		if (headNode == null){
			return null;
		}else{
			return headNode.getData();
		}
	}
	
	public Object pop(){
		if (headNode == null){
			throw new EmptyStackException();
		}else{
			Object data = headNode.getData();
			headNode = headNode.getNext();
			return data;
		}
	}
	
	public boolean isEmpty(){
		if (headNode == null){
			return true;
		}else{
			return false;
		}			
	}
	
	public void deleteStack(){
		headNode=null;
	}
	
}
