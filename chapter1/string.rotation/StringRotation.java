public class StringRotation{
	public static void main(String[] args) {
		System.out.println(isRotated("mandar", "darman"));
		System.out.println(isRotated("mandar", "darmana"));
		System.out.println(isRotated("aaaaa", "aaaaaaa"));
	}
	
	public static boolean isRotated(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		
		String s2s2 = s2 + s2;
		
		if(s2s2.indexOf(s1) != -1)
			return true;
		else
			return false;
	}
}