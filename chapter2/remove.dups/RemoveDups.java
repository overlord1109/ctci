import java.util.*;

public class RemoveDups {
	public static void main(String[] args) {
		Integer[] arr = {1,2,1,1,11,1,1,1,1,2};
		LinkedList<Integer> list = createLinkedList(arr);
		printList(list);
		removeDupsWithoutBuffer(list);
		printList(list);
	}
	
	public static <T> void removeDupsHashed(LinkedList<T> list) {	//O (n) time, O (k) space where k is number of distinct elements in the original linked list
		Set<T> seenData = new HashSet<>();
		
		if(list == null)
			return;
		
		Node<T> current = list.head;
		
		if(current == null || current.next == null) {
			return;
		}
		
		seenData.add(current.data);
		
		while(current.next.next != null) {
			if(seenData.contains(current.next.data)) {
				while(current.next.next != null && seenData.contains(current.next.data))	//consecutively delete without incrementing current
					deleteNext(current);
			} else {
				seenData.add(current.next.data);
			}
			if(current.next.next != null)
				current = current.next;
		}
		
		if(seenData.contains(current.next.data)) {
			deleteNext(current);
		}
	}
	
	public static <T> void removeDupsWithoutBuffer(LinkedList<T> list) {	//O (n^2) time, constant space
		if(list == null)
			return;
		
		Node<T> current = list.head;
		
		if(current == null || current.next == null) {
			return;
		}
		
		while(current.next != null) {
			Node<T> n = current;
			
			while(n.next != null) {
				while(n.next != null && n.next.data == current.data) {		//consecutively delete without incrementing n
					deleteNext(n);
				}
				if(n.next != null)
					n = n.next;
			}
			current = current.next;
		}
	}
	
	public static <T> void deleteNext(Node<T> prev) {
		if(prev == null || prev.next == null)
			throw new IllegalArgumentException("Prev or its following element cannot be null");
			
		prev.next = prev.next.next;
	}
	
	// util methods below
	
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