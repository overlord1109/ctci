public class Insertion {
	public static void main(String[] args) {
		System.out.println(insert(19, 1024, 2, 6));
	}
	
	public static int insert(int M, int N, int i, int j) {
		int mask = ~((0 << i) ^ (0 << j));
		return (N & mask) | (M << i);
	}
}