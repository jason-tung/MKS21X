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
	int[] sameAry2 = new int[2];
	for (int i =0; i < 2; i++){
	    twoAryF[i] = 4+3*i;
	    twoAryB[1-i] = 4 + 3*i;
	    sameAry2[i] = 2;
	}
	int[] thrAryF = new int[3];
	int[] thrAryB = new int[3];
	for (int i =0; i < 3; i++){
	    thrAryF[i] = 4+3*i;
	    thrAryB[2-i] = 4 + 3*i;
	}

	int[] fvAryF = new int[5];
	int[] fvAryB = new int[5];
	int[] sameAry5 = new int[5];
	for (int i =0; i < 5; i++){
	    fvAryF[i] = 4+3*i;
	    fvAryB[4-i] = 4 + 3*i;
	    sameAry5[i] = 5;
	}
    
	int[] pp = poopypants.clone();
	//--------------------CHANGE SORT HERE--------------------//
	//wow emacs cmds make this so ez!! emacs masterrace!
	System.out.println("----selectionSort----");
	selectionSort(emptyAry);
	selectionSort(oneAry);
	selectionSort(twoAryF);
	selectionSort(twoAryB);
	selectionSort(sameAry2);
	selectionSort(thrAryF);
	selectionSort(thrAryB);
	selectionSort(fvAryF);
	selectionSort(fvAryB);
	selectionSort(sameAry5);
	selectionSort(pp);
    
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
	System.out.println("----two identical elements ary----");
	System.out.println(d(sameAry2));
	tester &= d(sameAry2).equals("[2,2]");
	System.out.println("----threeelement ary forwards----");
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
	System.out.println("----five identical elements ary----");
	System.out.println(d(sameAry5));
	tester &= d(sameAry5).equals("[5,5,5,5,5]");
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

    public static boolean isSorted(int[] data){
	for(int x = 0; x < data.length - 1; x++){
	    if (data[x] > data[x+1]){
		return false;
	    }
	}
	return true;
    }
    
    public static void selectionSort(int[] data){
	if (!isSorted(data)){
	    for (int i = 0; i < data.length-1; i++){
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


    public static void bubbleSort(int[] data){
	if (!isSorted(data)){
	    for (int i = 0; i < data.length-1; i++){
		for (int j = 0; j < data.length-1-i; j++){
		    if (data[j+1]<data[j]){
			int holder = data[j+1];
			data[j+1] = data[j];
			data[j] = holder;
		    }
		}
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
