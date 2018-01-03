import java.util.*;
public class OrderedSuperArray extends SuperArray{
  public OrderedSuperArray(){
    super(10);
  }
  public OrderedSuperArray(int size){
    super(size);
  }
  public OrderedSuperArray(String [] ary){
    super();
    for (String x: ary){
      add(x);
    }
  }
    public static void main(String[] args){
	for (int x = 0; x < 9; x ++){
	    runTest02(x);
	}
	runTest02(3);
	
    }

    
public static void runTest02(int testID){
  
  if(testID<0){
    System.out.println("Error in driver usage!");
    System.exit(0);
  }
  
  OrderedSuperArray s1 = new OrderedSuperArray();
  ArrayList<String> s2 = new ArrayList<>();
  
  try{
    if(testID == 0 ){
    }
    
    if(testID == 1 ){
      s1.add("4");
      s2.add("4");
      s1.add("1");
      s2.add("1");
      s1.add("0");
      s2.add("0");
    }
    
    if(testID == 2 ){
      s1.add("3");
      s2.add("3");
      s1.add("1");
      s2.add("1");
      s1.add("5");
      s2.add("5");
      s1.add("0");
      s2.add("0");
    }
    
    if(testID == 3 ){
      s1.add("1");
      s2.add("1");
      for(int i = 0; i < 10; i ++){
        String v = ""+(int)(Math.random()*1000);
        int in = (int)(Math.random()*s2.size());
        s1.add(in,v);
        s2.add(in,v);
      }
      System.out.println(s1);
      System.out.println(s2);
      
    }
    
    if(testID == 4 ){
      s1.add("1");
      s2.add("1");
      try{
        s1.set(0,"");
      } catch(UnsupportedOperationException e){
        
      }
    }
    
    if(testID == 5 ){
      try{
        s1.set(0,"");
      } catch(UnsupportedOperationException e){
        
      }
    }
    
    if(testID == 6 ){
      String[] x= {"adsf","b","X","C","fish","cat","Abby","break","romp"};
      s1 = new OrderedSuperArray(x);
      s2.addAll(Arrays.asList(x));
    }
    if(testID == 7 ){
      s1.add("1");
      s2.add("1");
      
      for(int i = 0; i < 1000;   i ++){
        String v = ""+(int)(Math.random()*1000);
        s1.add(v);
        s2.add(v);
      }
    }
    
    
  }catch(Exception f){
    s2.add("0");
    // f.printStackTrace();
  }
  
  Collections.sort(s2);
  if(equals(s1,s2)){
    System.out.println("Test "+testID+",PASS");
  }else{
          System.out.println("Test "+testID+",FAIL!");// "+s1+"!="+s2);
      System.out.println(s1);
      System.out.println(s2);

  }
}


//oops!
public static boolean equals(OrderedSuperArray s, ArrayList<String> a){
    if(s.size() == a.size()){
      for(int i = 0; i < s.size(); i++){
        if(!s.get(i).equals( a.get(i))){
          return false;
        }
      }
      return true;
    }
    return false;
  }


  //testing method
  //  public boolean v(int i, String value){
  //   super.add(i, value);
  //   return true;
  // }

  public int findIndex(String element){
    for (int i = 0; i < size(); i++){
      if (element.compareTo(get(i))<=0) return i;
    }
    return size();
  }

  public int findIndexBinary(String element){//i worked with nick chan to do this -- he showed me a diagram with the three cases
    int s = 0;//starting pos
    int e = size()-1;//endingpos
    int c = 0;//place for next division
    while (s <= e){
      c = ( s + e )/2;//set the place for next division
      if (element.compareTo(get(c))<0) e = c-1;//if element < middle, the end should be less than the middle
      else if (element.compareTo(get(c))>0) s = c +1;// if element > middle, start should be more than the middle
      else{
        while(c >=1 && get(c-1)==element) c-=1;// find index where element is ==, but the previous element is not || the there is no previous element
        return c;//return the first instance where element is ==
      }
    }
    return s;//return for when s == e
  }

  public int indexOfBinary(String element){
    int s = 0;
    int e = size()-1;
    int c = 0;
    while (s <= e){
      c = ( s + e )/2;
      if (element.compareTo(get(c))<0) e = c-1;
      else if (element.compareTo(get(c))>0) s = c +1;
      else{
        while(c >0 && get(c-1)==element) c-=1;
        return c;
      }
    }
    return -1;
  }
  public int lastIndexOfBinary(String element){
    int s = 0;
    int e = size()-1;
    int c = 0;
    while (s <= e){
      c = ( s + e )/2;
      if (element.compareTo(get(c))<0) e = c-1;
      else if (element.compareTo(get(c))>0) s = c +1;
      else{
        while(c >0 && get(c+1)==element) c+=1;
        return c+1;
      }
    }
    return -1;
  }



  public int indexOf(String element){
     for (int i = 0; i < size(); i++){
       if (element.equals(get(i))) return i;
    }
     return -1;
  }
  public int lastIndexOf(String element){
    for (int i = size()-1; i >= 0; i--){
       if (element.equals(get(i))) return i;
    }
     return -1;
  }


    /***
  private int indexOf(String element){

  }

  public int indexOfBinary(String element){
    return indexOf(element);
  }
  ***/
  public void add(int index, String value){
    throw new UnsupportedOperationException("do not use an index param");
  }
  public boolean add(String value){
    if (size()==0) super.add(value);
    else{
      super.add(findIndexBinary(value),value);
    }

    return true;
  }

}
