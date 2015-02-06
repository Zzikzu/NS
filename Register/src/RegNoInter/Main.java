package RegNoInter;

import java.util.Arrays;

public class Main {
	

    public static void main(String[] args) throws Exception {
    	
    	System.out.println("Version info: without interface, tuned");
    	
    	Register register = new Register(20);

        register.addPerson(new Person("Janko Hrasko", "0900123456"));
        register.addPerson(new Person("Ferko Mrkvicka", "0900123123"));
        register.addPerson(new Person("Jozko Pucik", "0900666123"));
    	
        	
    	
        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
        
  
    }
}


