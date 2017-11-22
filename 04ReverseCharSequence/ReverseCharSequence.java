public class ReverseCharSequence implements CharSequence{
    public static void main(String[] args){
    }
    private char[] str;

    public ReverseCharSequence(String s){
        char[] oldray = s.toCharArray();
	char[] newray = new char[s.length()];
	for (int i = s.length(); i >= 0; i--){
	    newray[s.length()-i] = oldray[i];
	}
    }

    public char charAt(int index){
	return str[index];
    }

    public int length(){
	return str.length;
    }

    public 
}
