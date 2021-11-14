import java.util.*;

class Solution {
    static int answer = 0;
    static int total = 0;
    
    static void func(int num,int[] numbers, int target) {
        if(num==numbers.length) {
            if(total==target) answer++;
            return;
        }
        
        total+=numbers[num];
        func(num+1,numbers,target);
        total-= numbers[num];

        total-=numbers[num];
        func(num+1,numbers,target);
        total+= numbers[num];
    }
    
    public int solution(int[] numbers, int target) {
        func(0,numbers,target);
        
        return answer;
    }
}