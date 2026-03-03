import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];

		dp[1] = 0;

		for (int i = 2; i <= n; i++) {
			if (i % 6 == 0) {
				dp[i] = Math.min(dp[i - 1] + 1, Math.min(dp[i / 2] + 1, dp[i / 3] + 1));
			} else if (i % 2 == 0) {
				dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
			} else if (i % 3 == 0) {
				dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);
			} else {
				dp[i] = dp[i - 1] + 1;
			}
		}

		bw.write(dp[n] + "");

		bw.flush();
		br.close();
		bw.close();
	}

	static void calc(int num) {
		if (num == 1) {
			return;
		}
	}

}