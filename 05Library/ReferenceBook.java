public class ReferenceBook extends LibraryBook{
    String collection;

    public ReferenceBook(String author, String name, String isbin, String callNumber, String collection){
	super(aut, name, isbin, callNumber);
	collection = collection;
    }

    public String getCollection(){
	return collection;
    }

    public void setCollection(String a){
        collection = a;
    }

    public void checkout(String patron, String due){
        throw new UnsupportedOperationException("cannot check out a reference book");
    }

    public void returned(String patron, String due){
	throw new UnsupportedOperationException("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
	return "non-circulating reference book";
    }

    public String toString(){
        return super.toString() + "/b collection: " + collection;
    }

	
