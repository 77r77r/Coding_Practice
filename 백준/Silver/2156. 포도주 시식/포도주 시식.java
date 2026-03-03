import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = wine[1];

		if (n >= 2) {
			dp[2] = wine[2] + wine[1];
			for (int i = 3; i <= n; i++) {
				dp[i] = Math.max(Math.max(dp[i - 1],    // 안 마시는 경우
						dp[i - 3] + wine[i - 1] + wine[i]),    // 마시는 경우
					dp[i - 2] + wine[i]);    // 마시는 경우
			}
		}

		bw.write(dp[n] + "");

		bw.flush();
		br.close();
		bw.close();
	}
}
