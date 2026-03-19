import java.io.*;
import java.util.*;

class Main {
	static int[][] paper;
	static int minus = 0;
	static int zero = 0;
	static int plus = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		checkPaper(0, 0, n);

		bw.write(minus + "\n" + zero + "\n" + plus);

		bw.flush();
		br.close();
		bw.close();
	}

	static void checkPaper(int x, int y, int size) {
		if (checkSame(x, y, size)) {
			switch (paper[x][y]) {
				case -1:
					minus++;
					break;
				case 0:
					zero++;
					break;
				case 1:
					plus++;
					break;
			}
		} else {
			int split = size / 3;
			checkPaper(x, y, split);
			checkPaper(x, y + split, split);
			checkPaper(x, y + split * 2, split);

			checkPaper(x + split, y, split);
			checkPaper(x + split, y + split, split);
			checkPaper(x + split, y + split * 2, split);

			checkPaper(x + split * 2, y, split);
			checkPaper(x + split * 2, y + split, split);
			checkPaper(x + split * 2, y + split * 2, split);
		}

	}

	static boolean checkSame(int x, int y, int size) {
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