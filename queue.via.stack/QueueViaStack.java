public class QueueViaStack {
	public static void main(String[] args) {
		QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		System.out.println("Removed element from queue: " + queue.remove());
		queue.add(5);
		queue.add(6);
		System.out.println("Removed element from queue: " + queue.remove());
		System.out.println("Removed element from queue: " + queue.remove());
		queue.add(7);
		queue.add(8);
		System.out.println("Removed element from queue: " + queue.remove());
		System.out.println("Removed element from queue: " + queue.remove());
		System.out.println("Removed element from queue: " + queue.remove());
		System.out.println("Removed element from queue: " + queue.remove());
		queue.add(9);
		queue.add(10);
		System.out.println("Removed element from queue: " + queue.remove());
		System.out.println("Removed element from queue: " + queue.remove());
	}
}

class QueueWithTwoStacks<T> {
	
	Stack<T> addStack;
	Stack<T> removeStack;
	
	public QueueWithTwoStacks() {
		this.addStack = new Stack<>();
		this.removeStack = new Stack<>();
	}
	
	public void add(T data) {
		if(addStack.isEmpty())
			transferData(removeStack, addStack);
		addStack.push(data);
	}
	
	public T remove() {
		if(removeStack.isEmpty())
			transferData(addStack, removeStack);
		return removeStack.pop();
	}
	
	private void transferData(Stack<T> stack, Stack<T> emptyStack) {
		while(!stack.isEmpty()) {
			emptyStack.push(stack.pop());
		}
	}
}

class Stack<T> {
	
	StackNode<T> top;
	
	void push(T data) {
		StackNode<T> newTop = new StackNode<>(data);
		newTop.next = top;
		top = newTop;
	}
	
	T pop() {
		StackNode<T> toBePopped = top;
		top = top.next;
		return toBePopped.data;
	}
	
	boolean isEmpty() {
		return top == null;
	}
	
	void print() {
		StackNode<T> temp = top;
		while(temp != null) {
			System.out.print(temp.data + "<==");
			temp = temp.next;
		}
		System.out.println();
	}
}

class StackNode<T> {
	
	T data;
	StackNode<T> next;
	
	StackNode(T data) {
		this.data = data;
		this.next = null;
	}
}