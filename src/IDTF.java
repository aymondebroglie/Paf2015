
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;



public class IDTF {
	
	  public double tfCalculator(ArrayList<String> totalterms, String termToCheck) {
	        double count = 0;  //to count the overall occurrence of the term termToCheck
	        for (String s : totalterms) {
	            if (s.equalsIgnoreCase(termToCheck)) {
	                count++;
	            }
	        }
	        return count / totalterms.size();
	    }
	  
	  
	    /**
	     * Calculates idf of term termToCheck
	     * @param allTerms : all the terms of all the documents
	     * @param termToCheck
	     * @return idf(inverse document frequency) score
	     */
	    public double idfCalculator(ArrayList<String> allTerms, String termToCheck) {
	        double count = 0;
	        for (String ss : allTerms) {
	           // for (String s : ss) {
	                if (ss.equalsIgnoreCase(termToCheck)) {
	                    count++;
	                    break;
	                }
	            }
	      //  }
	        return 1 + Math.log(allTerms.size() / count);
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
	    
	    
	  


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		ArrayList<String> listTitre = new ArrayList<String>();
		
		try {
            
			File repertoire= new File("C:/Users/Mehdi/Desktop/Brev");
			 String[] listefichiers = repertoire.list();
            
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            for (int k=0; k<listefichiers.length;k++)
            {
            	 if(listefichiers[k].endsWith(".xml")==true)
            	 {             
            File fXmlFile = new File("C:/Users/Mehdi/Desktop/Brev/"+listefichiers[k]);
            Document doc = dBuilder.parse(fXmlFile);
            
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("fr-bibliographic-data");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                     
                    Node nNode = nList.item(temp);
     
                 //   System.out.println("\nCurrent Element :" + nNode.getNodeName());
     
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            
                            Element eElement = (Element) nNode;
                           
                                    
                            
                           // System.out.println("Titre : " + eElement.getElementsByTagName("invention-title").item(0).getTextContent());
                            listTitre.add(eElement.getElementsByTagName("invention-title").item(0).getTextContent().toLowerCase());
                        
                            
                    }
                    
                    

            }
            }
            	 }
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
     
    
    


}
