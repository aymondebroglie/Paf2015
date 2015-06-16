import java.util.ArrayList;


public class CalculOccurenceVille {
			
	
	
	public static ArrayList<SebVille> calculOccurenceVille(ArrayList<String> listVille){
		
		ArrayList<SebVille> resultat = new ArrayList<SebVille>();
		
		int s1 = listVille.size();
		int s2 = 0;
		int j = 0;
		int find = 0;
		
		
		for( int i = 0; i < s1; i++){
			
			while (find == 0 && j < s2){
				
				if(listVille.get(i).compareTo(resultat.get(j).getNomVille()) == 0){
					
					find = 1;
					resultat.get(j).setOccurence(resultat.get(j).getOccurence() +1);
					resultat.get(j).setPourcentage(resultat.get(j).getOccurence()/(s2));
				}
				j = j + 1;
			}
			
			if( j == s2){
				SebVille newVille = new SebVille(listVille.get(i), 1);
				newVille.setPourcentage(1/(s1));
				resultat.add(newVille);
				s2 = s2 + 1;
			}
			
			find = 0;
			j = 0;
			 
			
		}
		
		
		
		
		return resultat;
	}
}
