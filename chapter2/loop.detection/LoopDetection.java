public class LoopDetection {
	public static void main(String[] args) {
		Integer[] arr = {3,5,8,10,2};
		LinkedList<Integer> list = createLinkedList(arr);
		list.head.next.next.next.next = list.head.next;
		
		Node<Integer> loopStart = detectLoop(list);
		
		System.out.println("Loop starts at " + (loopStart == null ? null : loopStart.data));
	}
	
	public static <T> Node<T> detectLoop(LinkedList<T> list) {
		Node<T> slow = list.head, fast = list.head;
		
		while(slow != null && fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			
			System.out.println("Slow: " + slow.data + ", Fast: " + fast.data);
			
			if(slow == fast)
				break;
			
		}
		
		if(slow == null || fast == null || fast.next == null)
			return null;	
		
		slow = list.head;
		
		while(true) {
			System.out.println("Slow: " + slow.data + ", Fast: " + fast.data);
			if(slow == fast)
				return slow;
			slow = slow.next;
			fast = fast.next;
		}
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