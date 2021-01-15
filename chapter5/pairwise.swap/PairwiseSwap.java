public class PairwiseSwap {
	
	public static void main(String[] args) {
		int num = 5325;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(pairwiseSwap(num)));
	}
	
	public static int pairwiseSwap(int num) {
		int mask = 0xAAAAAAAA;
		
		int odd = num & mask;
		
		int even  = num & (mask >>> 1);
		
		return (odd >>> 1) | even << 1;
	}
}