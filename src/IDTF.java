
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class IDTF    {
	

	
	
	private double idtf;
	private String mot;
	
	public IDTF(String mot, double idtf)
	{
		this.mot=mot;
		this.idtf=idtf;
		
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
	
	
	  public static double tfCalculator(ArrayList<String> totalterms, String termToCheck) {
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
	        return Math.log(allTerms.size() / count);
	    }
	    
	    
	
	  


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		

		
		ArrayList<String[]> listTitre = new ArrayList<String[]>();
		ArrayList<String> tout= new ArrayList<String>();
		
		try {
            
			File repertoire= new File("C:/Users/Mehdi/Desktop/Bb");
			 String[] listefichiers = repertoire.list();
            
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            for (int k=0; k<listefichiers.length/100;k++)
            {
            	 if(listefichiers[k].endsWith(".xml")==true)
            	 {             
            File fXmlFile = new File("C:/Users/Mehdi/Desktop/Bb/"+listefichiers[k]);
            Document doc = dBuilder.parse(fXmlFile);
            
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("abstract");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                     
                    Node nNode = nList.item(temp);
     
                 //   System.out.println("\nCurrent Element :" + nNode.getNodeName());
     
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            
                            Element eElement = (Element) nNode;
                           
                                    
                            
                           String s= eElement.getElementsByTagName("p").item(0).getTextContent();
                           String[] parts= s.split(" ");
                           listTitre.add(parts);
                           for (int k1=0; k1<parts.length; k1++) {
                        	   tout.add(parts[k1]);
                           }
                           
                        
                            
                    }
                    
                    

            }
            }
            	 }
            
           
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		String c=tout.get(0);
		tout.removeAll(Collections.singleton(c));
		
		ArrayList<IDTF> repFre= new ArrayList<IDTF>();
		int p=0;
        for (String s : tout) 
        {
    		double idfCalculator = idfCalculator(listTitre, s);
    		double tfCalculator= tfCalculator(tout, s);
    		double f= idfCalculator*tfCalculator;
    		IDTF idtf= new IDTF(s, f);
    		repFre.add(idtf);
    		System.out.println(repFre.get(p).getMot() +"  "+ repFre.get(p).getIdtf());
    		p++;

        }
       
        
        
		
		
      }


     

    


}

