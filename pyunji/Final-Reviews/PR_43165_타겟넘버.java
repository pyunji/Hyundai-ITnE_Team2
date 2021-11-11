/*
 * using DFS
 * 16m
 */
class Solution {
    int answer = 0;
    
    public void dfs(int[] numbers, int target, int idx, int sum) {
        if(idx == numbers.length) {
            if(sum == target) answer++;
            return;
        }
        dfs(numbers, target, idx + 1, sum + numbers[idx]);
        dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }
    
    public int solution(int[] numbers, int target) {
        // 순서대로 탐색해야하는 문제이므로
        // 1. 루프를 돌면서 dfs 진입 가능한 요소를 찾을 필요가 없다.
        // 2. 방문체크를 할 필요가 없다.
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
}