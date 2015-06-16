import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ListePrenom {
	
	private ArrayList<Prenom> ListePrenom;
	
	public ListePrenom(){
		
		 ListePrenom = new ArrayList<Prenom>();
	}
	
	public ArrayList<Prenom> getListePrenom(){
		return ListePrenom;
	}
	
	
	
	
	
	
	
	
	
	public final void initTextFile(String filename){
		
		
		FileReader fr=null;
		BufferedReader br=null;
		String [] intermediaire = null;
		int i = 0;
		
			try{
				fr = new FileReader(filename);
				br = new BufferedReader(fr);
				String lineToRead=null;
				
				//while((line = br.readLine()) != null){
				//	System.out.println(line);
				//}
				
				
					
				lineToRead = br.readLine();
				
				while (lineToRead != null){
	
					if( i == 0){
						lineToRead = br.readLine();
						i = 1;
					}
					
					lineToRead.replaceAll("	", " ");
					intermediaire = lineToRead.split("	");
				//System.out.println("prenom = "+intermediaire[0]+", genre = "+intermediaire[1]+"");
					
					
					if( intermediaire[1].compareTo("m,f") != 0){
						if( intermediaire[1].compareTo("f,m") != 0){
							//System.out.println("je passe le if");
							Prenom prenom = new Prenom();
							prenom.setGenre(intermediaire[1]);
							prenom.setPrenom(intermediaire[0]);
							ListePrenom.add(prenom);
						}
					}
					
					lineToRead = br.readLine();
					
					
				}
				
			}
			
			
			catch(FileNotFoundException e){
				System.err.println("Error class ListePrenom, initFromTextFile: File not found :\""+filename+"\"");
			}
			catch(IOException e){
				System.out.println("Error class ListePrenom, initFromTextFile: read error: \""+filename+"\"");
			}
			catch (Exception e){
				System.err.println("Error: unknown error");
				e.printStackTrace(System.err);
			}
			finally {
				if(fr !=null){
					try{
						fr.close();
					}	
					catch(Exception e){}
					
				}
				if(br !=null){
					try{
						br.close();
					}	
					catch(Exception e){}
					
				}
			}
			
		}
	
	public Resultat getStat(ArrayList<String> listeACompare){
		
		
		int s1 = listeACompare.size();
		int s2 = ListePrenom.size();
		
		int find = 0;
		int j = 0;
		
		double m = 0;
		double f = 0;
		double u = 0;
		
		for(int i = 0; i < s1; i++){
			//System.out.println("boucle for");
			while(find == 0 && j < s2){				
				
				//System.out.println("boucle while");
				if(listeACompare.get(i).compareTo(ListePrenom.get(j).getPrenom()) == 0){					
					find = 1;
					
					if(ListePrenom.get(j).getGenre().compareTo("m") == 0){
						m = m +1;
					}
					
					else{
						f = f +1;
					}
				}
				
				j = j+1;
			}
			
			if (j == s2){
				u = u+1;
			}
			
			j = 0;
			find = 0;
		}
		
		m = (m/s1)*100;
		f = (f/s1)*100;
		u = (u/s1)*100;
		
		Resultat resultat = new Resultat(m,f,u);
		
		
		return resultat;
	}
}

