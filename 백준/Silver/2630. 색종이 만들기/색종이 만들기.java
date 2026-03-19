import java.io.*;
import java.util.*;

class Main {
	static int[][] paper;
	static int n;
	static int blue = 0, white = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		paper = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, n);

		bw.write(white + "\n" + blue);

		bw.flush();
		br.close();
		bw.close();
	}

	static void divide(int x, int y, int size) {
		if (oneColor(x, y, size)) {
			if (paper[x][y] == 1) {
				blue++;
			} else {
				white++;
			}

			return;
		}

		// 1 사분면
		divide(x, y, size / 2);
		// 2 사분면
		divide(x, y + size / 2, size / 2);
		// 3 사분면
		divide(x + size / 2, y, size / 2);
		// 4 사분면
		divide(x + size / 2, y + size / 2, size / 2);
	}

	static boolean oneColor(int x, int y, int size) {
		int target = paper[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (target != paper[i][j]) {
					return false;
				}
			}
		}

		return true;
	}

}