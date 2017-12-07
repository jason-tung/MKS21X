import java.util.*;
public class Sorts{

  public static void main(String[]args){
    int[] poopypants = new int[10];
    for (int i =0; i < 10; i++){
      poopypants[i]=(int)(Math.random()*100);
    }
    int[] pp = poopypants.clone();
    //--------------------CHANGE SORT HERE--------------------//
    insertionSort(pp); //selectionSort(pp);
    //--------------------CHANGE SORT HERE--------------------//
    System.out.println(d(pp));
    Arrays.sort(poopypants);
    System.out.println(d(pp));
    System.out.println(Arrays.equals(pp,poopypants));
  }

  public static void selectionSort(int[] data){
    for (int i = 0; i < data.length; i++){
      int minIndex = i;
      for (int j = i+1; j < data.length;j++){
        if (data[j] < data[minIndex]){
          minIndex = j;
        }
      }
      if (minIndex!=i){
        int hol = data[i];
        data[i] = data[minIndex];
        data[minIndex] = hol;
      }
    }
  }

  public static void insertionSort(int[] data){
    for (int i = 1; i < data.length; i++){
      int tracker = i;
      while (tracker != 0 && data[tracker]<data[tracker-1]){
        int holder = data[tracker];
        data[tracker] = data[tracker-1];
        data[tracker-1] = holder;
        tracker--;
      }
    }
  }
  /*
  public static void swapSpot(int[]data,int index){
    int tracker = index;
    while (tracker != 0 && data[tracker]<data[tracker-1]){
      int holder = data[tracker];
      data[tracker] = data[tracker-1];
      data[tracker-1] = holder;
      tracker--;
    }
  }
  */






















  public static String d(int[] s){
    String str = "[";
    for (int x: s){
      str += x + ",";
    }
    if (str.length()==1){
      return str+"]";
    }
    return str.substring(0,str.length()-1) + "]";
  }

  public static String name(){
    return "09.Tung.Jason";
  }

  /*
    public static void switcheroni(int a, int b){
    int c = a;
    a = b;
    b = c;
    }
  */

}
