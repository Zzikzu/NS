package ulohy;

//zistuje ci argumenty zadane pri spustani obashuju charakter a
//run configuration, arguments

//http://www.javaworld.com/article/2077520/learn-java/java-tip-23--write-native-methods.html
//skusat TestBreak, rozne varianty break a continue
//pozriet Arrays v Java API, vyskusat metody
//najdenie minima, maxima, sumy a priemeru pola cisel
//utriedenie pola celych cisel
//System.currentTimeMillis(); - odmerat cas a sutazit s Javou :)
//zistit ci je matica symetricka m[i][j]=m[j][i]
//boolean isSym(int[][] a)
//urobit funkciu na sucet matic (kto chce, tak aj sucin matic)
//int[][] sucet(int[][] a, int[][] b)
//predosle ulohy, komu robili problemy este
//oboznamit sa so Shapes, Point (v JavaOOP)
//skusit si spravit swap suradnic (x,y) v Point
//oboznamit sa s registrom osob (s triedami)


public class TestBreak {
	public static void main(String[] args) {
		final char character = 'a';

		test:
		for(int argIndex = 0; argIndex < args.length; argIndex++) {
			for(int charIndex = 0; charIndex < args[argIndex].length(); charIndex++) {
				if(args[argIndex].charAt(charIndex) == character){
					System.out.println("At least one argument contains '"+character+"'.");
					break test;		//ukonci test po prvom najdeni a v argumentoch
	            }
			}
		}
	    System.out.println("End of the program");
	}
}



