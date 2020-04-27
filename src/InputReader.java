import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 
 
  public static void main(String[] args) throws IOException {
		
		InputReader input = new InputReader();
		
       
        
        
        
	}
 */
public class InputReader{

	static BufferedReader bd;
	//Learn: static can't be used if class is internal
	static {
		bd = new BufferedReader(new InputStreamReader(System.in));
	}

	static int rdInt() throws NumberFormatException, IOException {
		return Integer.parseInt(bd.readLine());
	}

	static int[] rdIntArr() throws IOException {
		String[] datas = bd.readLine().trim().split(" ");
		int [] arr = new int[datas.length];

		for(int i=0;i<datas.length;i++) {
			arr[i]= Integer.parseInt(datas[i]);
		}

		return arr;
	}

	static int[] rdIntArrV2() throws IOException {

		String []arr = bd.readLine().trim().split(" ");
		return  Arrays
				.stream(arr)
				.mapToInt(Integer::parseInt).toArray();
	}

    static int[][] rd2DIntArray(int row,int col) throws IOException{
    	int[][] matrix  = new int[row][];
    /*	
    	for(int i=0;i<row;i++) {
    		matrix[i] = new int[col];
    		int[] temp = rdIntArrV2();
    		for (int j = 0; j < col; j++) {
    			matrix[i][j] = temp[j];
			}
    		
    	}
    	*/
    	
    	for(int i=0;i<row;i++) {
    		matrix[i] = rdIntArrV2();
    	}
    	
    	return matrix;
    }
    
    
	static public void close() throws IOException {
		bd.close();
	}
}