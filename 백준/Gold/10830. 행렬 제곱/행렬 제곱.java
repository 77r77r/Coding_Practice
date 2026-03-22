import java.io.*;
import java.util.*;

class Main {
	static long[][] result;
	static int n;
	static final long mod = 1000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		long[][] arr = new long[n][n];
		result = new long[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Long.parseLong(st.nextToken()) % mod;
			}
		}

		result = func(arr, b);

		for (long[] r : result) {
			for (int i = 0; i < r.length; i++) {
				bw.write(r[i] + " ");
			}
			bw.newLine();
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static long[][] func(long[][] arr, long b) {
		if (b == 1) {
			return arr;
		}

		if (b % 2 == 0) {
			long[][] temp = func(arr, b / 2);
			return p2(temp, temp);
		} else {
			return p2(arr, func(arr, b - 1));
		}
	}

	// 행렬곱
	static long[][] p2(long[][] x, long[][] y) {
		long[][] temp = new long[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					temp[i][j] += (x[i][k] % mod) * (y[k][j] % mod);
					temp[i][j] %= mod;
				}
			}
		}
		return temp;
	}
}