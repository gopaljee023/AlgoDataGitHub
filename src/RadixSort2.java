

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RadixSort2 {

	private static void radixSort(long[] arr, long max) {
		int mul = 1;
		int i=1;
		while(max!=0) {
			for(int j = 1+ 5*(i-1);j<=5*i;j++) {
				if(max==0) break;
				countSort(arr,mul);
				max/= 10;
				mul*= 10;
			}
			print(arr);
			i++;
		}
	}
	

	private static void print(long[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}


	final static int range = 10; //learnt final .. i was using const ( c++ ka concept hain const)
	private static void countSort(long[] arr, int place) {
		int n = arr.length;
		int freq[] = new int[range];
		long output[] = new long[n];

		count_frequency_based_on_position(arr, place,freq);
		update_freq_array_to_set_index_position(freq);
		update_temp_array_based_on_freq_array(arr, place,freq, output);
		copy_temp_array_to_initial_array(arr, output);
	}

	private static void copy_temp_array_to_initial_array(long[] arr, long[] output) {
		int n = output.length;
		for (int i = 0; i <n; i++) {
			arr[i]= output[i];
		}
		}

	private static void update_temp_array_based_on_freq_array(long[] arr, int place,  int[] freq, long[] output) {
		for (int i = output.length-1; i>=0; i--) {
			//step1: first find arr[i] where it will go.
			//arr[i]/place%range  = f_i
			//step2: go and check in freq[f_i]
			//step3: output[freq[f_i]] = arr[i];
			//step4: freq[f_i] decreate by 1
			int f_i = (int)arr[i]/place%range;
			output[freq[f_i]] = arr[i];
			freq[f_i]--;
		}
	}

	private static void update_freq_array_to_set_index_position(int[] freq) {
		/* suppose freq[0]  = 2 ie. 0 and 1 position of outputArray have two elements..
		 * we want to put data based on index of outputaray.. so max index to put data. == 2-1;
		 */
		freq[0]-- ;
		for (int i = 1; i < range; i++) {
			/* here we simply setting max index of outputarray for a particuar position.*/
			freq[i] += freq[i-1];
		}
	}

	private static void count_frequency_based_on_position(long[] arr, int place,int[] freq) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			int f_i =(int) arr[i]/place%range;
			freq[f_i]++;
		}
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		long[] data = new long[n];
		long max = 0L;
		String[] arr= br.readLine().trim().split(" ");
		for (int i = 0; i < arr.length; i++) {
			data[i] = Long.parseLong(arr[i]);
			if(data[i]>max) max = data[i];
		}
		radixSort(data,max);

		br.close();

	}
}
