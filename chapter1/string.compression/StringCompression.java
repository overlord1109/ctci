public class StringCompression {
	public static void main(String[] args) {
		System.out.println(compress("Hola"));
		System.out.println(compress("aabcccccaaad"));
		System.out.println(compress("Mandar"));
	}
	
	public static String compress(String str) {
		StringBuilder builder = new StringBuilder();
		
		int runLength = 0, i = 0, j = 0;
		int len = str.length();
		boolean compressable = false;
		while(i < len - 1) {
			runLength = 1;
			j = i;
			if(str.charAt(i) == str.charAt(i+1)) {
				compressable = true;
				while(i < len - 1 && str.charAt(i) == str.charAt(i+1)) {
					i++;
					runLength++;
				}
			}
			i++;
			builder.append(str.charAt(j))
				.append(runLength);
		}
		
		if(str.charAt(len - 1) != str.charAt(len - 2)) {
			builder.append(str.charAt(len - 1))
				.append(1);
		}
		
		return compressable ? builder.toString() : str;
	}
}