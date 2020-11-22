public class StringRotation{
	public static void main(String[] args) {
		System.out.println(isRotated("mandar", "darman"));
		System.out.println(isRotated("mandar", "darmana"));
		System.out.println(isRotated("aaaaa", "aaaaaaa"));
	}
	
	public static boolean isRotated(String one, String other) {
		if(one.length() != other.length())
			return false;
		
		String concatenated = other + other;
		
		if(concatenated.indexOf(one) != -1)
			return true;
		else
			return false;
	}
}