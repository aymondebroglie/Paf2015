import java.util.ArrayList;


public class CalculOccurenceVille {
			
	
	
	public static ArrayList<SebVille> calculOccurenceVille(ArrayList<String> listVille, double pourcentage){
		
		ArrayList<SebVille> resultat = new ArrayList<SebVille>();
		ArrayList<SebVille> resultat2 = new ArrayList<SebVille>();
		
		
		
		int s1 = listVille.size();
		int s2 = 0;
		int j = 0;
		int find = 0;
		int u = 0;
		
		
		for( int i = 0; i < s1; i++){
			
			while (find == 0 && j < s2){
				
				if(listVille.get(i).compareTo(resultat.get(j).getNomVille()) == 0){
					
					find = 1;
					resultat.get(j).setOccurence(resultat.get(j).getOccurence() +1);
					//resultat.get(j).setPourcentage(resultat.get(j).getOccurence()/(s2));
				}
				j = j + 1;
			}
			
			if( j == s2){
				SebVille newVille = new SebVille(listVille.get(i), 1);
				//newVille.setPourcentage(1/(s1));
				resultat.add(newVille);
				s2 = s2 + 1;
			}
			
			find = 0;
			j = 0;
			 
			
		}
		
		for(int g = 0; g < s2; g ++){
			resultat.get(g).setPourcentage(resultat.get(g).getOccurence()/(s2));
		}
		
		
		for (int k=0; k<s2; k++){
			int indicepetit=k;
			SebVille min=resultat.get(k);
			
			for(int h=k; h<s2; h++){
				if(resultat.get(h).getPourcentage() < min.getPourcentage()){
					min=resultat.get(h);
					indicepetit=h;
				}
			
			}
			//swap(k,indicepetit);
			SebVille transfertVille = resultat.get(k);
			resultat.set(k, resultat.get(indicepetit));
			resultat.set(indicepetit, transfertVille);
		}
		
		u = s2 - 1;
		
		while(resultat.get(u).getPourcentage() > pourcentage && u >= s2){
			resultat2.add(resultat.get(u));
			u = u - 1;
		}
		
		
		return resultat2;
	}
}
