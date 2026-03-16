import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		long[] dp = new long[n];

		long count = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = arr[0];

		for (int i = 1; i < n; i++) {
			dp[i] = dp[i - 1] + arr[i];
		}

		long[] remainder = new long[m];

		for (long d : dp) {
			remainder[(int)(d % m)]++;
		}
		// 0 ~ n 까지가 고려되지 않았다.
		// m ~ n 이 없는거 아님?
		// dp[] 누적 합으로만 체크하고 누적합끼리 빼는게없는데 = i ~ j 구간에 대한 고려가 없는 거 아님?

		count += remainder[0];

		for (int i = 0; i < m; i++) {
			long x = remainder[i];

			count += x * (x - 1) / 2;
		}
        
		bw.write(String.valueOf(count));

		bw.flush();
		br.close();
		bw.close();
	}
}