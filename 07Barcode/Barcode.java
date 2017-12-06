import java.util.*;

public class Barcode implements Comparable<Barcode>{
  public String zip;

  public Barcode(String zip){
    if (zip.length()!=5){
      throw new IllegalArgumentException("zip is not correct len || zip has non digit");
    }
    for (int i = 0; i < zip.length(); i++){
      if (!Character.isDigit(zip.charAt(i))){
        throw new IllegalArgumentException("zip is not correct len || zip has non digit");
      }
    }
    this.zip = zip;
  }

  public String toString(){
    return getCode() + " ("+zip+")";
  }

  public int compareTo(Barcode other){
    return Integer.valueOf(zip)-Integer.valueOf(other.getZip());
  }
  
  public static String toCode(String zip){
    if (zip.length()!=5){
      throw new IllegalArgumentException("zip is not correct len || zip has non digit");
    }
    for (int i = 0; i < zip.length(); i++){
      if (!Character.isDigit(zip.charAt(i))){
        throw new IllegalArgumentException("zip is not correct len || zip has non digit");
      }
    }
    String[] dog = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    String code = "|";
    int wapow = 0;
    for (int i = 0; i < zip.length();i++){
      int digit = Integer.valueOf(zip.charAt(i)+"");
      wapow += digit;
      code+=dog[digit];
    }
    code += dog[wapow%10] + "|";
    return code;
  }

  public String getZip(){
    return zip;
  }

  public String getCode(){
    return toCode(zip);
  }
  
  public static String toZip(String code){
    try{
      if (legit(code)){
        String bode = code.substring(1,31);
        String ret = "";
        String[] dog = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
        ArrayList<String> doge = new ArrayList<String>();
        for (String s:dog){
          doge.add(s);
        }
        for (int i = 0; i < 5; i++){
          ret += doge.indexOf(bode.substring(5*i,5*i+5));
        }
        return ret;
      }
      throw new IllegalArgumentException("bad barcode");
    }
    catch (Exception e){
      throw new IllegalArgumentException("bad barcode");
    }
  }
  
  private static boolean legit(String code){
    if (code.length() != 32){
        return false;
      }
      try{
        String bode = code.substring(1,31);
      String[] dog = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
      ArrayList<String> doge = new ArrayList<String>();
      for (String s:dog){
        doge.add(s);
      }
      int[] cat = new int[6];
      for (int i = 0; i < 6; i++){
        int hm = doge.indexOf(bode.substring(5*i,5*i+5));
        //   System.out.println(bode.substring(5*i,5*i+5));
        //    System.out.println(hm);
        if (hm == -1){
          return false;
        }
        cat[i]=hm;
      }
      if ((cat[0]+cat[1]+cat[2]+cat[3]+cat[4])%10==cat[5]){
        return true;
      }
      return false;
         }
     catch (Exception e){
        return false;
      }
  }
  












  /* ----------------------------------------------*/
  public static void main(String[] args){
    Barcode jerry = new Barcode("36751");
    Barcode lerry = new Barcode("36749");
    Barcode serry = new Barcode("36751");
    Barcode merry = new Barcode("36753");
    /*
    System.out.println(jerry.getCode());
    System.out.println(jerry.zip);
    System.out.println(jerry);
    System.out.println(jerry.compareTo(lerry));
    System.out.println(jerry.compareTo(serry));
    System.out.println(jerry.compareTo(merry));
    */
    System.out.println(legit("|::||::|:::|:|:|::::||::|:||"));
    System.out.println("----");
    System.out.println(legit("|::||::||::|:|||:|:|:|::::||::|:|"));
    System.out.println(legit("|::||::||::|:::|:|:|::::||::|:|"));
    System.out.println(legit(lerry.getCode()));
    System.out.println(jerry.getZip());
    System.out.println(toZip(jerry.getCode()));
    

    
  }
}
