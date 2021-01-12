public class Conversion {
	public static void main(String[] args) {
		System.out.println(conversion(13967, 6768));
	}
	
	public static int conversion(int first, int second) {
		return Integer.bitCount(first ^ second);
	}
}