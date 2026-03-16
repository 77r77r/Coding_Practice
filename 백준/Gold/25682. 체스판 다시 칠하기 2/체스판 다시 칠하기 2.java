import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] board = new int[row + 1][col + 1];
		int[][] dp = new int[row + 1][col + 1];

		// 0 0 0 0 0
		// 0 B B B B
		// 0 B B B B
		// 0 B B B W
		// 0 B B W B

		/**
		 * "[0, 0, 0, 0, 0]"
		 * "[0, 0, 1, 0, 1]"
		 * "[0, 1, 0, 1, 0]"
		 * "[0, 0, 1, 0, 0]"
		 * "[0, 1, 0, 0, 0]"
		 */

		for (int i = 1; i <= row; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 1; j <= col; j++) {
				if ((i + j) % 2 == 0) {
					if (temp[j - 1] != 'B') {
						board[i][j]++;
					}
				} else {
					if (temp[j - 1] != 'W') {
						board[i][j]++;
					}
				}
			}
		}

		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + board[i][j];
			}
		}

		int min = Integer.MAX_VALUE;

		/**
		 * "[0, 0, 0, 0, 0]"
		 * "[0, 0, 1, 1, 2]"
		 * "[0, 1, 2, 3, 4]"
		 * "[0, 1, 3, 4, 5]"
		 * "[0, 2, 4, 5, 6]"
		 */

		for (int i = 0; i + k <= row; i++) {
			// 0 ~ 1
			for (int j = 0; j + k <= col; j++) {
				// 0 ~ 1
				int prefixB = dp[i + k][j + k] - dp[i + k][j] - dp[i][j + k] + dp[i][j];
				int prefixW = (k * k) - prefixB;

				min = Math.min(min, Math.min(prefixB, prefixW));
			}
		}

		bw.write(String.valueOf(min));

		bw.flush();
		br.close();
		bw.close();
	}
}