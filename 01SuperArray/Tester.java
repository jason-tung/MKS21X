import java.util.*;

public class Tester{
    public static void main(String[] args){
	for (int x= 0; x <= 9; x++){
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
	    //f.printStackTrace();
	}
  
	Collections.sort(s2);
	if(equals(s1,s2)){
	    System.out.println("Test "+testID+",PASS");
	}else{
	    System.out.println("Test "+testID+",FAIL!");// "+s1+"!="+s2);
	}
    }




    //Tested your sorts on:
    // - size 0, size 1 (mode doesn't matter)
    // - size 1000 in all 3 modes for all 3 sorts

    //SORT: 0=Bubble, 1=Selection, 2=Insertion
    //MODE: 0=Increasing, 1=Decreasing, 2= randomized
    //SIZE: Size of array
    public static void runTest08(int SORT, int SIZE, int MODE){
	//This is super ugly, I repurposed old code
	//Sorry!
	int[]inc = new int[SIZE];
	int[]dec = new int[SIZE];
	int[]rnd = new int[SIZE];
	int[][] arrays = new int [6][];
  
	for(int i = 0; i < inc.length; i ++){
	    inc[i] = -10000 + 10 * i + (int)(Math.random()*5);
	    dec[SIZE-i-1] = inc[i];
	    rnd[i] = (int)(Math.random() * 20000000)-10000000;
	}
	arrays[3]= inc;
	arrays[4]= dec;
	arrays[5]= rnd;
	arrays[0]=Arrays.copyOf(inc,SIZE);
	arrays[1]=Arrays.copyOf(dec,SIZE);
	arrays[2]=Arrays.copyOf(rnd,SIZE);
	Arrays.sort(inc);
	Arrays.sort(dec);
	Arrays.sort(rnd);
  
	sort(arrays[MODE],SORT);
  
	if( ! Arrays.equals(arrays[MODE+3],arrays[MODE]) ) {
	    System.out.println("FAIL! "+methodName(SORT)+" Mode:"+MODE+" Size:"+SIZE);
	}else{
	    System.out.println("PASS! "+methodName(SORT)+" Mode:"+MODE+" Size:"+SIZE);
	}
    }

    public static void sort(int[]ary,int method){
	try{
	    if(method == 0){
		Sorts.bubbleSort(ary);
	    }
	    if(method == 1){
		Sorts.selectionSort(ary);
	    }
	    if(method == 2){
		Sorts.insertionSort(ary);
	    }
	}catch ( Exception e){
	    e.printStackTrace();
	}
    }
    public static String methodName(int i){
	String[]names = {"Bubble","Selection","Insertion","Built In"};
	return names[i];
    }
}
