package regNoInter;

import java.util.Arrays;

public class Main {
	

    public static void main(String[] args) throws Exception {
    	
    	System.out.println("Version info: without interface, tuned");
    	
    	Register register = new Register(20);

        register.addPerson(new Person("Janko Hrasko", "0915213458"));
        register.addPerson(new Person("Ferko Mrkvicka", "0602134646"));
        register.addPerson(new Person("Jozko Pucik", "0916123456"));
    	
        	
    	
        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
        
  
    }
}


