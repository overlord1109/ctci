import java.util.*;
import java.util.stream.Collectors;


public class BSTSequences {

    static Set<List<Integer>> permutations;

    public static void main(String[] args) {
        permutations = new HashSet<>();
        generatePermutations(new int[]{1, 2, 3, 3}, 0, permutations);
        Iterator<List<Integer>> iter = permutations.iterator();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        List<List<Integer>> bstSequences = generateBSTSequences(root);

        for (List<Integer> bstSequence : bstSequences)
            System.out.println(bstSequence);
    }

    public static List<List<Integer>> generateBSTSequences(TreeNode root) {
        Map<Integer, List<Integer>> mapOfDepths = new HashMap<>();
        createListOfDepths(root, 0, mapOfDepths);
        Set<List<Integer>> permutations;

        List<List<Integer>> bstSequences = new ArrayList<>();
        for (int i = 0; mapOfDepths.containsKey(i); i++) {
            permutations = new HashSet<>();
            generatePermutations(mapOfDepths.get(i).stream().mapToInt(j -> j).toArray(), 0, permutations);
            if (bstSequences.size() == 0) {
                bstSequences.addAll(permutations);
            } else {
                List<List<Integer>> tempSequences = new ArrayList<>();
                for (List<Integer> bstSequence : bstSequences) {
                    for (int k = 0; k < permutations.size(); k++) {
                        tempSequences.add(new ArrayList<>(bstSequence));
                    }
                }
                Iterator<List<Integer>> iter = permutations.iterator();
                for (List<Integer> tempSequence : tempSequences) {
                    if (!iter.hasNext())
                        iter = permutations.iterator();
                    tempSequence.addAll(iter.next());
                }

                bstSequences = tempSequences;
            }
        }

        return bstSequences;
    }

    public static void createListOfDepths(TreeNode root, int depth, Map<Integer, List<Integer>> mapOfDepths) {
        if (root == null)
            return;

        List<Integer> list = mapOfDepths.get(depth);

        if (list == null) {
            list = new ArrayList<>();
            list.add(root.data);
            mapOfDepths.put(depth, list);
        } else {
            list.add(root.data);
        }


        createListOfDepths(root.left, depth + 1, mapOfDepths);
        createListOfDepths(root.right, depth + 1, mapOfDepths);
    }

    //Recursively print permutations of int array
    public static void generatePermutations(int[] input, int startIndex, Set<List<Integer>> permutations) {
        if (startIndex == input.length) {
            permutations.add(Arrays.stream(input)
                    .boxed()
                    .collect(Collectors.toList())
            );
            return;
        }

        for (int i = startIndex; i < input.length; i++) {
            int[] newInput = input.clone();
            int swap = newInput[i];
            newInput[i] = newInput[startIndex];
            newInput[startIndex] = swap;

            generatePermutations(newInput, startIndex + 1, permutations);
        }
    }

    static TreeNode createMinimalTree(int[] arr, int low, int high) {
        if (low == high) {
            return new TreeNode(arr[low]);
        } else if (low + 1 == high) {
            TreeNode root = new TreeNode(arr[high]);
            root.left = new TreeNode(arr[low]);
            return root;
        }

        int mid = (low + high + 1) / 2;

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