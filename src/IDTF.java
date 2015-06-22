
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;





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
	  
	  public double[][] getMat(TableDeHachageIDTF table, ArrayList<String> dico, ArrayList<IDTF> aIdtf){
		  
		  
		  int s =  dico.size();
		  double [][] mat = new double[311][s];
		  int n = 0;
		  int j = 0;
		  
		  for (int i = 0; i < s ; i ++){
			  if (aIdtf.get(i).getMot().compareTo("fin") == 0){
				  n = n + 1;
			  }
			  else{
				  j = table.getIndice(aIdtf.get(i).getMot());
				  mat[n][j] = aIdtf.get(i).getIdtf(); // a vérifier que ce soit la bonne méthode
			  }
		  }
		  
		  
		  return mat;
	  }
	  
	  
	  public ArrayList<String> dictionnaire(ArrayList<String> base){
	    	
	    	ArrayList<String> dico = new ArrayList<String>();
	    	int s1 = base.size();
	    	int s2 = 0;
	    	int j = 0;
	    	int find = 0;
	    	
	    	for(int i = 0; i < s1; i++){
	    		if(base.get(i).compareTo("fin") != 0){
	    			while(find == 0 && j < s2){
	    				if(base.get(i).compareTo(dico.get(j)) == 0){
	    					find = 1;
	    				}
	    				j = j +1;
	    			}
	    			
	    			if (find == 0){
	    				dico.add(base.get(i));
	    			}
	    			find = 0;
	    			j = 0;
	    		}
	    	}
	    	
	    	return dico;
	    }
	    
	  
	  
	    /**
	     * Calcule idf du term termToCheck
	     * @param allTerms : tous les termes de tous les documents
	     * @param termToCheck
	     * @return idf(inverse document frequency) resultat
	     */
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
	    
	    public ArrayList<IDTF> tri(ArrayList<IDTF> base, ArrayList<String> dico){
	    	
	    	TableDeHachageIDTF table = new TableDeHachageIDTF();
	    	table.init(dico);
	    	IDTF transfert = new IDTF();
	    	String j = "";
	    	int find = 0;
	    	int k = 0;
	    	
	    	for (int i = 0; i < base.size(); i ++){
	    		j = table.getMot(i);
	    		if(j.compareTo(base.get(i).getMot()) != 0){
	    			
	    			k = i;
	    			while (find == 0 && (k< base.size())){
	    				
	    				if(j.compareTo(base.get(k).getMot()) == 0){
	    					find = 1;
	    					transfert = base.get(i);
	    	    			base.set(k, base.get(i));
	    	    			base.set(i, transfert);
	    				}
	    				k = k + 1;
	    			}
	    			
	    			find = 0;
	    			
	    		}
	    	}
	    	return base;
	    	
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
     //fin tri**********************************************************************************
	    
	    
	    
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 
		ArrayList<String[]> listTitre = new ArrayList<String[]>();   // liste qui contient la description de chaque brevet: 1 élement = 1 brevet
		ArrayList<String> tout= new ArrayList<String>();             // liste qui contient tous les mots de chaque brevet
		
		
		
		
		try {
			 int i=1;
	         int j=0;
			File repertoire= new File("C:/Users/Mehdi/Desktop/B");
			 String[] listefichiers = repertoire.list();
            
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            for (int k=0; k<listefichiers.length;k++)
            {
            	 if(listefichiers[k].endsWith(".xml")==true)
            	 {             
            File fXmlFile = new File("C:/Users/Mehdi/Desktop/B/"+listefichiers[k]);
            Document doc = dBuilder.parse(fXmlFile);
            
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("abstract");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                     
                    Node nNode = nList.item(temp);
     
                 //   System.out.println("\nCurrent Element :" + nNode.getNodeName());
     
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            
                            Element eElement = (Element) nNode;
                           
                                    
                            if (eElement.getElementsByTagName("p").item(0)!=null){
                                i=1;
                        }
                        while (i>0){ 
                           String s= eElement.getElementsByTagName("p").item(j).getTextContent().toLowerCase();
                           j++;
                           String[] parts= s.split(" ");
                           listTitre.add(parts);
                           ;
                           for (int k1=0; k1<parts.length+1; k1++) 
                           {
                        	   if(k1<parts.length)
                        		   tout.add(parts[k1]);
                        	   else 
                        		   tout.add("fin");
                        	   
                           }
                           if (eElement.getElementsByTagName("p").item(j)==null)
                           {
                                   i=-1;
                           }
                           }
                        listTitre.add("fin".split(" "));
                           
                        
                            
                    }
                    
                    

            }
            }
            	 }
            
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		//String c=tout.get(0);
		//tout.removeAll(Collections.singleton(c));
		ArrayList<IDTF> repFre= new ArrayList<IDTF>();
		ArrayList<IDTF> repFreq= new ArrayList<IDTF>();
	//	int p=0;
        for (String s : tout) 
        {

    		double idfCalculator = idfCalculator(listTitre, s);
    		IDTF idtf= new IDTF(s, idfCalculator);
    		repFre.add(idtf);

    		
    		/*double tfCalculator= tfCalculator(listTitre.get(p), s);
    		double f= idfCalculator*tfCalculator;
    		IDTF idtf= new IDTF(s, f);
    		repFre.add(idtf);
    		//System.out.println(repFre.get(p).getMot() +"   "+ repFre.get(p).getIdtf());
    		p++;*/

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
        
        for(int p=0; p<repFreq.size(); p++)                                     //repFreq contient dorenavant les valeurs correctes des IDTF
        {
        	if (repFreq.get(p).getMot().compareTo("fin")!=0)
        	{
	        	IDTF idtf= new IDTF(repFreq.get(p).getMot(), repFreq.get(p).getIdtf()*repFre.get(p).getIdtf());
	        	repFreq.set(p,idtf );                                                                
	        	//System.out.println(repFreq.get(p).getMot()+"       "+repFreq.get(p).getIdtf() );
        	}
        }
        
        
        
        
    
        
        
      //  ArrayList<IDTF> repFreq1= new ArrayList<IDTF>();
       // repFreq1= tri_fusion(repFreq);
        

        for(int p=0; p<repFreq.size(); p++)
        {
        	System.out.println(repFreq.get(p).getMot()+"       "+repFreq.get(p).getIdtf() );
        	
        }
        

		
        
     
      
        
        
        
        
        
      /*  for( u=0;u<repFre.size();u++){
        	System.out.println(repFre.get(u).getIdtf()+ "    "+ repFre.get(u).getMot());
        	System.out.println(repFreq.get(u).getIdtf()+ "    "+ repFreq.get(u).getMot());

        }
        
     
*/   
    
		
      }

	


     
}
    




