package ulohy;
/*
	Vytvorte triedu Auto s premennymi znacka, pocetDveri, farba, kilometre
	Overte funkcnost triedy pomocou triedy TestAuto s metodou main
*/

class Auto {
	int pocetDveri;
	String farba;
	int kilometre;
}

public class TestAuto {
	public static void main(String[] args) {
		
		Auto auto1 = new Auto();
		auto1.pocetDveri = 5;
		auto1.farba = "modra";
		auto1.kilometre = 1000;
		
		System.out.println(auto1.pocetDveri);
		System.out.println(auto1.farba);
		System.out.println(auto1.kilometre);
	}
}


