import java.util.Stack;

public class Palindrome {
	public static void main(String[] args) {
		Integer[] arr = {9, 7, 8, 7};
		LinkedList<Integer> list = createLinkedList(arr);
		System.out.println(isPalindrome(list));
	}
	
	public static <T> boolean isPalindrome(LinkedList<T> list) {
		Stack<T> stack = new Stack<>();
		
		Node<T> slow = list.head, fast = list.head;
		
		while(fast.next != null && fast.next.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = slow.next;
		
		while(!stack.empty() && slow != null) {
			if(slow.data == stack.pop()) 
				slow = slow.next;
			else
				return false;
		}
		
		if(!stack.empty() || slow != null)
			return false;
		
		return true;
	}
	
	public static <T> LinkedList<T> createLinkedList(T[] array) {
		if(array.length == 0) {
			return null;
		}
		Node<T> current = new Node<>(array[0]);
		LinkedList<T> list = new LinkedList<>(current);
		
		for(int i = 1; i < array.length; i++) {
			Node<T> n = new Node<>(array[i]);
			current.next = n;
			current = n;
		}
		
		return list;
	}
	
	public static <T> void printList(LinkedList<T> list) {
		if(list != null) {
			Node<T> current = list.head;
			
			while(current != null) {
				System.out.print((current.data) + "->");
				current = current.next;
			}
		}
		System.out.println("null");
	}
	
}

class LinkedList<T> {
	Node<T> head;
	
	public LinkedList(Node<T> head) {
		this.head = head;
	}
}

class Node<T> {
	T data;
	Node<T> next = null;
	
	public Node(T data) {
		this.data = data;
	}
}