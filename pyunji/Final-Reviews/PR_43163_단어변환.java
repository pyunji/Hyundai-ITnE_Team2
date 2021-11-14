/*
 * using DFS
 * 12m 소요
 */
class Solution {
    int N;
    boolean[] chk;
    int answer = Integer.MAX_VALUE;
    public boolean canConvert(String from, String to) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(from.charAt(i) != to.charAt(i)) count++;
        }
        return count == 1;
    }
    
    public void dfs(String begin, String target, String[] words, int count) {
        if(begin.equals(target)) {
            answer = Math.min(count, answer);
        }
        
        for(int i = 0; i < words.length; i++) {
            if(!chk[i] && canConvert(begin, words[i])) {
                chk[i] = true;
                dfs(words[i], target, words, count + 1);
                chk[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean flag = false;
        for(String word : words) {
            if(target.equals(word)) {
                flag = true;
                break;
            }
        }
        if(!flag) return 0;
        
        N = begin.length();
        chk = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        return answer;
    }
}