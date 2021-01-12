public class NextNumber {
	public static void main(String[] args) {
		int[] nextNums = nextNumber(13948);
		System.out.println(nextNums[0] + ", " + nextNums[1]);
	}
	
	public static int[] nextNumber(int num) {
		int nums[] = new int[2];
		
		if(num == 0) {
			nums[0] = 0;
			nums[1] = 0;
			return nums;
		}
		
		int i = 0;
		int tmp = num;
		
		while(((tmp >> i) & 1) == 0)
			i++;
			
		int j = i;
		
		while(((tmp >> i) & 1) == 1)
			i++;
		
		tmp |= (1 << i);
		
		tmp &= ~((1 << i) - 1);
		
		nums[0] = ((1 << (i - j - 1)) - 1) | tmp;
		
		i = 0;
		j = 0;
		tmp = num;
		
		while(((tmp >> i) & 1) == 1)
			i++;
		
		j = i;
		
		while(((tmp >> i) & 1) == 0)
			i++;
		
		tmp &= ~(1 << i);
		
		tmp |= ((1 << i) - 1);
		
		nums[1] = ~((1 << (i - j - 1)) - 1) & tmp;
		
		return nums;
	}
}