import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n][3];

		// 비용 저장
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}

		// cost[i][c]: i번째까지 칠했을 때, i번째 집의 색이 c인 경우 최소비용
		int[][] dp = new int[n][3];

		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];

		for (int i = 1; i < n; i++) {
			dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}

		int min = Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);

		bw.write(String.valueOf(min));

		bw.flush();
		br.close();

		bw.close();
	}
}