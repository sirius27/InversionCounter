import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

public class InversionCounter {

	/**
	 * @param args
	 */
	
	public static ArrayList<Integer> InputA = new ArrayList<Integer>();
	private static int len ;
	private static int InversionCounter;
	
	private static void readInputFile(String Path){
		/**
		 * thsi function reads the txt file and creates a integer array list and sets the length variable
		 */
		
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
			System.out.println("the total number of elements in InputA = " + (len = InputA.size()));	
			
		}
		catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		
		
	}
	
	private static int[] countInversion(int[] a, int l){
		/**
		 * This function counts the inversions in the array
		 */
		int lefta[] = Arrays.copyOfRange(a, 0, (int)l/2);
		int righta[] =Arrays.copyOfRange(a, (int)l/2, l);
		System.out.println("countInversion: length l is "+l);
		
		if(l ==  1)
		{
			System.out.println("countInversion: length l inside if l == 1 is "+l);
			return a;
		}
		else
		{
			System.out.println("countInversion: length l inside else l == 1 is "+l);
			int[] LeftASorted = countInversion(lefta, (int)l/2);
			int[] RightASorted = countInversion(righta, (int)l/2);			
			int[] mergedA = countSplit(LeftASorted, RightASorted, l);
			return mergedA;
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	private static int[] countSplit(int[] leftASorted, int[] rightASorted, int l) {
		// TODO Auto-generated method stub
		
		System.out.println("countSplit: length l inside is "+l );
		System.out.println("Left sorted array input"+ Arrays.toString(leftASorted));
		System.out.println("Right sorted array input"+ Arrays.toString(rightASorted));
		
		
		int k,i=0,j=0;
		int[] mergedA = new int[l];
		
		//comparisons are happening in both the ifs.. and i is getting incremented
		
		for(k = 0; k <= l-1; k++ ){
			System.out.println("countSplit:  k = "+k+" and i = "+i+" and j = "+ j);
			if(i < (int)l/2 ){
				System.out.println("Inside if with  k = "+k+" and i = "+i+" and j = "+ j);
				if(  leftASorted[i] <= rightASorted[j]){
					System.out.println("Left Array Element added at k = "+ k + "and i = "+ i);
					mergedA[k] = leftASorted[i++];
					
				}
			}
			
			else if(j <= (int)l/2){
				if(leftASorted[i] > rightASorted[j] ){
					
					System.out.println("Right Array Element added at k = "+k+" and i = "+i+" and j = "+ j);
					InversionCounter += (((int)l/2)-i)+1;
					
					mergedA[k] = rightASorted[j++];
					
				}
			}
				
				
		}
		System.out.println("count of inversions is "+InversionCounter);
		
		
		return mergedA;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Running");
		readInputFile("test.txt");
		InversionCounter = 0;
		int a[] = new int[len];
		for(int i=0;i<=len-1;i++){
			a[i] = InputA.get(i).intValue();
		}
		countInversion(a, len);
		
		
	}

}
