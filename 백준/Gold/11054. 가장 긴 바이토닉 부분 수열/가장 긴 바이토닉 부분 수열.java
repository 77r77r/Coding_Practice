import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] num = new int[n + 1];
		int[][] dp = new int[n + 1][2];

		for (int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		// dp[i][0]: i 보다 작은 수의 개수
		for (int i = 1; i <= n; i++) {
			int left = 0;

			// 현재 위치 기준으로 왼쪽값 중 작은 수의 개수
			for (int j = 1; j < i; j++) {
				if (num[i] > num[j]) {
					left = Math.max(left, dp[j][0]);
				}
			}
			dp[i][0] = left + 1;
		}

		// dp[i][1]: i 보다 큰 수의 개수
		for (int i = n; i > 0; i--) {
			int right = 0;

			// 현재 위치 기준으로 오른쪽 중 작은 값 개수
			for (int j = i; j <= n; j++) {
				if (num[i] > num[j]) {
					right = Math.max(right, dp[j][1]);
				}
			}

			dp[i][1] = right + 1;
		}

		int max = dp[0][0] + dp[0][1];

		for (int[] d : dp) {
			max = Math.max(max, d[0] + d[1]);
		}

		bw.write(max - 1 + "");

		bw.flush();
		br.close();
		bw.close();
	}
}