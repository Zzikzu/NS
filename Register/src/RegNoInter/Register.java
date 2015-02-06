package RegNoInter;

/**
 * register.Person register.
 */
public class Register {
    /** register.Person array. */
    private Person[] persons;
   
    
    /** Number of persons in this register. */
    private int count;
    
    /**
     * Constructor creates an empty register with maximum size specified.
     * @param size maximum size of the register
     */
    public Register(int size) {
        persons = new Person[size];
        count = 0;
    }
    
    /**
     * Returns the number of persons in this register.
     * @return the number of persons in this register
     */
    public int getCount() {
        return count;
    }
    
    /**
     * Returns the maximum number of persons in this register.
     * @return the maximum number of persons in this register.
     */
    public int getSize() {
        return persons.length;
    }
    
    /**
     * Returns the person at the specified position in this register.
     * @param index index of the person to return 
     * @return person the person at the specified position in this register 
     */
    public Person getPerson(int index) {
        return persons[index];
    }

    /**
     * Appends the specified person to the end of this register. 
     * @param person person to append to this register
     */
    
    public boolean addPerson(Person person) {
    	
    	//TODO: Zabezpecte aby nebolo mozne pridat osobu s rovnakym meno resp. tel. cislom ako sa nachadza v zozname.
    	//navratovy tymp zmeneny na boolean
        boolean match = false;
    	
        for (int i=0; i<this.getCount(); i++){
    		if (person.getName().equals(this.getPerson(i).getName()) == true || person.getPhoneNumber().equals(this.getPerson(i).getPhoneNumber()) == true){
    		match = true;
    		}
    	}
        
        if (match != true){
        	 persons[count] = person;
             count++;
             return true;
    	} else {
    		return false;
    	}               
    }

    
    
    //My method for updateRegister IN ConsoleUI
    public void addPerson(Person person, int index) {
    	persons[index] = person;
    }
    
    
    //TODO: Implement the method findPersonByName
    /**
     * Returns the person with specified name in this register or <code>null</code>,
     * if match can not be found.
     * @param name name of a person to search for
     * @return person with specified phone number
     */
    public Person findPersonByName(String name) {
    	
    	
    	for (int i=0; i<count; i++){
    		if (name.equals(getPerson(i).getName()) == true){
    			return getPerson(i);
    		}
    	}
    	
    	//in case there is no match
    	//ak podmienka v if nie je splnena
    	return null;
    	
    	//throw new UnsupportedOperationException("Method findPersonByName not yet implemented");
    }
    
    //TODO: Implement the method findPersonByPhoneNumber
    /**
     * Returns the person with specified phone number in this register or <code>null</code>,
     * if match can not be found.
     * @param phoneNumber phone number of a person to search for
     * @return person with specified phone number
     */
    public Person findPersonByPhoneNumber(String phoneNumber) {

    	int x = 0;
    	
    	for (int i=0; i<count; i++){
    		if (phoneNumber.equals(getPerson(i).getPhoneNumber()) == true){
    			return getPerson(i);
    		}
    	}
    	
    	
    	//in case there is no match
    	//ak podmienka v if nie je splnena
    	return null;
    	
        //throw new UnsupportedOperationException("Method findPersonByPhoneNumber not yet implemented");
    }
    
    //TODO: Implement the method removePerson
    //DONE
    /**
     * Removes the specified person from the register.
     * @param person person to remove
     */
    public void removePerson(Person person) {
    	System.out.print("Removing ");
    	System.out.println(person);
    	
    	// moje
    	int deletedCount = 0;
    	
    	for (int i = 0; i < getCount(); i++) {
    		if (person.equals(persons[i])) {
    			deletedCount++;
    		} 
    		
    		if(deletedCount>0) {
    			persons[i] = persons[i+deletedCount];
    		}
    	}
    
    	count -= deletedCount;
    }
}


