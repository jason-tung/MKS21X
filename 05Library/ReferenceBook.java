public class ReferenceBook extends LibraryBook{
    String collection;

    public ReferenceBook(String author, String name, String isbin, String callNumber, String collection){
	super(author, name, isbin, callNumber);
	collection = collection;
    }

    public String getCollection(){
	return collection;
    }

    public void setCollection(String a){
        collection = a;
    }

    public void checkout(String patron, String due){
        System.out.println("Reference book could not have been checked out");

    }

    public void returned(){
	System.out.println("Reference book could not have been checked out -- return impossible");

    }

    public String circulationStatus(){
	return "non-circulating reference book";
    }

    public String toString(){
        return super.toString() + "\ncollection: " + collection;
    }
}

	
