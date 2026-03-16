import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int repeat = Integer.parseInt(st.nextToken());

		int[][] board = new int[n + 1][n + 1];
		int[][] dp = new int[n + 1][n + 1];

		// 0 0 0 0 0
		// 0 1 2 3 4
		// 0 2 3 4 5
		// 0 3 4 5 6
		// 0 4 5 6 7

		// dp[1][1] = dp[0][1] + dp[1][0] + board[1][1];
		// dp[1][2] = dp[0][2] + dp[1][1] + board[1][2];
		// dp[1][3] = dp[0][3] + dp[1][2] + board[1][3];
		//
		// dp[2][2] = dp[1][2] + dp[2][1] + board[2][2] - dp[1][1];
		//
		// dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + board[i][j] - dp[i-1][j-1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int num = Integer.parseInt(st.nextToken());
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + num;
			}
		}

		while (repeat-- > 0) {
			st = new StringTokenizer(br.readLine());
			int fromX = Integer.parseInt(st.nextToken());
			int fromY = Integer.parseInt(st.nextToken());
			int toX = Integer.parseInt(st.nextToken());
			int toY = Integer.parseInt(st.nextToken());

			int result = dp[toX][toY] - dp[toX][fromY - 1] - dp[fromX - 1][toY] + dp[fromX -1][fromY -1];

			bw.write(result + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}