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

	int rdInt() throws NumberFormatException, IOException {
		return Integer.parseInt(bd.readLine());
	}

	int[] rdIntArr() throws IOException {
		String[] datas = bd.readLine().trim().split(" ");
		int [] arr = new int[datas.length];

		for(int i=0;i<datas.length;i++) {
			arr[i]= Integer.parseInt(datas[i]);
		}

		return arr;
	}

	int[] rdIntArrV2() throws IOException {

		String []arr = bd.readLine().trim().split(" ");
		return  Arrays
				.stream(arr)
				.mapToInt(Integer::parseInt).toArray();
	}


	public void close() throws IOException {
		bd.close();
	}
}