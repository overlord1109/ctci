public class Intersection {
	public static void main(String[] args) {
		Integer[] arr1 = {9, 7, 8, 7};
		LinkedList<Integer> list1 = createLinkedList(arr1);
		
		Integer[] arr2 = {1};
		LinkedList<Integer> list2 = createLinkedList(arr2);
		list2.head.next = list1.head.next.next;
		
		printList(list1);
		printList(list2);
		
		Node<Integer> intersection = getIntersection(list1, list2);
		
		System.out.println("Intersecting node is: " + (intersection == null ? null : intersection.data));
	}
	
	public static <T> Node<T> getIntersection(LinkedList<T> list1, LinkedList<T> list2) {
		int len1 = 0, len2 = 0;
		Node<T> curr1 = list1.head, curr2 = list2.head;
		
		while(curr1.next != null) {
			len1++;
			curr1 = curr1.next;
		}
		
		while(curr2.next != null) {
			len2++;
			curr2 = curr2.next;
		}
		
		if(curr1 != curr2)
			return null;
		
		Node<T> shorter = len1 > len2 ? list2.head : list1.head;
		Node<T> longer = len1 > len2 ? list1.head : list2.head;
		
		for(int i = 0; i < Math.abs(len1 - len2); i++) {
			longer = longer.next;
		}
		
		while(shorter != null && longer != null) {
			if(shorter == longer)
				return longer;
			
			shorter = shorter.next;
			longer = longer.next;
		}
		
		return null;
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