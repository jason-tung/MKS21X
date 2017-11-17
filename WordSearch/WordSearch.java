
//dogs and cats 123 123 123
//testing ssh

//testing with github
//sorry if my code is really messy -- i didnt have time to reorganize it!
import java.util.*;
import java.io.*;

public class WordSearch{
  public static void main(String[]args){

    if (args.length<3 || args.length >5){
      System.out.println("hmmm.. it would seem you are not familiar with the syntax or are testing my code!");
      System.out.println("try one of the following:");
      System.out.println("java rows cols filename");
      System.out.println("java rows cols filename randomSeed");
      System.out.println("java rows cols filename randomSeed answers");
      System.exit(1);

    }    if (args.length==3){
      try{
        WordSearch jerry = new WordSearch(Integer.valueOf(args[0]),Integer.valueOf(args[1]),args[2]);
        System.out.println(jerry);
        System.out.println("I was able to add:");
        System.out.println(jerry.wordsAdded);
      }
      catch (Exception e){
        System.out.println("hmmm.. it would seem you are not familiar with the syntax or are testing my code!");
        System.out.println("try the following:");
        System.out.println("java rows cols filename");
      }
    }

    else if (args.length==4){
      try{
        WordSearch jerry = new  WordSearch(Integer.valueOf(args[0]),Integer.valueOf(args[1]),args[2],Integer.valueOf(args[3]));
        System.out.println(jerry);
        System.out.println("I was able to add:");
        System.out.println(jerry.wordsAdded);
      }
      catch (Exception e){
        System.out.println("hmmm.. it would seem you are not familiar with the syntax or are testing my code!");
        System.out.println("try the following:");
        System.out.println("java rows cols filename randomSeed");
      }
    }

    else if (args.length==5){
      try{
        if (!args[4].equals("key")){
          System.out.println("you said: '" + args[4]+"'");
          System.out.println("hmmm if you want to print the solution, the last param has to be key");
          System.exit(1);
        }
        WordSearch jerry = new  WordSearch(Integer.valueOf(args[0]),Integer.valueOf(args[1]),args[2],Integer.valueOf(args[3]),args[4]);
        System.out.println(jerry);
        System.out.println("I was able to add:");
        System.out.println(jerry.wordsAdded);
      }
      catch (Exception e){
        System.out.println("hmmm.. it would seem you are not familiar with the syntax or are testing my code!");
        System.out.println("try the following:");
        System.out.println("java rows cols filename randomSeed key");
      }
    }

    else{
      System.out.println("fatal error");
      System.exit(1);
    }
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
  }

  private char[][] data;
  private char[][] solution;
  private int seed;
  private ArrayList<String> wordsToAdd = new ArrayList<>();
  private ArrayList<String> wordsAdded = new ArrayList<>();
  private Random rng;
  /*
  public WordSearch(int rows,int cols){
    data = new char[rows][cols];
    clear();
    Random superseed = new Random();
    seed = superseed.nextInt();
    Random rng = new Random(seed);
  }
  you should never need to use this jesus
  */
  public WordSearch(int rows,int cols,String filename){
    if (rows == 0){
      rows = 1;
    }
    if (cols ==0){
      cols = 1;
    }
    data = new char[rows][cols];
    clear();
    Random superseed = new Random();
    seed = superseed.nextInt(10000);
    rng = new Random(seed);
    try{
      Scanner in = new Scanner(new File(filename));
      while (in.hasNext()){
        wordsToAdd.add(in.next().toLowerCase());
        }
      //   System.out.println(wordsToAdd);// this was for testing :))
    }
    catch (FileNotFoundException e){
      System.out.println("hmm can't find the file -- please fix!");
      System.exit(1);
    }
    System.out.println("your seed is : "+seed);
    addAllWords();
    fill();
  }


  public WordSearch(int rows,int cols,String filename,int seed){
    if (rows == 0){
      rows = 1;
    }
    if (cols ==0){
      cols = 1;
    }
    data = new char[rows][cols];
    clear();
    this.seed = seed;
    rng = new Random(seed);
    try{
      Scanner in = new Scanner(new File(filename));
      while (in.hasNext()){
        wordsToAdd.add(in.next().toLowerCase());
        }
      //   System.out.println(wordsToAdd);// this was for testing :))
    }
    catch (FileNotFoundException e){
      System.out.println("hmm can't find the file -- please fix!");
      System.exit(1);
    }
    System.out.println("your seed is : "+seed);
    addAllWords();
    fill();
  }

  public WordSearch(int rows,int cols,String filename,int seed,String key){
    if (rows == 0){
      rows = 1;
    }
    if (cols ==0){
      cols = 1;
    }
    data = new char[rows][cols];
    clear();
    this.seed = seed;
    rng = new Random(seed);
    try{
      Scanner in = new Scanner(new File(filename));
      while (in.hasNext()){
        wordsToAdd.add(in.next().toLowerCase());
        }
      //   System.out.println(wordsToAdd);// this was for testing :))
    }
    catch (FileNotFoundException e){
      System.out.println("hmm can't find the file -- please fix!");
      System.exit(1);
    }
    System.out.println("your seed is : "+seed);
    addAllWords();

  }

  private void fill(){
    for (int i =0; i < data.length; i++){
      for (int x = 0; x < data[0].length;x++){
        if (data[i][x]=='_'){
          data[i][x]=(char)(97+rng.nextInt(26));
        }
      }
    }
  }

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

  /*
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


  */
  public void scramble(){
    for (int i =0; i < wordsToAdd.size(); i++){
      if (rng.nextInt(2)==0){
        wordsToAdd.add(wordsToAdd.get(i));
        wordsToAdd.remove(i);
      }
    }
  }
  public void addAllWords(){
    scramble();
    for (String words:wordsToAdd){
      int i = 0;
      int rinc = rng.nextInt(2)-1;
      int cinc = rng.nextInt(2)-1;
      while (rinc == 0 && cinc == 0){
        rinc = rng.nextInt(2)-1;
        cinc = rng.nextInt(2)-1;
      }
      while (!addWord(words, rng.nextInt(data.length+1),rng.nextInt(data[0].length+1),rinc,cinc)&&i < 1000){
        i++;
        rinc = rng.nextInt(2)-1;
        cinc = rng.nextInt(2)-1;
        while (rinc == 0 && cinc == 0){
          rinc = rng.nextInt(2)-1;
          cinc = rng.nextInt(2)-1;
        }
      }
      if (i < 999){
        wordsAdded.add(words);
      }
    }

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
