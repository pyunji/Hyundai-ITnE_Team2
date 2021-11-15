import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int st =0;
        int en = distance;
        
        while(st<=en) {
            int mid = (st+en)/2;
            
            //제거하는 바위의 갯수
            int cnt = 0;
            int prev = 0;
            
            for(int i=0;i<rocks.length;i++) {
                //바위를 제거해야하는 경우
                if(rocks[i]-prev < mid) cnt++;
                else prev = rocks[i];
            }
            //맨 마지막 바위
            if(distance-prev < mid) cnt++;
            
            if(cnt>n) {
                en = mid-1;
            }else {
                answer = mid;
                st = mid+1;
            }
            
        }
        
        return answer;
    }
}