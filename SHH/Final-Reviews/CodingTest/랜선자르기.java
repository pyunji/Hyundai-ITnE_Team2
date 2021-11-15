import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		//랜선의 갯수 랜선의 길이는 2^31-1보다 작거나 같음
		int N = input.nextInt();
		//필요한 랜선의 개수( 1<= K <= 10000)
		int K = input.nextInt();
		//가지고 있는 랜선 배열
		long [] line = new long[N];
		
		long max = 0;
		
		for(int i = 0; i < N; i++) {
			line[i] = input.nextInt();
			
			max = Math.max(max, line[i]);
		}
		Arrays.sort(line);
		System.out.println(BinarySearch(K,line,max));
		
		
	}
	//SearchKey는 필요한 랜선의 갯수
	//반례 동일한 길이를 가지고 있을 경우 제대로 출력 안됨
	static long BinarySearch(int SearchKey, long [] arr, long maxNum) {
		long mid;
		long min = 1;
		long max = maxNum;
		int count;
		
		while(min <= max) {
			count = 0;
			mid = (min + max) / 2;
			for(int i = 0; i < arr.length;i++) {
				count += arr[i]/mid;
			}
			if(count >= SearchKey) {
				min = mid + 1;
			}
			else if(count < SearchKey) {
				max = mid -1;
			}
		}
		return max;
	}

}
