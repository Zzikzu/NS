package paint;

public class Rectangle {
	private int a;
	private int b;
	
	public Rectangle(int a, int b) {
		this.a = a;
		this.b = b;
	
	}
	
	public void printRectangle() {
		for(int i = 0; i<a; i++) {
			for(int j = 0; j<b; j++) {
			System.out.print("* ");
			}
			System.out.println("* ");
		}
	}
		
	
}
