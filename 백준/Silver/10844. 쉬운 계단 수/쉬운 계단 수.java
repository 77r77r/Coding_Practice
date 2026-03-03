import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		// dp[n][i] = 길이 n)의 끝자리 i의 갯수
		long[][] dp = new long[n + 1][10];

		// 초기값 세팅
		dp[1][0] = 0;
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][1]) % 1000000000;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 1000000000;
			dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % 1000000000;
			dp[i][3] = (dp[i - 1][2] + dp[i - 1][4]) % 1000000000;
			dp[i][4] = (dp[i - 1][3] + dp[i - 1][5]) % 1000000000;
			dp[i][5] = (dp[i - 1][4] + dp[i - 1][6]) % 1000000000;
			dp[i][6] = (dp[i - 1][5] + dp[i - 1][7]) % 1000000000;
			dp[i][7] = (dp[i - 1][6] + dp[i - 1][8]) % 1000000000;
			dp[i][8] = (dp[i - 1][7] + dp[i - 1][9]) % 1000000000;
			dp[i][9] = (dp[i - 1][8]) % 1000000000;
		}

		long sum = 0;
		for (long d : dp[n]) {
			sum += d;
		}

		bw.write((sum % 1000000000) + "");

		bw.flush();
		br.close();
		bw.close();
	}
}