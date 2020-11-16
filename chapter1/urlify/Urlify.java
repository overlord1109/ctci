public class Urlify {
	public static void main(String[] args) {
		System.out.println(urlify("Mr John Smith    ", 13));
		System.out.println(urlify("https://github.com/overlord 1109  ", 32));
	}
	
	public static String urlify(String str, int len) {
		char[] strArr = str.toCharArray();
		int j = str.length() - 1;
		for(int i = len - 1; i >= 0; i--) {
			if(strArr[i] != ' ') {
				strArr[j--] = strArr[i];
			} else {
				strArr[j--] = '0';
				strArr[j--] = '2';
				strArr[j--] = '%';
			}
		}
		
		return new String(strArr);
	}
}