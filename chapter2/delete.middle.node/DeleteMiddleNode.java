public class DeleteMiddleNode {
	public static void main(String[] args) {
		Integer[] arr = {1,2,4,5,16,3,1,2};
		LinkedList<Integer> list = createLinkedList(arr);
		printList(list);
		deleteMiddleNode(list.head.next.next.next.next);
		printList(list);
	}
	
	public static <T> void deleteMiddleNode(Node<T> middle) {
		Node<T> current = middle;
		current.data = current.next.data;
		current.next = current.next.next;
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