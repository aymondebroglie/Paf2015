
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
















import java.io.File;
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
	    
	    
	    public static double[][] getMat(ArrayList<String> dico, ArrayList<IDTF> aIdtf){
            
            TableDeHachageIDTF table= new TableDeHachageIDTF();
            table.init(dico);
            int s =  aIdtf.size();
            double [][] mat = new double[nombreDoc(aIdtf)][dico.size()];
            int n = 0;
            int j = 0;
            
            for (int i = 0; i < s ; i ++){
                    if (aIdtf.get(i).getMot().compareTo("fin") == 0){
                            n = n + 1;
                    }
                    else{
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
	    		if(tout.get(k).getMot().compareTo("fin")==0)
	    			nombreDoc++;
	    	}
	    	return nombreDoc;
	    }
	  
   public static int nombreMot (ArrayList<IDTF> tout)
	    
	    {
	    	int nombreDoc=0;
	    	for( int k=0; k<tout.size();k++)
	    	{
	    		if(tout.get(k).getMot().compareTo("fin")!=0)
	    			nombreDoc++;
	    	}
	    	return nombreDoc;
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
			                        	   tout.add("fin");
			                        	   listTitre.add("fin".split(" "));
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
		
		//String c=tout.get(0);
		//tout.removeAll(Collections.singleton(c));
		ArrayList<IDTF> repFre= new ArrayList<IDTF>();        //contient les idf
		ArrayList<IDTF> repFreq= new ArrayList<IDTF>();       // contient les tf
		ArrayList<IDTF> aI= new ArrayList<IDTF>(); 
		for (int k1=0; k1<tout.size();k1++)
    	{
        	tout.set(k1,tout.get(k1).replaceAll("[\r\n]+", ""));
        	tout.set(k1, tout.get(k1).replaceAll(",", ""));
        	//tout.set(k1, tout.get(k1).replaceAll("'", ""));
    	}

        for (String s : tout) 
        {	
        	
    		double idfCalculator = idfCalculator(listTitre, s);
    		IDTF idtf= new IDTF(s, idfCalculator);
    		repFre.add(idtf);

        }
       
        
        
        
        for (int p=0; p< listTitre.size();p++) 
        {   	
        	for (int t=0; t< listTitre.get(p).length; t++)
        	{  	
        		listTitre.get(p)[t]=listTitre.get(p)[t].replaceAll("[\r\n]+", "");
        		listTitre.get(p)[t]=listTitre.get(p)[t].replaceAll(",", "");
        		//listTitre.get(p)[t]=listTitre.get(p)[t].replaceAll("'", "");

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
 
     	//System.out.println(nombreDoc(aI));


 /*	 for (int u=0; u<dico.size();u++)
         {
         	//System.out.println(table.getIndice(table.getMot(u))+"  "+table.getMot(u));
   		 	System.out.println(u+"   " +dico.get(u));
         }
	*/	
    
    double[] ligne= new double[dico.size()];
    ligne=getLigne(mat, 1);
    
	 for (int u=0; u<dico.size();u++){

	System.out.println( ligne[u]);

	 }

   
}

    
}



