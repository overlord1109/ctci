public class SumLists {
	public static void main(String[] args) {
		Integer[] arr1 = {2,6,4,6};
		LinkedList<Integer> list1 = createLinkedList(arr1);
		Integer[] arr2 = {5,9,6,6};
		LinkedList<Integer> list2 = createLinkedList(arr2);
		
		System.out.println("Sum is " + sumLists(list1, list2));
	}
	
	public static int sumLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		Node<Integer> first = list1.head;
		Node<Integer> second = list2.head;
		
		int sum = 0;
		int carry = 0;
		int tens = 1;
		
		while(first!= null && second!=null) {
			sum += tens * ((first.data + second.data + carry) % 10);
			carry = (first.data + second.data + carry) / 10;
			
			first = first.next;
			second = second.next;
			tens *= 10;
		}
		
		while(first != null) {
			sum += tens * ((first.data + carry) % 10);
			carry = (first.data + carry) / 10;
			
			first = first.next;
			tens *= 10;
		}
		
		while(second != null) {
			sum += tens * ((second.data + carry) % 10);
			carry = (second.data + carry) / 10;
			
			second = second.next;
			tens *= 10;
		}
		
		sum += carry * tens;
		
		return sum;
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