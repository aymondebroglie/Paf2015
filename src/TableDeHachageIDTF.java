
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
		docExemple.put(0, "aeronotique");
		docExemple.put(1, "bio-technologie");
		docExemple.put(2, "chimie organique");
		docExemple.put(3, "communication numerique");
		docExemple.put(4, "energie");
		docExemple.put(5, "instrument de mesure");
		docExemple.put(6, "pompe");
		docExemple.put(7, "technologie informatique");
		docExemple.put(0, "technologie médical");
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
