public class StackMin {
	public static void main(String[] args) {
		MinStack<Integer> stack  = new MinStack<>();
		stack.push(3);
		stack.print();
		System.out.println("Min is " + stack.min());
		stack.push(4);
		stack.print();
		stack.push(5);
		stack.print();
		stack.push(0);
		stack.print();
		System.out.println("Min is " + stack.min());
		stack.push(1);
		stack.print();
		System.out.println("Min is " + stack.min());
		stack.pop();
		stack.print();
		System.out.println("Min is " + stack.min());
		stack.push(2);
		stack.print();
		System.out.println("Min is " + stack.min());
		stack.pop();
		stack.print();
		System.out.println("Min is " + stack.min());
	}
}

class MinStack<T extends Comparable<T>> {
	
	MinStackNode<T> top;
	
	void push(T data) {
		MinStackNode<T> newTop = new MinStackNode<>(data);
		newTop.minYet = top == null ? newTop : (newTop.data.compareTo(top.data) < 0 ? newTop : top.minYet);
		newTop.next = top;
		top = newTop;
	}
	
	T pop() {
		MinStackNode<T> toBePopped = top;
		top = top.next;
		return toBePopped.data;
	}
	
	T min() {
		return top.minYet.data;
	}
	
	void print() {
		MinStackNode<T> temp = top;
		while(temp != null) {
			System.out.print(temp.data + "<==");
			temp = temp.next;
		}
		System.out.println();
	}
}

class MinStackNode<T extends Comparable<T>> {
	
	T data;
	MinStackNode<T> next;
	MinStackNode<T> minYet;
	
	MinStackNode(T data) {
		this.data = data;
		this.next = null;
		this.minYet = null;
	}
}