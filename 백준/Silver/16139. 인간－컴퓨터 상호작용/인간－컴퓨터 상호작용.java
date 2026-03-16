import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		String sentence = br.readLine();
		int repeat = Integer.parseInt(br.readLine());
		int[][] dp = new int[26][sentence.length()];

		for (int i = 0; i < sentence.length(); i++) {
			if (i > 0) {
				// 각 알파벳 자리 업데이트
				for (int j = 0; j < 26; j++) {
					dp[j][i] = dp[j][i - 1];
				}
			}

			int idx = sentence.charAt(i) - 'a';
			dp[idx][i]++;
		}

		while (repeat-- > 0) {
			st = new StringTokenizer(br.readLine());

			char target = st.nextToken().charAt(0);
			int idx = target - 'a';

			int startIdx = Integer.parseInt(st.nextToken());
			int endIdx = Integer.parseInt(st.nextToken());

			int count = startIdx == 0 ? dp[idx][endIdx] : (dp[idx][endIdx] - dp[idx][startIdx - 1]);

			bw.write(count + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}