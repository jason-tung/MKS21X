//dogs and cats 123 123 123

//testing with github
import java.util.*;
import java.io.*;

public class WordSearch{
  public static void main(String[]args){
    WordSearch jerry  = new WordSearch(9,9);
    /*
    System.out.println(jerry);
    jerry.clear();
    System.out.println("hey hey");
    System.out.println(jerry);
    System.out.println(jerry.addWordHorizontal("dog",2,6));
    System.out.println(jerry);
    System.out.println(jerry.addWordVertical("dog",2,6));
    System.out.println(jerry);
    System.out.println(jerry.addWord("cat",3+2,7,-1,-1));
    System.out.println(jerry);
    System.out.println(jerry.addWord("cat",3+3,7,-1,-1));
    System.out.println(jerry);
    System.out.println(jerry.addWord("supersfla",0,0,0,1));
    System.out.println(jerry);
    //    System.out.println(jerry.data[0][8]);
    WordSearch poo  = new WordSearch(9,9,"test.txt");
       WordSearch poo2  = new WordSearch(9,9,"afdaf.sal");
    */
    System.out.println();
    System.out.println();
    System.out.println();
  }
  private char[][] data;
  private char[][] solution;
  private int seed;
  private ArrayList<String> wordsToAdd = new ArrayList<>();
  private ArrayList<String> wordsAdded = new ArrayList<>();

  public WordSearch(int rows,int cols){
    data = new char[rows][cols];
    clear();
    Random superseed = new Random();
    seed = superseed.nextInt();
    Random rng = new Random(seed);
  }
  public WordSearch(int rows,int cols,String filename){
    data = new char[rows][cols];
    clear();
    Random superseed = new Random();
    seed = superseed.nextInt(10000);
    Random rng = new Random(seed);
    try{
      Scanner in = new Scanner(new File(filename));
      while (in.hasNext()){
        wordsToAdd.add(in.next().toLowerCase());
        }
      //  System.out.println(wordsToAdd);// this was for testing :))
    }
    catch (FileNotFoundException e){
      System.out.println("hmm can't find the file -- please fix!");
      System.exit(1);
    }
    System.out.println("your seed is : "+seed);
  }

  /**Set all values in the WordSearch to underscores'_'*/
  private void clear(){
    char[] dog = new char[data.length];
    for (int i =0; i<data.length;i++){
      for (int x = 0; x<data[0].length;x++){
          data[i][x]='_';
      }
    }
  }

  public String toString(){
    String srch = "";
    for (char[] row:data){
      for (char letter:row){
        srch += letter;
        srch+= " ";
      }
      srch = srch.substring(0,srch.length()-1);
      srch+="\n";
    }
    return srch;
  }

  public boolean addWordHorizontal(String word,int row, int col){
    int Rinc = 1;
    int Cinc = 0;
    return addWord(word, row, col, Rinc, Cinc);
  }

  public boolean addWordVertical(String word,int row, int col){
    int Rinc = 0;
    int Cinc = 1;
    return addWord(word, row, col, Rinc, Cinc);
  }


  public boolean addWord(String word, int row, int col, int Rinc, int Cinc){

    if (row > data.length || col > data[0].length){
      return false;
    }

    int len = word.length();
    if(canAdd(word, row, col, Rinc, Cinc)){
      try{
        for (int i =0; i < word.length();i++){
          int cTarget = Cinc * i;
          int rTarget = Rinc * i;
          data[row+cTarget][col+rTarget] = word.charAt(i);
        }
        return true;
      }
      catch(IndexOutOfBoundsException e){
        return false;
      }
    }
    return false;
  }
  private  boolean canAdd(String word, int row, int col, int Rinc, int Cinc){
    int len = word.length();
    boolean bounds =  row+len*Rinc>=0 && col+len*Cinc>=0;
    try{
      for (int i =0; i < word.length();i++){
        int cTarget = Cinc * i;
        int rTarget = Rinc * i;
        if (data[row+cTarget][col+rTarget]!='_'&&data[row+cTarget][col+rTarget]!=word.charAt(i)) return false;
      }
    }
    catch(IndexOutOfBoundsException e){
      return false;
    }
    return bounds;
  }

}
