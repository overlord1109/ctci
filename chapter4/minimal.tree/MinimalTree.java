public class MinimalTree {
	public static void main(String[] args) {
		int[] array = new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		
		TreeNode root = createMinimalTree(array, 0, array.length - 1);
		
		System.out.println("Inorder print: ");
		inorderPrint(root);
		System.out.println();
		
		System.out.println("Preorder print: ");
		preorderPrint(root);
		System.out.println();
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
	
	static void inorderPrint(TreeNode root) {
		if(root != null) {
			inorderPrint(root.left);
			System.out.print(root.data + " ");
			inorderPrint(root.right);
		}
	}
	
	static void preorderPrint(TreeNode root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorderPrint(root.left);
			preorderPrint(root.right);
		}
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