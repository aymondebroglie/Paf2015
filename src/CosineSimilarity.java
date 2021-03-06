
public class CosineSimilarity {
	
	
	private double cos;
	
	public  CosineSimilarity(double cos){
		this.cos=cos;
	}
	
	// methode qui � partir de 2 vecteurs calcul le cosine similarity
	
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
	
	
	

}
