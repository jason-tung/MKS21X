import java.util.*;
public class Sorts{
  
  public static void main(String[]args){
    int[] poopypants = new int[10];
    for (int i =0; i < 10; i++){
      poopypants[i]=(int)(Math.random()*100);
    }
    int[] emptyAry = new int[0];
    int[] oneAry = new int[1];
    oneAry[0] = 0;
    int[] twoAryF = new int[2];
    int[] twoAryB = new int[2];
    for (int i =0; i < 2; i++){
      twoAryF[i] = 4+3*i;
      twoAryB[1-i] = 4 + 3*i;
    }
    int[] thrAryF = new int[3];
    int[] thrAryB = new int[3];
    for (int i =0; i < 3; i++){
      thrAryF[i] = 4+3*i;
      thrAryB[2-i] = 4 + 3*i;
    }

    int[] fvAryF = new int[5];
    int[] fvAryB = new int[5];
    for (int i =0; i < 5; i++){
      fvAryF[i] = 4+3*i;
      fvAryB[4-i] = 4 + 3*i;
    }
    int[] pp = poopypants.clone();
    //--------------------CHANGE SORT HERE--------------------//
    //wow emacs cmds make this so ez!! emacs masterrace!
    insertionSort(pp);
    insertionSort(emptyAry);
    insertionSort(oneAry);
    insertionSort(twoAryF);
    insertionSort(twoAryB);
    insertionSort(thrAryF);
    insertionSort(thrAryB);
    insertionSort(fvAryF);
    insertionSort(fvAryB);
    //--------------------CHANGE SORT HERE--------------------//
    boolean tester = true;
    System.out.println("----empty ary----");
    System.out.println(d(emptyAry));
    tester &= d(emptyAry).equals("[]");
    System.out.println("----one element ary----");
    System.out.println(d(oneAry));
    tester &= d(oneAry).equals("[0]");
    System.out.println("----two element ary forwards----");
    System.out.println(d(twoAryF));
    tester &= d(twoAryF).equals("[4,7]");
    System.out.println("----two element ary backwards----");
    System.out.println(d(twoAryB));
    tester &= d(twoAryB).equals("[4,7]");
    System.out.println("----three element ary forwards----");
    System.out.println(d(thrAryF));
    tester &= d(thrAryF).equals("[4,7,10]");
    System.out.println("----three element ary backwards----");
    System.out.println(d(thrAryB));
    tester &= d(thrAryF).equals("[4,7,10]");
    System.out.println("----five element ary forwards----");
    System.out.println(d(fvAryF));
    tester &= d(fvAryF).equals("[4,7,10,13,16]");
    System.out.println("----five element ary backwards----");
    System.out.println(d(fvAryB));
    tester &= d(fvAryF).equals("[4,7,10,13,16]");
    System.out.println("----generic case verdict----");
    Arrays.sort(poopypants);
    System.out.println(d(pp));
    tester &= (Arrays.equals(pp,poopypants));
    if (tester){
      System.out.println("\nPASSED ALL TESTS\n");
    }
    else {
      System.out.println("\nFAILED A TEST\n");
    }
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
    return "09,Tung,Jason";
  }

  /*
    public static void switcheroni(int a, int b){
    int c = a;
    a = b;
    b = c;
    }
  */

}
