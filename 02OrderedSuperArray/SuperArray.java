
import java.util.*;
//i forgot how to do documentation rofl
public class SuperArray{
  //fields
  private String[] data;
    private int size;

    public static void main(String[] args){
	for (int x = 0; x < 10; x++){
	    runTest01(x);
	}
    }
    
    public static void runTest01(int testID){
	if(testID<0){
	    System.out.println("Error in driver usage!");
	    System.exit(0);
	}
  
	SuperArray s1 = new SuperArray();
	ArrayList<String> s2 = new ArrayList<>();
  
	try{
	    if(testID == 0 ){
	    }
    
	    if(testID == 1 ){
		s1.add("0");
		s2.add("0");
		s1.add("1");
		s2.add("1");
	    }
    
	    if(testID == 2 ){
      
		s1.add("0");
		s2.add("0");
		s1.add("1");
		s2.add("1");
		s1.add(1,"5");
		s2.add(1,"5");
		s1.add(0,"6");
		s2.add(0,"6");
		s1.add(s1.size()-1,"4");
		s2.add(s2.size()-1,"4");
	    }
    
	    if(testID == 3 ){
		s1.add("0");
		s2.add("0");
		s1.add("1");
		s2.add("1");
		s1.add(1,"5");
		s2.add(1,"5");
		s1.add(0,"6");
		s2.add(0,"6");
		s1.add(s1.size(),"4");
		s2.add(s2.size(),"4");
	    }
    
	    if(testID == 4 ){
		s1.add(0,"0");
		s2.add(0,"0");
	    }
    
	    if(testID == 5 ){
		s1.add("1");
		s2.add("1");
		for(int i = 0; i < 10; i ++){
		    String v = ""+(int)(Math.random()*1000);
		    int in = (int)(Math.random()*s2.size());
		    s1.add(in,v);
		    s2.add(in,v);
		}
	    }
    
	    if(testID == 6 ){
		try{
		    s1.get(0);
		} catch(IndexOutOfBoundsException e){
        
		}
	    }
    
	    if(testID == 7 ){
		try{
		    s1.set(0,"");
		} catch(IndexOutOfBoundsException e){
        
		}
	    }
    
	    if(testID == 8 ){
		try{
		    s1.add(1,"");
		} catch(IndexOutOfBoundsException e){
        
		}
	    }
	    if(testID == 9 ){
		s1.add("1");
		s2.add("1");
      
		for(int i = 0; i < 1000;   i ++){
		    String v = ""+(int)(Math.random()*1000);
		    int in = (int)(Math.random()*s2.size());
		    s1.add(in,v);
		    s2.add(in,v);
		}
	    }
    
    
	}catch(Exception f){
	    s2.add("0");
	    //f.printStackTrace();
	}
  
	if(equals(s1,s2)){
	    System.out.println("Test "+testID+",PASS");
	}else{
	    System.out.println("Test "+testID+",FAIL");
	}
       
  
  
    }
    public static boolean equals(SuperArray s, ArrayList<String> a){
    if(s.size() == a.size()){
      for(int i = 0; i < s.size(); i++){
        if(! s.get(i).equals( a.get(i))){
          return false;
        }
      }
      return true;
    }
    return false;
  }


  //constructors
  public SuperArray(int arySize){
    if (arySize<0){
      arySize = 0;
    }
    size = 0;
    data = new String[arySize];
  }
  public SuperArray(){
    this(10);
  }
  //testing methods
  public int dsize(){
    return data.length;
  }
  public void resizee(){
    resize();
  }

  //methods phase 1
  public void clear(){
    for (int i = 0; i < size; i++){
      data[i] = null;
    }
    size = 0;
  }
  public int size(){
    return size;
  }
  public boolean isEmpty(){
    return size == 0;
  }
  public boolean add(String element){ //could implement resize()
    if (size == data.length){
      String[] nray = new String[size+1];
      for (int i = 0; i < size; i++){
        nray[i] = data[i];
      }
      nray[size] = element;
      size++;
      data = nray;
      return true;
    }
    data[size] = element;
    size++;
    return true;
  }
  public String toString(){
    String kappa = "";
    for (int i = 0; i < size; i ++){
      if (i != size-1){
        kappa+= data[i];
        kappa+= ", ";
      }
      else if (i == size-1){
        kappa+= data[i];
      }
      else{ // this should never happen lol
        kappa+= "YA DUN GOOFED";
        System.out.println("good to string btw");
      }
    }
      return "["+kappa+"]";
  }
  public String get(int index){
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException("the index is out of range (index < 0 || index >= size())");
    }
    return data[index];
  }
  public String set(int index, String element){
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException("the index is out of range (index < 0 || index >= size())");
    }
    String cmonBruh = data[index];
    data[index]=element;
    return cmonBruh;
  }

  //phase 2 methods
  private void resize(){
    if (data.length<=5){
      String[] nray = new String[10];
      for (int i = 0; i < size; i++){
        nray[i] = data[i];
      }
      data = nray;
      //System.out.println("DOGS");
    }
    else{
      String[] nray = new String[data.length*2];
      for (int i = 0; i < size; i++){
        nray[i] = data[i];
      }
      data = nray;
    }
  }

  //phase 3 methods
  public boolean contains(String target){ //didnt work with the driver i used sometimes
    for (int i = 0; i < size; i++){
      if (data[i] == target) return true;
    }
    return false;
  }
  public int indexOf(String target){ //didnt work with the driver i used sometimes
    if (!contains(target)) return -1;
    for (int i = 0; i < size; i++){
      if (data[i] == target) return i;
    }
    System.out.println("lucky number 38!");
    return 38; //this should NEVER happen -- unless it really is 38 x))
  }
  public int lastIndexOf(String target){
    if (!contains(target)) return -1;
    for (int i = size-1; i >= 0; i--){
      if (data[i] == target) return i;
    }
    System.out.println("lucky number 38!");
    return 38; //this should NEVER happen -- unless it really is 38 x))
  }
  public void add(int index, String element){
    if (index < 0 || index > size){
       throw new IndexOutOfBoundsException("the index is out of range (index < 0 || index >= size())");
    }
    else{
      while (size == data.length || index >= data.length){
        resize();
      }
      if (index == size){
        data[index]=element;
      }
      else if (index < size){
        String[] nray = new String[dsize()];
        for (int i = 0; i < index; i++){
          nray[i] = data[i];
        }
        nray[index] = element;
        for (int i = index; i < size; i++){
          nray[i+1] = data[i];
        }
        data = nray;
      }
      else{
        System.out.println("something has went horribly awry"); //not supposed to happen
      }
      size++;
    }
  }
  public String remove(int index){
    if (index < 0 || index >= size){
       throw new IndexOutOfBoundsException("the index is out of range (index < 0 || index >= size())");
    }
    String target;
    String[] nray = new String[size];
    for (int i = 0; i < index; i++){
      nray[i] = data[i];
    }
    for (int i = index; i+1 < size; i++){
      nray[i] = data[i+1];
    }
    target = data[index];
    data = nray;
    size--;
    return target;
  }
  public boolean remove(String element){ //didnt work with my driver i used sometimes
    if (contains(element)){
      remove(indexOf(element));
      return true;
    }
    return false;
  }

}
