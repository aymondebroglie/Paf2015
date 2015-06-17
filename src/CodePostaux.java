import java.util.ArrayList;


public class CodePostaux {


	
public static ArrayList<Integer> classerCode (ArrayList<String> liste){
	 ArrayList<Integer> resultat = new ArrayList<Integer>();	
	 
	 for (int i = 0 ; i <liste.size() ;i++){
		 if (liste.get(i)!= null && liste.get(i).length() > 2 ){
		 liste.set(i, liste.get(i).substring(0,2));
		try{resultat.add(i,Integer.parseInt(liste.get(i)));}
		catch(Exception e){}
		 System.out.println(resultat.get(i));
	 }
		 
	 }
	 
	 
	 return resultat;
}
	
}
