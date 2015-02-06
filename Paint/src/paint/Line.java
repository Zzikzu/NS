	package paint;

	public class Line {
		private int size;
		
		public Line(int size) {
			this.size = size;
		}
		
		
		private void printChars(int length, char c) {
			
			
			for(int i=0; i<length; i++) {
			System.out.print(c);
			}
		}
		
		public void printLine() {
			for(int i=0; i<size; i++) {
				printChars(size - i - 1, ' ');
				printChars(size - i - 1, ' ');
				printChars(1, '*');
				System.out.println("");
			}
		}
			
		
	}
