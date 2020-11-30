public class SortStack {
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>();
		stack.push(3);
		stack.push(4);
		stack.push(2);
		stack.push(6);
		stack.push(5);
		stack.push(1);
		stack.push(7);
		stack.print();
		stack = sort(stack);
		stack.print();
	}
	
	public static <Integer> MyStack<Integer> sort(MyStack<Integer> stack) {
		MyStack<Integer> sortedStack = new MyStack<>();
		
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			int poppedCount = 0;
			while(!sortedStack.isEmpty() && sortedStack.peek() <= temp) {
				stack.push(sortedStack.pop());
				poppedCount++;
			}
			sortedStack.push(temp);
			while(poppedCount > 0) {
				sortedStack.push(stack.pop());
				poppedCount--;
			}
		}
		return sortedStack;
	}
}

class MyStack<Integer> {
	StackNode<Integer> top;
	
	void push(int data) {
		StackNode<Integer> newTop = new StackNode<>(data);
		newTop.next = top;
		top = newTop;
	}
	
	int pop() {
		StackNode<Integer> toBePopped = top;
		top = top.next;
		return toBePopped.data;
	}
	
	int peek() {
		return top.data;
	}
	
	boolean isEmpty() {
		return top == null;
	}
	
	void print() {
		StackNode<Integer> temp = top;
		System.out.println("======= S T A C K =====");
		while(temp != null) {
			System.out.print("| " + temp.data + " |\n_____\n");
			temp = temp.next;
		}
		System.out.println("========================");
	}
}

class StackNode<Integer> {
	
	int data;
	StackNode<Integer> next;
	
	StackNode(int data) {
		this.data = data;
		this.next = null;
	}
}