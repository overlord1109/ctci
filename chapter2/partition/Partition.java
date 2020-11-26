public class Partition {
	public static void main(String[] args) {
		Integer[] arr = {3,5,8,5,10,2,7,11};
		LinkedList<Integer> list = createLinkedList(arr);
		printList(list);
		partition(list, 8);
		printList(list);
	}
	
	public static <T extends Comparable<T>> void partition(LinkedList<T> list, T x) {
		Node<T> current = list.head;
		Node<T> prev = null;
		
		while(current != null && current.data.compareTo(x) < 0) {
			prev = current;
			current = current.next;
		}
		
		while(current != null) {
			if(current.data.compareTo(x) < 0) {
				prev.next = current.next;
				current.next = list.head;
				list.head = current;
				current = prev.next;
			} else {
				prev = current;
				current = current.next;
			}
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