public class Barcode implements Comparable<Barcode>{
    public String code, zip;

    public Barcode(String zip){
        String[] dog = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|"	
			,"|::|:","|:|::"}
	    for (char chr: zip.toCharArray()){
		
