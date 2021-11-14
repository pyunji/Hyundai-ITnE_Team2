import java.util.*;

class Solution {
    
    static public int check(String a,String b) {
        int cnt = 0;
        for(int i=0;i<a.length();i++){
            if(!(a.charAt(i)==(b.charAt(i)))) cnt++;
        }
        return cnt;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n = words.length;
        
        int[] visited = new int[n+2];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(n);
        visited[n] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            String str = "";
            
            if(cur==n) {
                str = begin;
            }else if(words[cur].equals(target)){
                answer = visited[cur];
                break;
            }
            if(cur!=n)
                str = words[cur];
            
            for(int i=0;i<n;i++) {
                if(visited[i]!=0) continue;
                if(check(str,words[i])!=1) continue;
                if(cur==n) visited[i] = 1;
                else visited[i] = visited[cur] +1;
            
                q.add(i);
            }
        }
        
        return answer;
    }
}