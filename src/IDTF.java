
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
	

     
    
    


}
