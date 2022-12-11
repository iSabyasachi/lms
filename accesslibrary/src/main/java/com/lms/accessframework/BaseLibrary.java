package com.lms.accessframework;

public abstract class BaseLibrary {
	//This class provides the skeleton of library
	// This method captures the template or the skeleton
    // of the algorithm for the library checklist.
	final public void runChecklist() {
		
		// Check of the user if authenticated
        createAccessLibrary();
        
        // Capture the log
        //System.out.println("Server log details created ? "+libraryLogCreated());
        
        // Load all the books and stored in memory
        loadBooks();
        
        // Load all the staff details
        loadStaffs();
        
        // Load all the members
        loadMembers();
        
	}
	final public void createAccessLibrary() {
		
	}
	protected abstract void loadBooks();
	
	protected abstract void loadStaffs();
	
	protected abstract void loadMembers();
}
