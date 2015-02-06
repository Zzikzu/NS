package days;

//zadanie:
//	pre vstupy: Pondelok, Utorok, Streda,  …, Nedela
//	vypise: Pondelisko, Utorisko, Streda, Stvrtok, Piatocek, Soboticka, Nedelicka
//	Vyskusat si rozne variacie riesenia, zamysliet sa nad efektivitou pisania kodu a citatelnostou kodu. Mozne variacie: stringovy switch (pozor, len od Java 7! Bez spatnej kompatibility!), if-else+equals, enum, enum s toString, nepovinne: parametricky enum s privatnym konstruktorom)
//


public class TestDay {

private	enum DayEnum {
		PON, UTO, STR, STV, PIA, SOB, NED;
	}

	public static void main(String[] args) {
		
		//classic enum
		DayEnum day = DayEnum.PON;
		printDay(getDay(day));		// zavola printDay s parametrom getDay(day)
		
	
	}
	
	private static String getDay(DayEnum day) {
		switch(day) {
			case PON: return "Pondelisko";
			case UTO: return "Utorisko";
			case STR: return "Streda";
			case STV: return "Stvrtok";
			case PIA: return "Piatocek";
			case SOB: return "Soboticka";
			case NED: return "Nedelicka";
			default: return "Co za den si to tu zadal??";
		}
	}

	private static void printDay(String str) {
		System.out.println(str);
	}
	
}


