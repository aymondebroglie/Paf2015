import java.util.ArrayList;


public class CalculOccurenceVille {
			
	
	
	public static ArrayList<SebVille> calculOccurenceVille(ArrayList<String> listVille, double pourcentage){
		
		ArrayList<SebVille> resultat = new ArrayList<SebVille>();
		ArrayList<SebVille> resultat2 = new ArrayList<SebVille>();
		
		
		
		int s1 = listVille.size();
		int s2 = 0;
		int j = 0;
		int find = 0;
		double comparer = 0;
		
		
		for( int i = 0; i < s1; i++){
			
		
			while (find == 0 && j < s2){
				
				
				
				if(listVille.get(i).compareTo(resultat.get(j).getNomVille()) == 0){
					
					find = 1;
					resultat.get(j).setOccurence(resultat.get(j).getOccurence() +1);
					//resultat.get(j).setPourcentage(resultat.get(j).getOccurence()/(s2));
				}
				j = j + 1;
			}
			//System.out.println("s2 = "+s2+", j = "+j+"");
			if( find == 0){
				
				
				SebVille newVille = new SebVille(listVille.get(i), 1);
				//newVille.setPourcentage(1/(s1));
				resultat.add(newVille);
				s2 = s2 + 1;
			}
			
			find = 0;
			j = 0;
			 
			
		}
		//System.out.println(s1);
		
		for(int g = 0; g < s2; g ++){


			resultat.get(g).setPourcentage((resultat.get(g).getOccurence()*100)/(s1));
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
		
		
		int l = s2 - 1;
		

		
			
		comparer = resultat.get(l).getPourcentage();
		//System.out.println(resultat.get(l).getPourcentage());
			
		while((comparer > pourcentage) && l >=1 ){
				
			//System.out.println("je suis dans le while");
			
			SebVille transfert = resultat.get(l);
			resultat2.add(transfert);
			l = l - 1;
			comparer = resultat.get(l).getPourcentage();
			
		}
		
		if(resultat.get(0).getPourcentage() > pourcentage){
			resultat2.add(resultat.get(0));
		}
		
		
		
		
		return resultat2;
	}
}
