import java.util.*;

public class IsUnique {
	public static void main(String[] args) {
		assert isUnique("muscle");
		assert !isUnique("Mandar");
		assert isUniqueWithoutDataStructure("muscle");
		assert !isUniqueWithoutDataStructure("Mandar");
		assert !isUniqueWithoutDataStructure("aMandarr");
	}
	
	public static boolean isUnique(String str) {			O (n)
		Set<Character> uniqueChars = new HashSet<>();
		for(int i=0; i<str.length(); i++) {
			if(uniqueChars.contains(str.charAt(i))) {
				return false;
			}
			uniqueChars.add(str.charAt(i));
		}
		return true;
	}
	
	public static boolean isUniqueWithoutDataStructure(String str) {		O (n log n)
		char[] stringChars = str.toCharArray();
		Arrays.sort(stringChars);		//Arrays.sort uses a Dual-Pivot Quicksort; O (n log n)
		for(int i=0; i < stringChars.length - 1; i++) {
			if(stringChars[i] == stringChars[i+1])
				return false;
		}
		return true;
	}
}