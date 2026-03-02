import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] triangle = new int[n][n];

		// 0 이상 9999 이하
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < i + 1; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] sum = new int[n][n];

		// i = 0
		sum[0][0] = triangle[0][0];

		/*
		// i = 1
		sum[1][0] = triangle[1][0] + sum[0][0];
		sum[1][1] = triangle[1][0] + sum[0][0];

		// i = 2
		sum[2][0] = triangle[2][0] + sum[1][0];
		sum[2][1] = triangle[2][1] + Math.max(sum[1][0], sum[1][1]);
		sum[2][2] = triangle[2][2] + sum[1][1];

		// i = 3
		sum[3][0] = triangle[3][0] + sum[2][0];
		sum[3][1] = triangle[3][1] + Math.max(sum[2][0], sum[2][1]);
		sum[3][2] = triangle[3][2] + Math.max(sum[2][1], sum[2][2]);
		sum[3][3] = triangle[3][3] + sum[2][2];
		*/

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					// 왼쪽 끝
					sum[i][j] = triangle[i][j] + sum[i - 1][j];
				} else if (j == i) {
					sum[i][j] = triangle[i][j] + sum[i - 1][i - 1];
				} else {
					sum[i][j] = triangle[i][j] + Math.max(sum[i - 1][j - 1], sum[i - 1][j]);
				}
			}
		}

		int max = sum[n - 1][0];

		for (int i = 1; i < n; i++) {
			max = max > sum[n - 1][i] ? max : sum[n - 1][i];
		}

		bw.write(String.valueOf(max));

		bw.flush();
		br.close();
		bw.close();
	}
}