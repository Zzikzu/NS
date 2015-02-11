package regNoInter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User interface of the application.
 */
public class ConsoleUI {
    /** register.Register of persons. */
    private Register register;

    //int pre inputCheck()
    private int inputNum;
    
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

        do {
        	showMenu();
        	inputCheck();
        	
            switch (inputNum) {
            
        	  case 1:			//PRINT
                printRegister();
                break;
            
            case 2:				//ADD
                addToRegister();
                break;
            
            case 3:				//UPDATE
                updateRegister();
                break;
            
            case 4:				//REMOVE
                removeFromRegister();
                break;
            
            case 5:				//FIND
                findInRegister();
                break;
            
            case 6:				//EXIT
                return;
            default:
            	System.out.println("Invalid option!");
        }
        	
        } while (true);
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
    
    
    //metoda na osetrenie ciselneho inputu
    private boolean inputCheck(){
    	
    	try {
            inputNum = Integer.parseInt(readLine());
    	} catch (NumberFormatException ex) {
	      	System.out.println("Wrong format!");
	      	return false;						//ak sa vyskytne exception
    	}
    	return true;
    }
    
    private void showMenu() {
    	
    	  /*
		 @Laci - toto tiez neviem, ci si mal takto zadane v ulohe, kazdopadne, ja by som to kus zmenil, 
		 lebo tato metoda sa vola showMenu, tak by mala len zobrazit menu, zmenil by som return type na void a uplne by som odstranil tu slucku odtial
		 a dal ju do readLine metody. Tam si zadefinuj lokalnu premennu inputNum (odstran tu clensku premennu).
		 V slucke daj volanie showMenu() a input.readLine() a v podmienke daj iba inputCheck() a do tej metody zahrn aj tu kontrolu inputNum <= 0 || inputNum > Option.values().length a ako argumenttam posielaj inputNum, ktore dostanes z readline
		 no a nakoniec v run() metode zmen v tom switchy volanie showMenu() na volanie readLine()
		 
		 ta skus to takto pomenit, ta struktura bude logicky lepsie zodpovedat tomu, co jednotlive metody maju robit, potom uploadni, pozriem este dalsie veci a ti napisem
	*/
    	
    	/*
    	@Tony - showMenu() som nerobil ja, bolo to uz spravene
    	snazil som sa to prerobit, no nie uplne ako si pisal
    	showMenu uz len vypise menu, tu loopu som zrusil a poriesil to v metode run()
    	inputNum som nechal ako clensku premennu, lebo ju pouzivam vpodstate vsade kde sa zadava ciselny input
    	funcie metod readLine() a inputCheck() su stale metuce, neviem ako to spravit lepsie 
    	
    	 */
        
    	System.out.println();
    	System.out.println("Menu.");
    	for (Option option : Option.values()) {
    		System.out.printf("%d. %s%n", option.ordinal() +1, option);
    	}
    	System.out.println("-----------------------------------------------");
    	System.out.println("Option: ");
        
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
			System.out.println("Person \"" + newPerson.getName() + "\" cannot be added to register");
			System.out.println("The person is invalid or there is an existing detail conflict");
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
				case 1:		//update NAME
					System.out.println("Enter new name: ");
					newName = readLine();
					newPhoneNumber = register.getPerson((inputNum - 1)).getPhoneNumber();
					break;
				case 2:		//update PHONE NUMBER
					System.out.println("Enter new phone number: ");
					newName = register.getPerson((inputNum - 1)).getName();
					newPhoneNumber = readLine();
					break;
				case 3:		//update BOTH
					System.out.println("Enter new name: ");
					newName = readLine();
					System.out.println("Enter new phone number: ");
					newPhoneNumber = readLine();
					break;
				}
				
				
				/* @Tony - pridal som tento if
				 ak sa pri update zadalo neplatne phone num priradi mu num
				 musel som isValidPhoneNumber v clase Person dat ako public, bolo private
				 */
				
				if(new Person(newName, newPhoneNumber).isValidPhoneNumber(newPhoneNumber)){
					register.addPerson(new Person(newName, newPhoneNumber),(inputNum - 1));
				}
				else {
					System.out.println("Invalid input!");
				}
				
				
			
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


