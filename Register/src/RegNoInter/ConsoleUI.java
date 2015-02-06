package RegNoInter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User interface of the application.
 */
public class ConsoleUI {
    /** register.Register of persons. */
    private Register register;
    
    /**
     * In JDK 6 use Console class instead.
     * @see readLine()
     */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Menu options.
     */
    
    private enum Option {
        PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
    };
    
    
    public ConsoleUI(Register register) {
        this.register = register;
    }
    
    public void run() {
        while (true) {			//po ukonceni kazdej operacie vypise menu
            switch (showMenu()) {
                case PRINT:
                    printRegister();
                    break;
                
                case ADD:
                    addToRegister();
                    break;
                
                case UPDATE:
                    updateRegister();
                    break;
                
                case REMOVE:
                    removeFromRegister();
                    break;
                
                case FIND:
                    findInRegister();
                    break;
                
                case EXIT:
                    return;
            }
        }
    }
    
    private String readLine() {
        //In JDK 6.0 and above Console class can be used
        //return System.console().readLine();
        
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    
    
    //NOVE
    private int inputNum;
    
    //metoda na osetrenie ciselneho inputu
    private boolean inputCheck(){
    	inputNum = 0;				//@Tony, da sa to spravit tak aby som nemusel inicializovat?
    	
    	try {
            inputNum = Integer.parseInt(readLine());
    	} catch (NumberFormatException ex) {
	      	System.out.println("Wrong format!");
	      	return false;						//ak sa vyskytne exception
    	}
    	return true;
    }
    
    private Option showMenu() {
        
        //int selection = -1;

        // new version, catch exception
        // ostrenie pri zadani nevhodnej option, zly format pripadne nic
        // options presunute do loopy
        do {
        	System.out.println();
        	System.out.println("Menu.");
        	for (Option option : Option.values()) {
        		System.out.printf("%d. %s%n", option.ordinal() +1, option);
        	}
        	System.out.println("-----------------------------------------------");
        	System.out.println("Option: ");
	      
        //zmena s pouzitim 	inputCheck()
        } while (!inputCheck() || inputNum <= 0 || inputNum > Option.values().length); //pokial podmieka plati do/while sa opakuje
        
        
        return Option.values()[inputNum - 1];
        
    }
    
    
    //TODO: Implement the method printRegister
    //DONE
    //1. PRINT
    private void printRegister() {
        	
    	System.out.println();
    	System.out.println("REGISTER:");
    	System.out.println("---------");
    	
    	for (int i = 0; i < register.getCount(); i++){
    		System.out.print(i + 1 + " ");
    		System.out.println(register.getPerson(i));
    	}
    	    	
        //throw new UnsupportedOperationException("Method printRegister not yet implemented");
    }
    
    
    //2. ADD
    //TODO: Zabezpecte aby nebolo mozne pridat osobu s rovnakym meno resp. tel. cislom ako sa nachadza v zozname.
    //osetreneie tejto funkcionality presunute do class Register, sucast ad addPerson method
	
    private void addToRegister() {
		System.out.println("Enter Name: ");
		String name = readLine();
		System.out.println("Enter Phone Number: ");
		String phoneNumber = readLine();

		Person newPerson = new Person(name, phoneNumber);
		
		//addPerson vracia TRUE/FALSE
		if (register.addPerson(newPerson)) {
			System.out.println(newPerson + " added to register.");
		} else {
			System.out.println("Person with this name or phone number already exists");
		}
	}    
        
    
    //TODO: Implement the method updateRegister
    //3. UPDATE
    //DONE
    private void updateRegister() {
    	System.out.println("Enter index of person to update: ");

        
        //ak sa vyskitne exception alebo index nezodpoveda
		if (inputCheck() && inputNum > 0 && inputNum <= register.getCount()) {

			System.out.println("What to update? (1 - name / 2 - phone number / 3 - both): ");
			// int change = Integer.parseInt(readLine());

			if (inputCheck() && inputNum > 0 && inputNum <= 3) {

				String newName = "name";
				String newPhoneNumber = "newPhoneNumber";

				
				switch (inputNum) {
				case 1:
					System.out.println("Enter new name: ");
					newName = readLine();
					newPhoneNumber = register.getPerson((inputNum - 1)).getPhoneNumber();
					break;
				case 2:
					System.out.println("Enter new phone number: ");
					newName = register.getPerson((inputNum - 1)).getName();
					newPhoneNumber = readLine();
					break;
				case 3:
					System.out.println("Enter new name: ");
					newName = readLine();
					System.out.println("Enter new phone number: ");
					newPhoneNumber = readLine();
					break;
				}

				register.addPerson(new Person(newName, newPhoneNumber),
						(inputNum - 1));
			} else {
				System.out.println("Invalid option!");
			}

		} else {
			System.out.println("Invalid person index!");
		}
        
    
    	//throw new UnsupportedOperationException("Method updateRegister not yet implemented");
    }
    
    
    //TODO: Implement the method findInRegister
    //5. FIND
    private void findInRegister() {
        System.out.println("Find by: 1 - name / 2 - phone number ");
        //int find = Integer.parseInt(readLine());
        
        if (inputCheck() && inputNum > 0 && inputNum <= 2) {
        	 
        	switch(inputNum){
             case 1:
             	System.out.println("Enter name: ");
             	String name = readLine();
             	Person foundPerson = register.findPersonByName(name);
             	if (foundPerson == null){
             		System.out.println("No such name in register");
             	}
             	else {
             		System.out.println(foundPerson);
             	}
             	break;

             case 2:
             	System.out.println("Enter phone number: ");
             	String phoneNumber = readLine();
             	System.out.println(register.findPersonByPhoneNumber(phoneNumber));
             	break;
        	}
        }
        else {
        	System.out.println("Invalid option!");
        }
        //throw new UnsupportedOperationException("Method findInRegister not yet implemented");
    }
    
    
    //4. REMOVE
    private void removeFromRegister() {
        
    	System.out.println("Enter index: ");
    	
    	//zmena s pouzitim 	inputCheck()
    	if (inputCheck() && inputNum > 0 && inputNum <= register.getCount()) {
    		Person person = register.getPerson(inputNum - 1);
    		register.removePerson(person);
    	}
    	else {
    		System.out.println("Invalid person index!");
    	}
        
    }

}


