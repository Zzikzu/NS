package ulohy;
import java.util.Scanner;

//NumberToText - 3 chyby, rozsirit do 100 000

//Test on inputs 234 and 2132

public class NumberToText {
	// TODO: Fix main method

	
	
	
	
	public static void main(String[] args) {

		//CHYBA
		// wrong int
		// int number = Integer.parseInt(args[0]);
		int number = 100001;
		
		if (number == 0) {
			System.out.println("zero");
		}	
			

		if (number < 0) {
			System.out.println("Number:" + number + " is not supported");
			number = 0;
		}
		
		
		
		if (number > 100000) {
			System.out.println("Number: " + number + " is not supported");
			number = 0;
		}

		//100 000
		if (number == 100000) {
			writeNumber(1);
			writeNumber(100);
			writeNumber(1000);
			number = 0;

			
		}
		

		//OK
		//patciferne cisla
		if (number >= 10000 ) {
			//test sysyout
			//System.out.println("");
			//System.out.println("number >= 10000");
			
			int tempNumber = number / 1000;
			writeNumber(tempNumber / 10 * 10);
			//test sysout
			//System.out.println("");
			//System.out.println("number: " + number);

			if (tempNumber % 10 != 0) {			//ak zvysok po deleni nie je 0
				writeNumber(tempNumber % 10);	//spusti writeNuber pre zvysok
			}	
			writeNumber(1000);
			
			number %= 1000;
			/*
		} else if (number > 20000) {
			writeNumber(number / 1000);
			*/
		}
		
		
		//OK
		//stvorciferne cisla
		if (number >= 1000) {
			//test sysyout
			//System.out.println("");
			//System.out.println("number >= 1000");
			
			//CHYBA
			//writeNumber(number % 1000);
			writeNumber(number / 1000);
			writeNumber(1000);
			number %= 1000;
		}

		//OK
		//trojciferne cisla
		if (number >= 100) {
			//test sysyout
			//System.out.println("");
			//System.out.println("number >= 100");
			
			writeNumber(number / 100);	//nasobky 100
			writeNumber(100);
			number %= 100;
		}

		//OK
		//cisla do 20
		if (number <= 20) {
			//test sysyout
			//System.out.println("");
			//System.out.println("number <= 20");
			
			writeNumber(number);

		//OK
		//dvojciferne cisla nad 20
		} else if (number < 100) {
			//test sysyout
			//System.out.println("");
			//System.out.println("number < 100");
			
			writeNumber(number / 10 * 10);		//v dvojcifernom cisle zmeni druhu cifru na 0
			//CHYBA
			//wrong if statement
			//if (number % 10 == 0) {
			if (number % 10 != 0) {			//ak zvysok po deleni nie je 0
				writeNumber(number % 10);	//spusti writeNuber pre zvysok
			}
		}
	}

	private static void writeNumber(int number) {
		switch (number) {
		
		case 1:
			System.out.print("one ");
			break;
		case 2:
			System.out.print("two ");
			break;
		case 3:
			System.out.print("three ");
			break;
		case 4:
			System.out.print("four ");
			break;
		case 5:
			System.out.print("five ");
			break;
		case 6:
			System.out.print("six ");
			break;
		case 7:
			System.out.print("seven ");
			break;
		case 8:
			System.out.print("eight ");
			break;
		case 9:
			System.out.print("nine ");
			break;
		case 10:
			System.out.print("ten ");
			break;
		case 11:
			System.out.print("eleven ");
			break;
		case 12:
			System.out.print("twelve ");
			break;
		case 13:
			System.out.print("thirteen ");
			break;
		case 14:
			System.out.print("fourteen ");
			break;
		case 15:
			System.out.print("fifteen ");
			break;
		case 16:
			System.out.print("sixteen ");
			break;
		case 17:
			System.out.print("seventeen ");
			break;
		case 18:
			System.out.print("eighteen ");
			break;
		case 19:
			System.out.print("nineteen ");
			break;
		case 20:
			System.out.print("twenty ");
			break;
		case 30:
			System.out.print("thirty ");
			break;
		case 40:
			System.out.print("forty ");
			break;
		case 50:
			System.out.print("fifty ");
			break;
		case 60:
			System.out.print("sixty ");
			break;
		case 70:
			System.out.print("seventy ");
			break;
		case 80:
			System.out.print("eighty ");
			break;
		case 90:
			System.out.print("ninety ");
			break;
		case 100:
			System.out.print("hundred ");
			break;
		case 1000:
			System.out.print("thousand ");
			break;
			
		}
	}
}



