import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class TabledeHachage {

	private HashMap<String, String> regDep;
	
	public TabledeHachage(){
		
		regDep = new HashMap<String, String>(); 
	}
	
	
	public String getRegion(String dep){
		String region = regDep.get(dep);
		return region;
	}
	
	public final void init(){
		
		
		FileReader fr=null;
		BufferedReader br=null;
		String [] intermediaire = null;
		
		
			try{
				fr = new FileReader("data/ListeRegion");
				br = new BufferedReader(fr);
				String lineToRead=null;
					
				lineToRead = br.readLine();
				
				while (lineToRead != null){
					
					//lineToRead.replaceAll("(", "");
					//lineToRead.replaceAll(")", "");
					intermediaire = lineToRead.split(" ");
					
					regDep.put(intermediaire[0], intermediaire[1]);
					
					lineToRead = br.readLine();
					
					
				}
				
			}
			
			
			catch(FileNotFoundException e){
				System.err.println("Error class ListePrenom, initFromTextFile: File not found ");
			}
			catch(IOException e){
				System.out.println("Error class ListePrenom, initFromTextFile: read error");
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
}
	
	

