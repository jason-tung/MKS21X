public class Book{
    private String author,title,isbin;
    
    public Book(){
	author = "Donald E. Knuth";
	title = "The Art of Computer Programming";
	isbin = "9780201311204";
    }

    public Book(String a,String t,String i){
	author = a;
	title = t;
	isbin = i;
    }

    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBIN(){
	return isbin;
    }

    public void setAuthor(String a){
        author=a;
    }
    public void setTitle(String a){
        title=a;
    }
    public void setISBIN(String a){
        isbin=a;
    }
    
    public String toString(){
	return "Title: " + title + "\nAuthor: " +author+"\nISBIN: " + isbin;
    }
}
