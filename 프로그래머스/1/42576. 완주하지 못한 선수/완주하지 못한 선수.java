import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> com = new HashMap<>();
        Map<String, Integer> par = new HashMap<>();
        
        // 완주자 Map
        for (String x : completion) {
            com.put(x, com.getOrDefault(x, 0) + 1);
        }
        
        // 참여자 Map
        for (String p : participant) {
            if (com.getOrDefault(p, 0) == 0) {
                // 완주자 목록에 없다면
                par.put(p, 0);
            } else {
                com.put(p, com.get(p) - 1);
            }
        }
        
        return par.keySet().iterator().next();
    }
}