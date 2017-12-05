public class Barcode{// implements Comparable<Barcode>{
  public String code,zip;

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
    String[] dog = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    code = "|";
    int wapow = 0;
    for (int i = 0; i < zip.length();i++){
      int digit = Integer.valueOf(zip.charAt(i)+"");
      wapow += digit;
      code+=dog[digit];
    }
    code += dog[wapow%10] + "|";
  }

  public String toString(){
    return code + " ("+zip+")";
  }

  public String getCode(){
    return code;
  }

  












  /* ----------------------------------------------*/
  public static void main(String[] args){
    Barcode jerry = new Barcode("00294");
    System.out.println(jerry.getCode().compareTo("|||:::||:::::|:||:|:::|::|:|:|:|"));
    System.out.println(jerry.zip);
    System.out.println(jerry);
  }
}
