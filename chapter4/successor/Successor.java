import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Successor {
	public static void main(String[] args) {
		int[] array = new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		TreeNode root = TreeNode.createMinimalBST(array);
		root.print();
		TreeNode arg = root.right.left.right;
		System.out.println("The successor of " + arg.data + " is " + successor(arg).data);
		arg = root.left.right.right;
		System.out.println("The successor of " + arg.data + " is " + successor(arg).data);
	}
	
	static TreeNode successor(TreeNode node) {
		if(node.right != null) {
			node = node.right;
			while(node.left != null)
				node = node.left;	
			return node;
		} else {
			while(node.parent != null && node.parent.right == node) {
				node = node.parent;
			}
			return node.parent;
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

//Following classes are taken from https://github.com/careercup/CtCI-6th-Edition/
class TreeNode {
	public int data;      
	public TreeNode left;    
	public TreeNode right; 
	public TreeNode parent;
	private int size = 0;

	public TreeNode(int d) {
		data = d;
		size = 1;
	}
	
	private void setLeftChild(TreeNode left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}
	
	private void setRightChild(TreeNode right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}
	
	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null) {
				setLeftChild(new TreeNode(d));
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				setRightChild(new TreeNode(d));
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isBST() {
		if (left != null) {
			if (data < left.data || !left.isBST()) {
				return false;
			}
		}
		
		if (right != null) {
			if (data >= right.data || !right.isBST()) {
				return false;
			}
		}		
		
		return true;
	}
	
	public int height() {
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public TreeNode find(int d) {
		if (d == data) {
			return this;
		} else if (d <= data) {
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}
	
	private static TreeNode createMinimalBST(int arr[], int start, int end){
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.setLeftChild(createMinimalBST(arr, start, mid - 1));
		n.setRightChild(createMinimalBST(arr, mid + 1, end));
		return n;
	}
	
	public static TreeNode createMinimalBST(int[] array) {
		return createMinimalBST(array, 0, array.length - 1);
	}
	
	public void print() {
		BTreePrinter.printNode(this);
	}
}

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(TreeNode root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
