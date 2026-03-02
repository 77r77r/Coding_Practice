import java.io.*;
import java.util.*;

class Main {
	static int[] num;
	static int[] sum;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		num = new int[n];
		sum = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		func(n);

		bw.write(String.valueOf(max));

		bw.flush();
		br.close();
		bw.close();
	}

	static void func(int n) {
		max = sum[0] = num[0];

		for (int i = 1; i < n; i++) {
			sum[i] = Math.max(num[i], sum[i - 1] + num[i]);
			max = Math.max(max, sum[i]);
		}
	}
}