import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int[][] dp = new int[n + 1][n + 1];
		int[] x = new int[n + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		x[0] = arr[0][0];
		for (int i = 1; i <= n; i++) {
			x[i] = arr[i - 1][1];
		}

		// dp[1][2] = x[0] * x[1] * x[2];
		// dp[2][3] = x[1] * x[2] * x[3];
		// dp[i][j] = x[i - 1] * x[i] * x[j];

		for (int len = 2; len <= n; len++) {
			for (int i = 1; i + len - 1 <= n; i++) {

				int j = i + len - 1;

				dp[i][j] = Integer.MAX_VALUE;

				for (int k = i; k < j; k++) {
					int cost = dp[i][k] + dp[k + 1][j];
					int multi = x[i - 1] * x[k] * x[j];

					dp[i][j] = Math.min(dp[i][j], cost + multi);
				}
			}
		}

		bw.write(dp[1][n] + "");

		bw.flush();
		br.close();
		bw.close();
	}
}