import java.util.*;

public class StackOfPlates {
	public static void main(String[] args) {
		Stacks<Integer> stacks = new Stacks<>(3);
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		stacks.push(4);
		stacks.print();
		System.out.println("Popped element " + stacks.pop());
		stacks.print();
		System.out.println("Popped element " + stacks.pop());
		stacks.print();
		stacks.push(5);
		stacks.push(6);
		stacks.push(7);
		stacks.push(8);
		stacks.push(9);
		stacks.print();
		System.out.println("Popped element " + stacks.popAt(1) + " from stack#" + 1);
		System.out.println("Popped element " + stacks.popAt(1) + " from stack#" + 1);
		System.out.println("Popped element " + stacks.popAt(1) + " from stack#" + 1);
		stacks.print();
		System.out.println("Popped element " + stacks.popAt(2) + " from stack#" + 2);
		stacks.print();
		stacks.push(10);
		stacks.push(11);
		stacks.print();
	}
}

class Stacks<T> {
	
	List<List<T>> stacks;
	List<Integer> stackTopIndices;
	int lastStackIndex;
	int capacity;
	
	public Stacks(int capacity) {
		this.capacity = capacity;
		this.stacks = new ArrayList<>();
		this.stackTopIndices = new ArrayList<>();
		this.lastStackIndex = -1;
	}
	
	void push(T data) {
		if(lastStackIndex == -1 || isStackFull(lastStackIndex)) {
			List<T> newStack = new ArrayList<T>(capacity);
			newStack.add(data);
			lastStackIndex++;
			if(stacks.size() == lastStackIndex) {
				stackTopIndices.add(0);
				stacks.add(newStack);
			} else {
				stackTopIndices.set(lastStackIndex, 0);
				stacks.set(lastStackIndex, newStack);
			}
		} else {
			int lastStackTop = stackTopIndices.get(lastStackIndex);
			stackTopIndices.set(lastStackIndex, lastStackTop + 1);
			stacks.get(lastStackIndex).add(data);
		}
	}
	
	T pop() {
		int lastStackTop = stackTopIndices.get(lastStackIndex);
		T retval = stacks.get(lastStackIndex).get(lastStackTop);
		if(lastStackTop == 0) {
			while(stackTopIndices.get(lastStackIndex) <= 0)
				lastStackIndex--;
		} else {
			stackTopIndices.set(lastStackIndex, lastStackTop - 1);
		}
		return retval;
	}
	
	T popAt(int stackIndex) {
		if(isStackEmpty(stackIndex))
			throw new RuntimeException("Stack#" + stackIndex + " is empty");
		if(stackIndex == lastStackIndex)
			return pop();
		
		int lastStackTop = stackTopIndices.get(stackIndex);
		stackTopIndices.set(stackIndex, lastStackTop - 1);
		return stacks.get(stackIndex).get(lastStackTop);
	}
	
	void print() {
		System.out.println("---------------------------");
		for(int i = 0; i <= lastStackIndex; i++) {
			System.out.print("Stack #" + (i + 1) + "(top at: " + stackTopIndices.get(i) +"): ");
			for(int j = 0; j <= stackTopIndices.get(i); j++) {
				System.out.print(stacks.get(i).get(j) + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}
	
	boolean isStackEmpty(int stackIndex) {
		return stackTopIndices.get(stackIndex) == -1 ? true : false;
	}
	
	boolean isStackFull(int stackIndex) {
		return stackTopIndices.get(stackIndex) == (capacity - 1) ? true : false;
	}
}