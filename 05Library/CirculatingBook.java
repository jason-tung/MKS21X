public class CirculatingBook extends LibraryBook{
    private String currentHolder, dueDate;

    public CirculatingBook(String author, String title, String isbin, String callNumber){
	super(author, title, isbin, callNumber);
	returned();
    }

    public String getCurrentHolder(){
	return currentHolder;
    }
    
    public String getDueDate(){
	return dueDate;
    }
    
    public void setCurrentHolder(String p){
        currentHolder = p;
    }
    
    public void setDueDate(String p){
	dueDate = p;
    }
    
    public void checkout(String a, String b){
	currentHolder = a;
	dueDate = b;
    }

    public void returned(){
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus(){
	if (currentHolder == null){
	    return "book available on shelves!";
	}
	return "book checked out by " + currentHolder + " until " + dueDate;
    }

    public String toString(){
	if (currentHolder == null){
	    return super.toString();
	}
	return super.toString() + "/n Current Holder: " + currentHolder + "/nDue: " + dueDate;
    }
}
