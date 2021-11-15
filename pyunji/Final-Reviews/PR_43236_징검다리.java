import java.util.*;
class Solution {
    public int countLt(long target, int[] arr) {
        int[] intervals = Arrays.copyOf(arr, arr.length);
        int count = 0;
        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i] < target) {
                if(i < intervals.length - 1) intervals[i + 1] += intervals[i];
                count++;
            }
        }
        return count;
    }
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int[] intervals = new int[rocks.length+1];
        int before = 0;
        for(int i = 0; i < rocks.length; i++) {
            intervals[i] = rocks[i] - before;
            before = rocks[i];
        }
        intervals[intervals.length - 1] = distance - rocks[rocks.length-1];
        
        long start = 0;
        long end = distance;
        int answer = 0;
        while(start <= end) {
            long mid = (start + end) / 2;
            if(countLt(mid, intervals) <= n) {
                start = mid + 1;
                answer = (int) mid;
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
}