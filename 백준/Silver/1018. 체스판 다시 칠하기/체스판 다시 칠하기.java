import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());

		String[] boards = new String[height];

		for (int i = 0; i < height; i++) {
			boards[i] = br.readLine();
		}

		// 10 13

		int minCount = 3000;
		int change = 0;

		for (int h = 0; h < height - 7; h++) {
			// 높이 이동
			for (int w = 0; w < width - 7; w++) {
				// 가로 분할해서 이동하기
				change = 0;
				int top = 1;

				// 검정 시작으로 확인, k = 뜯어낼 부분의 줄
				for (int k = h; k < h + 8; k++) {
					char start = 'B';
					char lineStart = start;

					String line = boards[k];
					// 8개 뽑기
					char[] temp = line.substring(w, w + 8).toCharArray();

					if (top % 2 == 0) {
						lineStart = start == 'B' ? 'W' : 'B';
					} else {
						lineStart = start;
					}

					// bw.write(lineStart+ "\n");

					for (int i = 0; i < 8; i++) {
						if (i % 2 == 0) {
							if (temp[i] != lineStart) {
								change++;
							}
						} else {
							if (temp[i] == lineStart) {
								change++;
							}
						}
					}
					top++;
				}

				if (minCount > change) {
					minCount = change;
				}

				// W

				change = 0;
				top = 1;

				// 흰색 시작으로 확인, k = 뜯어낼 부분의 줄
				for (int k = h; k < h + 8; k++) {
					char start = 'W';
					char lineStart = start;

					String line = boards[k];
					// 8개 뽑기
					char[] temp = line.substring(w, w + 8).toCharArray();

					if (top % 2 == 0) {
						lineStart = start == 'B' ? 'W' : 'B';
					} else {
						lineStart = start;
					}

					// bw.write(lineStart+ "\n");

					for (int i = 0; i < 8; i++) {
						if (i % 2 == 0) {
							if (temp[i] != lineStart) {
								change++;
							}
						} else {
							if (temp[i] == lineStart) {
								change++;
							}
						}
					}
					top++;
				}

				if (minCount > change) {
					minCount = change;
				}
			}
		}

		bw.write(minCount + "");

		br.close();
		bw.close();
	}

}

