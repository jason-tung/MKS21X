
//testing with github
import java.util.*;
import java.io.*;

public class WordSearch{
  Random superseed = new Random();
  public static void main(String[]args){
    WordSearch jerry  = new WordSearch(9,9);
    System.out.println(jerry);
    jerry.clear();
    System.out.println("hey hey");
    System.out.println(jerry);
    System.out.println(jerry.addWordHorizontal("dog",2,6));

    System.out.println(jerry);
    System.out.println(jerry.addWordVertical("dog",2,6));
    System.out.println(jerry);
    System.out.println(jerry.addWord("cat",3+2,7,-1,-1));
    System.out.println(jerry.addWord("cat",3+3,7,-1,-1));
    System.out.println(jerry);
    //    System.out.println(jerry.data[0][8]);
    System.out.println();
    System.out.println();
    System.out.println();
  }
  private char[][] data;
  private char[][] solution;
  public int seed;
  /**Initialize the grid to the size specified
   *fill all of the positions with '_'
   *@param row is the starting height of the WordSearch
   *@param col is the starting width of the WordSearch
   */
  public WordSearch(int rows,int cols){
    data = new char[rows][cols];
    clear();
    seed = superseed.nextInt();
    Random rng = new Random(seed);
  }
  public WordSearch(int rows,int cols,String file,int s){
    data = new char[rows][cols];
    clear();
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

  /**The proper formatting for a WordGrid is created in the toString.
   *@return a String with each character separated by spaces, and rows
   *separated by newlines.
   */
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


  /**Attempts to add a given word to the specified position of the WordGrid.
   *The word is added from left to right, must fit on the WordGrid, and must
   *have a corresponding letter to match any letters that it overlaps.
   *
   *@param word is any text to be added to the word grid.
   *@param row is the vertical locaiton of where you want the word to start.
   *@param col is the horizontal location of where you want the word to start.
   *@return true when the word is added successfully. When the word doesn't fit,
   * or there are overlapping letters that do not match, then false is returned
   * and the board is NOT modified.
   */
  public boolean addWordHorizontal(String word,int row, int col){
    int Rinc = 1;
    int Cinc = 0;
    return addWord(word, row, col, Rinc, Cinc);
  }

  /**Attempts to add a given word to the specified position of the WordGrid.
   *The word is added from top to bottom, must fit on the WordGrid, and must
   *have a corresponding letter to match any letters that it overlaps.
   *
   *@param word is any text to be added to the word grid.
   *@param row is the vertical locaiton of where you want the word to start.
   *@param col is the horizontal location of where you want the word to start.
   *@return true when the word is added successfully. When the word doesn't fit,
   *or there are overlapping letters that do not match, then false is returned.
   *and the board is NOT modified.
   */
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
    for (int i =0; i < word.length();i++){
          int cTarget = Cinc * i;
          int rTarget = Rinc * i;
          if (data[row+cTarget][col+rTarget]!='_'&&data[row+cTarget][col+rTarget]!=word.charAt(i)) return false;
        }
    return bounds;
  }

}
