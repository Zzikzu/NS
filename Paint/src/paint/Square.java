package paint;

public class Square {
	private int a;

	public Square(int a) {
		this.a = a;
	}

	public void printSquare() {
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}

}
 