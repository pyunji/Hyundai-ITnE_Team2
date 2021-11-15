import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		
		//자연수 N 1 <=  N <= 100000 브루트 포스로는 아마 시간초과가 날 것
		int N = input.nextInt();
		
		int [] nInputArr = new int[N];
		
		for(int i = 0; i < N; i++) {
			nInputArr[i] = input.nextInt();
		}
		
		Arrays.sort(nInputArr);
		//비교할 M
		int M = input.nextInt();
		
		int [] mInputArr = new int[M];
		
		for(int i = 0; i < M; i++) {
			mInputArr[i] = input.nextInt();
		}
		
		for(int i = 0; i < M; i++) {
			System.out.println(func1(mInputArr[i], nInputArr));
		}
		
	}
	//원리를 코드로 짜는 능력을 길러야 함
	//N은 비교할 숫자( M 배열), arr은 N배열
	//이분 탐색은 정렬이 필요함
	//함수가 끝나는 조건을 생각
	//값이 미들값과 같은 경우 무한 루프 발생 왜 why?
	//
	static int func1(int N, int [] arr) {
		//min은 시작 max는 arr길이
		int mid;
		int min = 0;
		int max = arr.length-1;
		int Count = 0;
		while(min <= max) {
			 mid = (min + max) / 2;
			 
			if(N == arr[mid]) {
				Count++;
				break;
			}
			else if(N > arr[mid]){
				min = mid +1;
			
			}
			else if(N < arr[mid]) {
				max = mid-1;
			}
		}
		return Count;
		}
		
	}


