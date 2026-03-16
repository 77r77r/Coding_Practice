import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] temp = new int[n];
		int[] sum = new int[n];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n - k + 1; i++) {
			for (int j = i; j < i + k; j++) {
				sum[i] += temp[j];
			}
			max = Math.max(max, sum[i]);
		}

		bw.write(String.valueOf(max));

		bw.flush();
		br.close();
		bw.close();
	}
}