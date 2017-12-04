public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String author, String title, String isbin, String callNumber){
	super(author,title,isbin);
	this.callNumber = callNumber;
    }

    public String getCallNumber(){
	return callNumber;
    }

    public void setCallNumber(String f){
        callNumber = f;
    }

    public abstract void checkout(String patron, String due);
    
    public abstract void returned();
    
    public abstract String circulationStatus();

    public int compareTo(LibraryBook bk2){
	return callNumber.compareTo(bk2.getCallNumber());
    }

    public String toString(){
	return super.toString() + "\nCirculation Status: " + circulationStatus() + "\nCall Number: " + callNumber;
    }
}
