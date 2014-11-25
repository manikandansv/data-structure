package in.sv.datastructure.stack;

public class DynArrayStack {

	private int top;
	
	private int capacity;
	
	private int[] array;
	
	public DynArrayStack(){
		capacity = 1;
		array = new int[capacity];
		top = -1;
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isStackFull(){
		return (top==capacity-1);
	}
	
	public void push(int data){
		if (isStackFull()){
			System.out.println("Stack full");
		}else{
			array[top++] = data;
		}
	}
	
	public int pop(){
		if (isEmpty()){
			doubleStack();
			return 0;
		}
		else{
			return array[top--];
		}
	}
	
	private void doubleStack() {
		int newArray[] = new int[capacity*2];
		capacity = capacity * 2;
		System.arraycopy(array, 0, newArray, 0, capacity);
		array = newArray;
		
	}

	public void deleteStack(){
		top = -1;
	}
	
}
