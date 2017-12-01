import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
  private String[] data;
  private int end,cur;
  public SuperArrayIterator (String[]data,int size){
    this.data = data;
    cur = 0;
    end = size-1;
  }
  public void remove(){
    throw new UnsupportedOperationException();
  }
  public boolean hasNext(){
    return cur <= end;
  }
  public String next(){
    if (hasNext()){
      cur++;
    }
    else{

      System.exit(0);
    }
    return data[cur-1];
  }
}
