import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 1; // 가장 적게 걸리는 경우의 시간
        long end = (long) n * times[0]; // 가장 많이 걸리는 경우의 시간
        while(start <= end)  {
            long sum = 0; // 심사완료한 인원수
            long mid = (start + end) / 2;
            for(int i = 0; i < times.length; i++) {
                sum += mid / times[i]; // mid라는 시간 안에 처리할 수 있는 인원 수 측정
            }
            
            if (sum >= n) { // 주어진 시간 안에 더 많은 인원을 측정했다면
                end = mid - 1; // 시간을 줄여본다
                answer = mid;
            } else { // 인원을 모두 측정하지 못했다면
                start = mid + 1; // 시간을 늘려본다
            }
        }
        return answer;
    }
}