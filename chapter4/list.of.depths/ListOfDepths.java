public class ListOfDepths {
	
	static int requiredDepth;
	static LinkedList list;
	
	public static void main(String[] args) {
		int[] array = new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		
		TreeNode root = createMinimalTree(array, 0, array.length - 1);
		
		LinkedList listOfDepths = listOfDepths(root, 2);
		printList(listOfDepths);
	}
	
	static LinkedList listOfDepths(TreeNode root, int depth) {
		requiredDepth = depth;
		list = new LinkedList();
		recursiveListOfDepths(root, 0);
		return list;
	}
	
	static void recursiveListOfDepths(TreeNode root, int currDepth) {
		if(root != null) {
			recursiveListOfDepths(root.left, currDepth + 1);
			if(currDepth == requiredDepth) {
				list.add(root);
			}
			recursiveListOfDepths(root.right, currDepth + 1);
		}
	}
	
	static TreeNode createMinimalTree(int[] arr, int low, int high) {
		if(low == high) {
			return new TreeNode(arr[low]);
		} else if(low + 1 == high) {
			TreeNode root = new TreeNode(arr[high]);
			TreeNode leftNode = new TreeNode(arr[low]);
			root.left = leftNode;
			return root;
		}
		
		int mid = (low + high + 1) / 2 ;
		
		TreeNode root = new TreeNode(arr[mid]);
		TreeNode leftNode = createMinimalTree(arr, low, mid - 1);
		TreeNode rightNode = createMinimalTree(arr, mid + 1, high);
		
		root.left = leftNode;
		root.right = rightNode;

		return root;
	}
	
	public static void printList(LinkedList list) {
		if(list != null) {
			ListNode current = list.head;
			
			while(current != null) {
				System.out.print((current.data.data) + "->");
				current = current.next;
			}
		}
		System.out.println("null");
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class LinkedList {
	ListNode head;
	ListNode last;
	
	void add(TreeNode data) {
		if(head == null) {
			head = new ListNode(data);
			last = head;
		} else {
			ListNode temp = new ListNode(data);
			last.next = temp;
			last = temp;
		}
	}
}

class ListNode {
	TreeNode data;
	ListNode next;
	
	public ListNode(TreeNode data) {
		this.data = data;
		this.next = null;
	}
}