class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = { 0, 0, -1, 1};
        
        String color = board[h][w];
        
        for (int i = 0; i<4; i++) {
             int nx = h + dx[i];
            int ny = w + dy[i];
            
            if (nx < 0 || n <= nx || ny< 0 || n <= ny) {
                continue;
            }
                    
            
            if (color.equals(board[nx][ny])) {
                count++;
            }
            
        }
        
        return count;
    }
        
}