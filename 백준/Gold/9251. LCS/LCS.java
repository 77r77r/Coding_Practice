import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();



		char[] word1 = br.readLine().toCharArray();
		char[] word2 = br.readLine().toCharArray();

		int[][] dp = new int[word1.length + 1][word2.length + 1];

		// 경계값 초기화
		for (int i = 0; i <= word1.length; i++) {
			dp[i][0] = 0;
		}

		for (int i = 0; i <= word2.length; i++) {
			dp[0][i] = 0;
		}

		// LCS
		for (int i = 1; i <= word1.length; i++) {
			for (int j = 1; j <= word2.length; j++) {
				if (word1[i-1] == word2[j-1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		bw.write(String.valueOf(dp[word1.length][word2.length]));

		bw.flush();
		br.close();
		bw.close();
	}
}