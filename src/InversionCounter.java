import java.util.ArrayList;
import java.io.*;

public class InversionCounter {

	/**
	 * @param args
	 */
	
	public static ArrayList<Integer> InputA = new ArrayList<Integer>();
	
	private static void readInputFile(String Path){
		
		try{
			
			//File files = new File(".");
			//for(String fileNames : files.list()) System.out.println(fileNames);
			
			
			File file = new File(Path);
			
			FileInputStream fStream = new FileInputStream(file);
			
			
			
			System.out.println(file.getCanonicalPath());
			
			
			DataInputStream inputStream = new DataInputStream(fStream);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			
			String c = "";
			
			while( (c = br.readLine()) != null){
				
				InputA.add(Integer.parseInt(c));
				
				System.out.println(c);			
				
			}
			System.out.println("the total number of elements in InputA = " + InputA.size());	
			
		}
		catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Running");
		readInputFile("ints.txt");
		
	}

}
