public class ValidateBst {
	public static void main(String [] args) {
		int[] array = new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		TreeNode root = createMinimalTree(array, 0, array.length - 1);
		System.out.println("Tree is " + (isBst(root) ? "" : "not ") + "a BST");
		root.left.right.data = 25;
		System.out.println("Tree is " + (isBst(root) ? "" : "not ") + "a BST");
	}
	
	static boolean isBst(TreeNode root) {
		if(root != null) {
			if((root.left != null ? (root.data > root.left.data ? true : false) : true) && (root.right != null ? (root.data < root.right.data ? true : false) : true)) {
				return isBst(root.left) && isBst(root.right);
			} else {
				return false;
			}
		} else {
			return true;
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