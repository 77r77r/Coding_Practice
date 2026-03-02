import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] stair = new int[n];

		// 계단 입력
		for (int i = 0; i < n; i++) {
			stair[i] = Integer.parseInt((br.readLine()));
		}

		if (n == 1) {
			bw.write(String.valueOf(stair[0]));
		} else if (n == 2) {
			bw.write(String.valueOf(stair[0] + stair[1]));
		} else {
			int[][] score = new int[n][2];

			// score[i][0]: i번 계단에서, 1계단만
			// score[i][1]: i번 계단에서 2계단 연속
			score[0][0] = stair[0];
			score[1][0] = stair[1];
			score[1][1] = stair[0] + stair[1];    // 두 계단 연속

			for (int i = 2; i < n; i++) {
				// 1계단
				score[i][0] = stair[i] + Math.max(score[i - 2][0], score[i - 2][1]);
				// 연속 2계단
				score[i][1] = stair[i] + score[i - 1][0];
			}

			bw.write(String.valueOf(Math.max(score[n - 1][0], score[n - 1][1])));
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
