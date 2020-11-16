public class IsPermutation {
	
	public static void main(String[] args) {
		System.out.println(isPermutation("Mandar", "danarM"));
	}
	
	public static boolean isPermutation(String str, String other) {		// O(n) solution
		if(str.length() != other.length())
			return false;
		
		int CHARSET_SIZE = 128;
		int[] strVector = new int[CHARSET_SIZE];
		int[] otherVector = new int[CHARSET_SIZE];
		
		for(int i = 0; i < str.length(); i++) {
			strVector[str.charAt(i)]++;
		}
		
		for(int i = 0; i < str.length(); i++) {
			otherVector[other.charAt(i)]++;
		}
		
		for(int i = 0; i < CHARSET_SIZE; i++) {
			if(strVector[i] != otherVector[i])
				return false;
		}
		return true;
	}
}