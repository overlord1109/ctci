import java.util.*;

public class RandomNode {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.size = 7;
		root.left = new TreeNode(3);
		root.left.size = 3;
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(7);
		root.right.size = 3;
		root.right.right = new TreeNode(8);
		root.right.left  = new TreeNode(6);
		
		Tree tree = new Tree();
		tree.root = root;
		
		Map<Integer, Integer> testDistribution = new HashMap<>();
		
		for(int i = 0; i < 100000; i++) {			
			int data = tree.getRandomNode().data;
			Integer count = testDistribution.get(data);
			if(count == null)
				testDistribution.put(data, 1);
			else
				testDistribution.put(data, count + 1);
		}
		
		System.out.println("Distribution:\n\nData\tCount");
		for(Map.Entry<Integer, Integer> entry : testDistribution.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
}

class Tree {
	
	TreeNode root;
	
	public TreeNode getRandomNode() {
		return root.getIthNode(new Random().nextInt(root.size));
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	int size;
	
	public TreeNode(int data) {
		this.data = data;
		this.size = 1;
	}
	
	public TreeNode getIthNode(int i) {
		int leftSize = left == null ? 0 : left.size;
		if(i < leftSize)
			return left.getIthNode(i);
		else if(i == leftSize)
			return this;
		else
			return right.getIthNode(i - leftSize - 1);
	}
}