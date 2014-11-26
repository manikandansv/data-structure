package in.sv.datastructure.queue;

public class DynArrayQueue {

	private int front;
	
	private int rear;
	
	private int capacity;
	
	private Integer[] array;
	
	private DynArrayQueue(){
		front = -1;
		rear = -1;
		capacity = 1;
		array = new Integer[1];
	}
	
	public DynArrayQueue createDynArrayQueue(){
		return new DynArrayQueue();
	}
	
	public boolean isEmpty(){
		return (front == -1);
	}

	public boolean isFull(){
		return (rear+1)%capacity == front;
	}
	
	public int getQueueSize(){
		if (front == -1)
			return 0;
		int size = (capacity-front+rear+1)%capacity;
		if (size == 0)
			return capacity;
		else
			return size;
	}
	
	public void resizeQueue(){
		int initCapacity = capacity;
		capacity*= 2;
		Integer[] oldArray = array;
		array = new Integer[capacity];
		for (int i=0;i<oldArray.length;i++){
			array[i] = oldArray[i]; 
		}
		if(rear<front){
			for (int i=0;i<front;i++){
				array[i+initCapacity] = this.array[i];
				array[i] = null;
			}
			rear = rear + initCapacity;
		}
		
	}
	
	public void enQueue(int data){
		if (isFull()){
			resizeQueue();
		}
		rear = (rear+1)%capacity;
		array[rear] = data;
		if (front == -1) front=rear;
	}
	
	public Integer deQueue(){
		Integer data = null;
		if (isEmpty()){
			System.out.println("Queue Empty");
		}
		else{
			data = array[front];
			if (front == rear)front = rear - 1;
			else front = (front+1)%capacity;
		}
		return data;
	}
}
