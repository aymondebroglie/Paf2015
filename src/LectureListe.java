import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LectureListe {

	
	public static ArrayList<String> lectureListe (String filename){
		ArrayList<String> resultat = new ArrayList<String>();
	
		FileReader fr=null;
	
	BufferedReader br=null;
	String linetoread = null;
	
		try{
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
} 
		catch(Exception e){
			e.printStackTrace();
		}
	 try {
		 linetoread = br.readLine();
		while( linetoread != null){
			resultat.add(linetoread);
			linetoread = br.readLine();
		}
			return resultat;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 try {
		br.close();
		fr.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return resultat;

}
}
