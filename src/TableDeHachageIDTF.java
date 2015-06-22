import java.util.ArrayList;
import java.util.Hashtable;


public class TableDeHachageIDTF {

	
	public Hashtable<String, Integer> motIndice;
	public Hashtable<Integer, String> indiceMot;
	public Hashtable<Integer, String> docExemple;
	
	
	public TableDeHachageIDTF(){
		motIndice= new Hashtable<String, Integer>();
		indiceMot = new Hashtable<Integer, String>();
		docExemple = new Hashtable<Integer, String>();
		
	}
	
	public void init(ArrayList<String> init){
		
		int s = init.size();
		
		for(int i = 0; i <s; i++){
			motIndice.put(init.get(i), i);
			indiceMot.put(i, init.get(i));
		}
	}
	
	public String getMot(int i){
		return indiceMot.get(i);
	}
	public int getIndice(String mot){
		return motIndice.get(mot);
	}
	public String getTheme(int i){
		return docExemple.get(i);
	}
}
