import java.util.*;
public class Sorts{
  /***
  public static void main(String[]args){
    int [] data1 = {8,6,3,4,5,9,1,0,2,2,5,3,9,8,7},
      data2 = {0,1,2,3,4,5},
      data3 = {},
      data4 = {9,8,7,6,5,4,3,2,1,0},
      data5 = {-1,-2,-3,-2,-5,6,8,5};
  //selection sort
    Sorts.selectionSort(data1);
    Sorts.selectionSort(data2);
    Sorts.selectionSort(data3);
    Sorts.selectionSort(data4);
    Sorts.selectionSort(data5);
    System.out.println(d(data1));
    System.out.println(d(data2));
    System.out.println(d(data3));
    System.out.println(d(data4));
    System.out.println(d(data5));
  }
  ***/

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
    return "10.Tung.Jason";
  }
  /*
  public static void switcheroni(int a, int b){
    int c = a;
    a = b;
    b = c;
  }
  */

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

}
