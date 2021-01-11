public class FlipBitToWin {
	public static void main(String[] args) {
		System.out.println(flipBitToWin(28541));	//Binary : 110111101111101
		System.out.println(flipBitToWin(243242));	//Binary : 111011011000101010
		System.out.println(flipBitToWin(~0));
		System.out.println(flipBitToWin(0));	
	}
	
	public static int flipBitToWin(int num) {
		int max = 1, curr = 0, prev = 0;
		boolean flipped = false;
		
		while(num != 0) {
			if((num & 1) == 1) {
				if(flipped)
					prev++;
				curr++;
				if(curr > max)
					max = curr;
			} else {
				if(flipped) {
					curr = prev + 1;
					if(curr > max)
						max = curr;
					prev = 0;
				} else {
					flipped = true;
					curr++;
					if(curr > max)
						max = curr;
				}
			}
			num = num >>> 1;
		}
		return max;
	}
}