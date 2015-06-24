import java.util.ArrayList;


public class CosineSimilarity {
	
	
	private double cos;
	
	public  CosineSimilarity(double cos){
		this.cos=cos;
	}
	
	// methode qui à partir de 2 vecteurs calcul le cosine similarity
	
	public static double cosineSimilarity(double[] vectorA, double[] vectorB) 
	{
	    double dotProduct = 0.0;
	    double normA = 0.0;
	    double normB = 0.0;
	    for (int i = 0; i < vectorA.length; i++) {
	        dotProduct += vectorA[i] * vectorB[i];
	        normA += Math.pow(vectorA[i], 2);
	        normB += Math.pow(vectorB[i], 2);
	    }   
	    return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
	}



	public double getCos() {
		return cos;
	}



	public void setCos(double cos) {
		this.cos = cos;
	}
	
	public static ArrayList<ArrayList<Integer>> categories(double[][] docs,ArrayList<double[]> exemples) {
		int nbCategories=exemples.size();
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>(nbCategories);
		for (int i=0; i<nbCategories; i++) {
			ArrayList<Integer> c=res.get(i);
			c=new ArrayList<Integer>();
		}
		for (int i=0; i<docs.length; i++) {
			int categorie=0;
			double cosine=Math.abs(cosineSimilarity(exemples.get(0),docs[i]));
			for (int j=1; i<nbCategories; i++) {
				if(Math.abs(cosineSimilarity(exemples.get(j),docs[i]))>cosine) {
					categorie=j;
					cosine=Math.abs(cosineSimilarity(exemples.get(j),docs[i]));
				}
			res.get(categorie).add(new Integer(i));
			}
		}
		return res;
	}
	
	

}
