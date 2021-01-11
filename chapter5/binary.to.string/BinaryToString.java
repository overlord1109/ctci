public class BinaryToString {
	
	public static void main(String[] args) {
		System.out.println(binaryToString(0.125));
		System.out.println(binaryToString(0.673828125));
	}
	
	public static String binaryToString(double num) {
		char[] result = new char[32];
		int i = 0;
		result[i++] = '0';
		result[i++] = '.';
		double d = 1;
		while(num > 0) {
			if(i > 31)
				return "Error";
			
			d /= 2;
			if(num >= d) {
				result[i++] = '1';
				num -= d;
			} else {
				result[i++] = '0';
			}
		}
		return new String(result);
	}
}