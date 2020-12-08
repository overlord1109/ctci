public class CheckBalanced {
	public static void main(String [] args) {
		int[] array = new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		TreeNode root = createMinimalTree(array, 0, array.length - 1);
		System.out.println("Tree is " + (isBalanced(root).isBalanced ? "" : "not ") + "balanced");
		
		root.left.left = null;
		System.out.println("Tree is " + (isBalanced(root).isBalanced ? "" : "not ") + "balanced");
	}
	
	static Result isBalanced(TreeNode root) {
		if(root != null) {
			Result leftResult = isBalanced(root.left);
			Result rightResult = isBalanced(root.right);
			
			if(!leftResult.isBalanced || !rightResult.isBalanced)
				return new Result(false);
			
			Result result = new Result();
			
			int leftHeight = leftResult.subTreeHeight;
			int rightHeight = rightResult.subTreeHeight;

			if(leftHeight - rightHeight > 1 || rightHeight - leftHeight > 1) {
				result.isBalanced = false;
			} else {
				result.isBalanced = true;
			}
			result.subTreeHeight = Math.max(leftHeight, rightHeight) + 1;			
			return result;
		} else {
			return new Result(true, -1);
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

class Result {
	boolean isBalanced;
	int subTreeHeight;
	
	Result() {
	}
	
	Result(boolean isBalanced) {
		this.isBalanced = isBalanced;
	}
	
	Result(boolean isBalanced, int subTreeHeight) {
		this.isBalanced = isBalanced;
		this.subTreeHeight = subTreeHeight;
	}
}