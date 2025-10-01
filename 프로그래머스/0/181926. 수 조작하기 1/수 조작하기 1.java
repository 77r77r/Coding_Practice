import java.util.*;

class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        
        Queue<Character> q = new LinkedList<>();
        
        for (char c : control.toCharArray()) {
            q.offer(c);
        }
        
        while (!q.isEmpty()) {
            switch(q.poll()){
                case 'w' : n++; break;
                case 's' : n--; break;
                case 'd' : n += 10; break;
                case 'a' : n -= 10; break;
            }
        }
                    
        return n;
    }
}