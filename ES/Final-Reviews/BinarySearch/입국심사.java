import java.util.*;

class Solution {    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long st = 0;
        Arrays.sort(times);
        long en = (long)n*times[times.length-1];
        
        while(st<=en) {
            long mid = (st+en)/2;
            
            long cnt = 0;
            for(int i=0;i<times.length;i++) {
                cnt += mid/times[i];
            }
            
            if(cnt>=n) {
                answer = mid;
                en = mid-1;
            }else {
                st = mid+1;
            }
        }
        
        return answer;
    }
}