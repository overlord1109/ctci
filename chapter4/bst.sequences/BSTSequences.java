import java.util.*;
import java.util.stream.Collectors;


public class BSTSequences {
	
	static Set<List<Integer>> permutations;
	
	public static void main(String[] args) {
		permutations = new HashSet<>();
		generatePermutations(new int[]{1,2,3,3}, 0);
		Iterator<List<Integer>> iter = permutations.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	//Recursively print permutations of int array
	public static void generatePermutations(int[] input, int startIndex) {
		if(startIndex == input.length) {
			permutations.add(Arrays.stream(input)
						.boxed()
						.collect(Collectors.toList())
						);
			return;
		}
		
		for(int i = startIndex; i < input.length; i++) {
			int[] newInput = input.clone();
			int swap = newInput[i];
			newInput[i] = newInput[startIndex];
			newInput[startIndex] = swap;
			
			generatePermutations(newInput, startIndex + 1);
		}
	}
}