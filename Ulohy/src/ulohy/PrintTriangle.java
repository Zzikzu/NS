package ulohy;
//PrintTriangle - 2 chyby
/*
  TODO: Expected output from the program for size = 10
             *
            ***
           *****
          *******
         *********
        ***********
       *************
      ***************
     *****************
    *******************
*/
public class PrintTriangle {
    public static void main(String[] args) {
        int size = 10;
        int i = 0;

        while(i < size) {
            printChars(size - i - 1, ' ');		//volanie method printChar
            //wrong algorithm
            //printChars(2 * (i + 1), '*');
            printChars(2 * i + 1, '*');			//volanie method printChar
            System.out.println();
            //missing end of loop, infinite loop
            i++;
        }
    }

    private static final void printChars(int length, char c) {
        for(int i = 0; i < length; i++) {
            System.out.print(c);
        }
    }
}



