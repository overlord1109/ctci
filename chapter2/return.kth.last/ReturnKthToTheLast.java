import java.util.*;

public class ReturnKthToTheLast {
	public static void main(String[] args) {
		Integer[] arr = {1,2,4,5,16,3,1,2};
		LinkedList<Integer> list = createLinkedList(arr);
		printList(list);
		int k = 4;
		System.out.println("Data of " + k + "th to the last element is: " + returnKthToTheLast(list, k).data);
	}
	
	public static <T> Node<T> returnKthToTheLast(LinkedList<T> list, int k) {
		if(k < 1)
			return null;
		
		List<Node<T>> seen = new ArrayList<>();
		
		Node<T> current = list.head;
		
		if(current == null)
			return null;
		
		for (int i = 1; i < k; i++) {
			if(current != null)
				current = current.next;
			else
				return null;
		}
		
		Node<T> lateStarter = list.head;
		
		while(current.next != null) {
			current = current.next;
			lateStarter = lateStarter.next;
		}
		
		return lateStarter;
		
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