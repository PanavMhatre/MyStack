import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack {
	int[] stack;
	int size;
	int capacity;

	public MyStack() {
		this(4);
	}
	public MyStack(int initCap) {
		stack = new int[initCap];
		size=0;
		capacity = initCap;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	public Integer peek() {
		if(size!=0)
			return stack[size-1];
		throw new EmptyStackException();
	}
	public Integer pop() {
		if(size!=0) {
			Integer val = stack[size-1];
			size--;
			return val;
		}
		throw new EmptyStackException();
	}
	public void push(Integer item) {
		if(stack.length==size) {
			doubleCapacity();
		}
		stack[size]=item;
		size++;
	}
	private void doubleCapacity() {
		int[] newStackArray = new int[capacity*2];
		for(int i =0; i<size;i++) {
			newStackArray[i] = stack[i];
		}
		capacity = capacity * 2;
		stack = newStackArray;
		
	}
	
	
	@Override
	public String toString() {
		String toString = "";
		for(int i=0;i<size;i++) {
			toString += stack[i] + "/n";
		}
		return toString;
	}
	
}

