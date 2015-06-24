
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;





















import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;





public class IDTF    {

	private double idf;
	private double tf;
	private double idtf;
	private String mot;
	
	public double getIdf() {
		return idf;
	}

	public void setIdf(double idf) {
		this.idf = idf;
	}

	public double getTf() {
		return tf;
	}

	public void setTf(double tf) {
		this.tf = tf;
	}
	
	
	public IDTF(String mot, double idtf)
	{
		this.mot=mot;
		this.idtf=idtf;
		
	}
	public IDTF() {
		// TODO Auto-generated constructor stub
	}

	public void setIdtf(double idtf){
		this.idtf=idtf;
		
	}
	
	public double getIdtf(){
		return idtf;
	}
	
	public String getMot() {
		return mot;
	}
	
	
	  public static double tfCalculator(String[] totalterms, String termToCheck) {
	        double count = 0;  //pour compter le nombre d'occurence du terme recherché
	        for (String s : totalterms) {
	            if (s.equalsIgnoreCase(termToCheck)) {
	                count++;
	            }
	        }
	        return count / totalterms.length;
	    }
	  
	    public static double idfCalculator(ArrayList<String[]> allTerms, String termToCheck) {
	        double count = 0;
	        for (String[] ss : allTerms) {
	            for (String s : ss) {
	                if (s.equalsIgnoreCase(termToCheck)) {
	                    count++;
	                    break;
	                }
	            }
	        }
	        return Math.log((allTerms.size()+1) /1+ count);
	    }
	    
	    
	    public static double[][] getMat(ArrayList<String> dico, ArrayList<IDTF> aIdtf){
            
            TableDeHachageIDTF table= new TableDeHachageIDTF();
            table.init(dico);
            int s =  aIdtf.size();
            double [][] mat = new double[nombreDoc(aIdtf)][dico.size()];
            int n = 0;
            int j = 0;
            
            for (int i = 0; i < s ; i ++){
                    if (aIdtf.get(i).getMot().compareTo("finnn") == 0){
                            n = n + 1;
                    }
                    else{
                    	  //  if(aIdtf.get(i).getMot().compareTo("") = 0)
                            j = table.getIndice(aIdtf.get(i).getMot());
                            mat[n][j] = aIdtf.get(i).getIdtf(); 
                    }
            }
            
            
            return mat;
    }
    
	    public static double[] getLigne(double[][] mat, int l){
	    	int n=0;
	    	if (mat.length!=0)
	    		n=mat[0].length;
	    	double[] ligne= new double[n];
	    	for (int j=0; j<n;j++)
	    	{
	    		ligne[j]=mat[l][j];
	    	}
	    	return ligne;
	    }
  
	    public static int nombreDoc (ArrayList<IDTF> tout)
	    
	    {
	    	int nombreDoc=0;
	    	for( int k=0; k<tout.size();k++)
	    	{
	    		if(tout.get(k).getMot().compareTo("finnn")==0)
	    			nombreDoc++;
	    	}
	    	return nombreDoc;
	    }
	  
   public static int nombreMot (ArrayList<IDTF> tout)
	    
	    {
	    	int nombreDoc=0;
	    	for( int k=0; k<tout.size();k++)
	    	{
	    		if(tout.get(k).getMot().compareTo("finnn")!=0)
	    			nombreDoc++;
	    	}
	    	return nombreDoc;
	    }
	  
   
   public String getTheme(ArrayList<IDTF> dico, double [] compare, double [][] base){
   	String theme ="";
   	TableDeHachageIDTF docExemple = new TableDeHachageIDTF();
   	int s = base.length;
   	double min = 1;
   	double cos = 0;
   	
   	for(int i = 0; i < s; i++){
   		
   		cos = Math.abs(CosineSimilarity.cosineSimilarity(compare, base[i]));
   		if(cos < min){
   			min = cos;
   			theme = docExemple.getTheme(i);
   			
   		}
   		
   	}
   	
   	return theme;
   }
   
   public static void lectTxt(String filename, ArrayList<String> list1, ArrayList<String []> list2){
       FileReader fr=null;
           BufferedReader br=null;
           String [] intermediaire = null;
           ArrayList<String> total = new ArrayList<String>();
           int i = 0;
           int s = 0;
           int t = 0;
           
                   try{
                           fr = new FileReader(filename);
                           br = new BufferedReader(fr);
                           String lineToRead=null;
                           
                           //while((line = br.readLine()) != null){
                           //        System.out.println(line);
                           //}
                           
                           
                                   
                           lineToRead = br.readLine();
                           
                           while (lineToRead != null){
   
                                   if( i == 0){
                                           lineToRead = br.readLine();
                                           i = 1;
                                   }
                                   
                                   lineToRead.replaceAll("        ", " ");
                                   lineToRead.toLowerCase();
                                   lineToRead = lineToRead.replaceAll("é", "e");
                                   lineToRead = lineToRead.replaceAll("è", "e");
                                   lineToRead = lineToRead.replaceAll("ê", "e");
                                   lineToRead = lineToRead.replaceAll("ë", "e");
                                   lineToRead = lineToRead.replaceAll("à", "a");
                                   lineToRead = lineToRead.replaceAll("ù", "u");
                                   lineToRead = lineToRead.replaceAll("û", "u");
                                   lineToRead = lineToRead.replaceAll("ü", "u");
                                   lineToRead = lineToRead.replaceAll("ö", "o");
                                   lineToRead = lineToRead.replaceAll("ô", "o");
                                   lineToRead = lineToRead.replaceAll("î", "i");
                                   lineToRead = lineToRead.replaceAll("ï", "i");
                                   
                                   
                                   intermediaire = lineToRead.split(" ");
                                   s = intermediaire.length;
                                   for(int j =0; j < s; j++){
                                           list1.add(intermediaire[j]);
                                           total.add(intermediaire[j]);
                                           
                                   }
                                   
                                   
                                   lineToRead = br.readLine();
                                   
                                   
                           }
                           
                           t = total.size();
                           String [] intermediaire2 = new String[t+1];
                           for(int k = 0; k < t; k++ ){
                                   intermediaire2[k] = total.get(k);
                                  
                                  // System.out.println(intermediaire2[k]);
                           }
                           list1.add("finnn");
                           
                           intermediaire2[t] = "finnn";
                           list2.add(intermediaire2);
                          
                        
                        
                           
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

	    
	    
	    //tri**********************************************************************	  
	    public static ArrayList<IDTF> fusion(ArrayList<IDTF> tab1, ArrayList<IDTF> tab2)
	    {
	        int taille_g=tab1.size();
	        int taille_d=tab2.size();
	        ArrayList<IDTF> res= new ArrayList<IDTF>();
	        int i_g=0;
	        int i_d=0;
	        int i;
	        for( i=0;i_g<taille_g && i_d<taille_d;i++)
	            if(tab1.get(i_g).getIdtf() <= tab2.get(i_d).getIdtf())
	                res.add(i, tab1.get(i_g++));
	            else
	            	res.add(i, tab2.get(i_d++));
	            /* on copie le reste du tableau de gauche (s'il reste quelque chose) */
	            while(i_g<taille_g)
	            	res.add(i++, tab1.get(i_g++));
	            while(i_d<taille_d)
	            	res.add(i++, tab2.get(i_d++));		          
	        return res;
	    }
	     
	    public static ArrayList<IDTF> copie(ArrayList<IDTF> tab, int debut, int fin)
	    {
	    	ArrayList<IDTF> res= new ArrayList<IDTF>(); 
	        for(int i=debut;i<=fin;i++)
	        {
	        	res.add(i-debut, tab.get(i));
	        }
	        return res;
	    }
	 
	    public static ArrayList<IDTF> tri_fusion(ArrayList<IDTF> tab)
	    {
	        int taille = tab.size();
	        if(taille<=1)
	            return tab;
	        else
	        {
	            int mileu = taille/2;
	            ArrayList<IDTF> gauche = copie(tab,0,mileu-1);
	            ArrayList<IDTF> droite = copie(tab,mileu,taille-1);
	            return fusion(tri_fusion(gauche),tri_fusion(droite));
	        }
	    }
	    /*public static ArrayList<IDTF> tri(ArrayList<IDTF> base, ArrayList<String> dico){           
            TableDeHachageIDTF table = new TableDeHachageIDTF();
            table.init(dico);
            IDTF transfert = new IDTF();
            String j = "";
            int find = 0;
            int k = 0;
            
            for (int i = 0; i < dico.size()-1; i ++){
                    j = table.getMot(i);
                    if(j.compareTo(base.get(i).getMot()) != 0){
                            
                            k = i;
                            while (find == 0 && (k< base.size())){
                                    
                                    if(j.compareTo(base.get(k).getMot()) == 0){
                                            find = 1;
                                            transfert = base.get(i);
                                        base.add(k, base.get(i));
                                        base.add(i, transfert);
                                    }
                                    k = k + 1;
                            }
                            
                            find = 0;
                            
                    }
            }
            return base;
            
    }
	    */
     //fin tri**********************************************************************************
	    
	    
	    
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 
		ArrayList<String[]> listTitre = new ArrayList<String[]>();   // liste qui contient la description de chaque brevet: 1 élement = 1 brevet
		ArrayList<String> tout= new ArrayList<String>();             // liste qui contient tous les mots de chaque brevet
		int i=1;
        int j=0;
		
		
		
		try {
			 
			File repertoire= new File("C:/Users/Mehdi/Desktop/tr");
			 String[] listefichiers = repertoire.list();
            
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            for (int k=0; k<listefichiers.length;k++)
            {
            	 if(listefichiers[k].endsWith(".xml")==true)
            	 {             
		            File fXmlFile = new File("C:/Users/Mehdi/Desktop/tr/"+listefichiers[k]);
		            Document doc = dBuilder.parse(fXmlFile);
		            fXmlFile.renameTo(new File("C:/Users/Mehdi/Desktop/tr/"+k+".xml"));
		            
		            doc.getDocumentElement().normalize();
		            NodeList nList = doc.getElementsByTagName("abstract");
		            
		            for (int temp = 0; temp < nList.getLength(); temp++)
		            {
		                     
		                    Node nNode = nList.item(temp);
		     
		     
		                    if (nNode.getNodeType() == Node.ELEMENT_NODE) 
		                    {
		                            j=0;
		                            Element eElement = (Element) nNode;
		                           
		                                    
		                            if (eElement.getElementsByTagName("p").item(j)!=null)
		                            {
		                                i=1;
		                            }
		                            while (i>0)
		                            { 
			                           String s= eElement.getElementsByTagName("p").item(j).getTextContent().toLowerCase();
			                           j++;
			                           String[] parts= s.split(" ");
			                           listTitre.add(parts);
			                           
			                           for (int k1=0; k1<parts.length+1; k1++) 
			                           {
			                        	   if(k1<parts.length)
			                        		   tout.add(parts[k1]);
		                        
		                        	   
			                           }
			                           if (eElement.getElementsByTagName("p").item(j)==null)
			                           {
			                        	   tout.add("finnn");
			                        	   listTitre.add("finnn".split(" "));
			                               i=-1;
			                           }
		                           }
		                            
		                           
		                        
		                            
		                    }
		                    
		                    
		
		            }
            	 }
             }
            
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		ArrayList<String> listeStop = LectureListe.lectureListe("C:/Users/Mehdi/Documents/stopword.txt");
		lectTxt("C:/Users/Mehdi/Downloads/auto.txt", tout, listTitre);
		lectTxt("C:/Users/Mehdi/Downloads/a.txt", tout, listTitre);
	//	lectTxt("C:/Users/Mehdi/Downloads/cea.txt", tout, listTitre);
		

        for (int k=0; k<tout.size();k++) 
        {	
        	System.out.println(tout.get(k));

        }
		
		
		
		
        for (int k=0; k<tout.size();k++) 
        {	
        	if(listeStop.contains(tout.get(k)))
        		tout.set(k, "");

        }
		
       
        
        for (int p=0; p< listTitre.size();p++) 
        {   
        	for (int t=0; t< listTitre.get(p).length; t++)
        	{  		
        		if(listeStop.contains(listTitre.get(p)[t]))
        				listTitre.get(p)[t]="";
        	}
        }
        
		
		ArrayList<IDTF> repFre= new ArrayList<IDTF>();        //contient les idf
		ArrayList<IDTF> repFreq= new ArrayList<IDTF>();       // contient les tf
		ArrayList<IDTF> aI= new ArrayList<IDTF>(); 
		for (int k1=0; k1<tout.size();k1++)
    	{
        	tout.set(k1,tout.get(k1).replaceAll("[\r\n]+", ""));
        	tout.set(k1,tout.get(k1).replaceAll(",", ""));
        	tout.set(k1,tout.get(k1).replaceAll("l'", ""));
        	tout.set(k1,tout.get(k1).replaceAll("d'", ""));
        	tout.set(k1,tout.get(k1).replaceAll("\\.", "")); 
        	tout.set(k1,tout.get(k1).replaceAll("\\(", "")); 
        	tout.set(k1,tout.get(k1).replaceAll("\\)", "")); 
        	
    	}

		
        for (String s : tout) 
        {	
        	
    		double idfCalculator = idfCalculator(listTitre, s);
    		IDTF idtf= new IDTF(s, idfCalculator);
    		if(s.compareTo("")==0)
    			idtf.setIdtf(0);
    		repFre.add(idtf);

        }
       
        
        for (int p=0; p< listTitre.size();p++) 
        {   	
        	for (int t=0; t< listTitre.get(p).length; t++)
        	{  	
        		listTitre.get(p)[t]=listTitre.get(p)[t].replaceAll("[\r\n]+", "");
        		listTitre.get(p)[t]=listTitre.get(p)[t].replaceAll(",", "");
        		listTitre.get(p)[t]=listTitre.get(p)[t].replaceAll("l'", "");
        		listTitre.get(p)[t]=listTitre.get(p)[t].replaceAll("d'", "");
        		listTitre.get(p)[t]=listTitre.get(p)[t].replaceAll("\\.", "");
        		listTitre.get(p)[t]=listTitre.get(p)[t].replaceAll("\\(", "");
        		listTitre.get(p)[t]=listTitre.get(p)[t].replaceAll("\\)", "");
        	}
        }
     
        

        
        
        for (int p=0; p< listTitre.size();p++) 
        {
        	for (int t=0; t< listTitre.get(p).length; t++)
        	{  	
	        	double tf_p= tfCalculator(listTitre.get(p), listTitre.get(p)[t] );
	        	IDTF idtf= new IDTF(listTitre.get(p)[t],tf_p );
	        	repFreq.add(idtf);  	
        	}	
        }
        
      
      for(int p=0; p<repFreq.size(); p++)           //aI contient dorenavant les valeurs correctes des IDTF
        {
        	
	        	IDTF idtf= new IDTF(repFreq.get(p).getMot(), repFreq.get(p).getIdtf()*repFre.get(p).getIdtf());
	        	if(repFreq.get(p).getMot().compareTo("finnn")==0)
	        		idtf.setIdtf(0);
	        	aI.add(p,idtf );                                                                
        }
       
       
        
        
      
        Set<String> mySet = new HashSet<String>(tout);           //permet d'éliminer les occurences
        ArrayList<String> dico = new ArrayList<String>(mySet);
        
        
    	TableDeHachageIDTF table= new TableDeHachageIDTF();
    	table.init(dico);
    	
    	
    	
    	double [][] mat = new double[nombreDoc(aI)][dico.size()];    
    	mat=getMat(dico, aI);                                      //créer la matrice dont chaque ligne est la valeur des IDTF du doc
    	

    	
   
    	
    	
/*
    	 for (int e = 0; e < nombreDoc(aI); e++) {                        //affiche la matrice en entier
             for (int r = 0; r < dico.size()-1; r++)          // il y a un -1 car le terme fin apparait dans le dico
                System.out.printf("%9.4f ", mat[e][r]);
            	 
             System.out.println();
    	 }
  */


    	
    	
    // Voici un exemple de comment on calcule la CosineSimilarity entre 2 vecteurs (pour les courageux qui auront lu jusqu'au bout^^)	
   
    int[] brevAuto= new int[nombreDoc(aI)];	
    int[] brevMed= new int[nombreDoc(aI)];	
    int p=0;
    double[] auto= new double[nombreDoc(aI)-1];   //cosine simi par rapport au fichier exemple 1 (le dernier ajouté), ici automobile
    double[] med= new double[nombreDoc(aI)-1];     // cose simi pr au 2nd fichier exemple, l'avant dernier ajouté
    for(int k=0; k<nombreDoc(aI)-1;k++)
    {
       auto[k]= CosineSimilarity.cosineSimilarity(getLigne(mat, k), getLigne(mat, nombreDoc(aI)-1));
       med[k]= CosineSimilarity.cosineSimilarity(getLigne(mat, k), getLigne(mat, nombreDoc(aI)-2));
       
       if(med[k]>auto[k])
       {
    	   brevMed[p]=k;
    	   brevAuto[p]=-1;
    	   p++;
       }
       if(med[k]<auto[k])
       {
    	   brevMed[p]=-1;
    	   brevAuto[p]=k;
    	   p++;
       }
       
    	   
    }
    
    for (int k=0; k<nombreDoc(aI)-2; k++){
    	System.out.println(brevMed[k]+" et pour l'auto: "+brevAuto[k]);
   
    }
    

    
   

}

    
}



