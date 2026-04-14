import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] dp = new int[n];
		dp[0] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < n; i++) {
			dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;

		int length = Integer.MAX_VALUE;

		while (right < n) {
			int sum = dp[right] - (left > 0 ? dp[left - 1] : 0);

			if (sum >= s) {
				length = Math.min(length, right - left + 1);
				left++;
			} else {
				right++;
			}
		}

		bw.write((length == Integer.MAX_VALUE ? 0 : length) + "");

		bw.flush();
		br.close();
		bw.close();
	}
}