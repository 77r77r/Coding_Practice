import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i, j, k =0;
        
        for (int x = 0; x < commands.length; x++) {
            i = commands[x][0];
            j = commands[x][1];
            k = commands[x][2];
            
            int[] cut = Arrays.copyOfRange(array, i - 1, j);
            for (int c : cut) {
                System.out.print(c);
            }
            System.out.println("");
            Arrays.sort(cut);
            answer[x] = cut[k-1];
        }        
        
        return answer;
    }
}