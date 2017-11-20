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
