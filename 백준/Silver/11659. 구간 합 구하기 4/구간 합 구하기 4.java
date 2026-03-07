import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] number = new int[n + 1];
		st = new StringTokenizer(br.readLine());

		// dp[i] = i 번째 수까지의 합
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			dp[i] += dp[i - 1] + number[i];
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			bw.write((dp[end] - dp[start - 1]) + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}