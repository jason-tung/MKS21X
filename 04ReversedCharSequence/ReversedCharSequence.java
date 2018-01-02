public class ReversedCharSequence implements CharSequence{
  
  
  public static void main(String[] args){
    ReversedCharSequence jerry = new ReversedCharSequence("");
    System.out.println(jerry);
    // System.out.println(jerry.charAt(0));
    System.out.println(jerry.length());
    // System.out.println(jerry.subSequence(0,3));
    
  }
  
  
  private String str = "";

  public ReversedCharSequence(String s){
    char[] c = s.toCharArray();
    for (int i = c.length-1; i >= 0; i--){
      str += c[i];
    }
  }

  public char charAt(int index){
    return str.charAt(index);
  }

  public int length(){
    return str.length();
  }

  public CharSequence subSequence(int s, int e){
    return str.substring(s,e);
  }

  public String toString(){
    return str;
  }

}
