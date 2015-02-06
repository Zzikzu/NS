package days;


public class DayWithStringSwitch {

	private static String getDayWithStringSwitch(String str) {
		switch(str) {
			case "Pondelok": return "Pondelisko";
			case "Utorok": return "Utorisko";
			case "Streda": return "Streda";
			case "Stvrtok": return "Stvrtok";
			case "Piatok": return "Piatocek";
			case "Sobota": return "Soboticka";
			case "Nedela": return "Nedelicka";
			default: return "Co za den si to tu zadal??";
		}
	}

	public static void main(String[] args) {
		//String switch - only since Java 7!
		System.out.println(getDayWithStringSwitch("Nedela"));
	}
}


