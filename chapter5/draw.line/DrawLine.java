public class DrawLine {
	public static void main(String[] args) {
		byte[] screen = new byte[100];
		drawLine(screen, 80, 30, 50, 4);
		printScreen(screen, 80);
	}
	
	public static void printByte(byte b) {
		for (int i = 7; i >= 0; i--) {
			char c = ((b >> i) & 1) == 1 ? '1' : '_';
			System.out.print(c);
		}
	}
	
	public static void printScreen(byte[] screen, int width) {
		int height = screen.length * 8 / width;
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c+=8) {
				byte b = screen[computeByteNum(width, c, r)];
				printByte(b);
			}
			System.out.println("");
		}
	}
	
	public static int computeByteNum(int width, int x, int y) {
		return (width * y + x) / 8;
	}
	
	
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {

		if(x2 - x1 < 8) {
			screen[width / 8 * y + (x1 / 8)] |= (((1 << (x2-x1+1)) - 1) << x1);
			return;
		}

		screen[width / 8 * y + (x1 / 8)] |= ((1 << (8 - (x1 % 8) + 1)) - 1);
		
		for(int offset = (x1 / 8) + 1; offset < (x2 / 8); offset++) {
			screen[width / 8 * y + offset] |= 0xFF;
		}
		
		screen[width / 8 * y + (x2 / 8)] |= ~((1 << (8 - (x2 % 8))) - 1);
	}
}