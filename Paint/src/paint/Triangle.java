package paint;

public class Triangle {
	private int size;

	public Triangle(int size) { // constructor
		this.size = size;
	}

	private void printChars(int length, char c) {
		for (int i = 0; i < length; i++) {
			System.out.print(c);
		}
	}

	public void printTriangle() {
		for(int i=0; i < size; i++) {
			printChars(size - i - 1, ' ');
			printChars(2 * i + 1, '*');
			System.out.println();
		}
	
	}

}
