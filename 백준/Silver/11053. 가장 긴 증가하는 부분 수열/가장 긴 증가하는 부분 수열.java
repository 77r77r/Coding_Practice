import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] number = new int[n];
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (number[i] > number[j]) {
					max = max < dp[j] ? dp[j] : max;
				}
			}
			dp[i] = max + 1;
		}

		int max = dp[0];

		for (int d : dp) {
			max = max < d ? d : max;
		}

		bw.write(max + "");

		bw.flush();
		br.close();
		bw.close();
	}
}