public class CheckSubtree {
	
	public static void main(String[] args) {		
		TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
		
		TreeNode root2 = root;
		
        root = new TreeNode(7);
        root.left = new TreeNode(6);
        root.right = new TreeNode(8);
		
		System.out.println("checkSubtree: " + checkSubtree(root2, root));
	}
	
	public static boolean checkSubtree(TreeNode t1, TreeNode t2) {
		if(t1 == null)
			return false;
		
		if(t1.data == t2.data && isSameTree(t1, t2)) {
			return true;
		}
		
		return checkSubtree(t1.left, t2) || checkSubtree(t1.right, t2);
	}
	
	public static boolean isSameTree(TreeNode t1, TreeNode t2) {
		if(t1 == null || t2 == null) {
			return t1 == t2;
		}
		
		return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
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