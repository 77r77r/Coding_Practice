import java.io.*;
import java.util.*;

class Main {
	static int[][] board = new int[9][9];
	static StringBuilder sb = new StringBuilder();
	static boolean solved = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 스토쿠 배열 입력
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		checkBoard(0, 0);

		bw.write(sb.toString());
		bw.flush();

		bw.close();
		br.close();
	}

	static void checkBoard(int x, int y) {
		// 종료조건
		if (x > 8) {
			solved = true;

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}

			return;
		}

		if (board[x][y] != 0) {
			// 빈칸이 아니라면 다음 칸 이동
			if (y == 8) {
				checkBoard(x + 1, 0);
			} else {
				checkBoard(x, y + 1);
			}
		} else {
			// 빈칸인 경우 1 ~ 9 넣어보기
			for (int n = 1; n <= 9; n++) {
				if (isValid(x, y, n)) {
					board[x][y] = n;

					if (y == 8) {
						checkBoard(x + 1, 0);
					} else {
						checkBoard(x, y + 1);
					}

					if (solved) {
						break;
					}
				}
			}
			if (solved) {
				return;
			}

			board[x][y] = 0;
		}
	}

	static boolean isValid(int x, int y, int n) {
		// 세로 값 중복
		for (int row = 0; row < 9; row++) {
			if (n == board[row][y]) {
				return false;
			}
		}

		// 가로 값 중복
		for (int col = 0; col < 9; col++) {
			if (n == board[x][col]) {
				return false;
			}
		}

		// 3 * 3 값 중복
		for (int row = 3 * (x / 3); row < 3 * (x / 3 + 1); row++) {
			for (int col = 3 * (y / 3); col < 3 * (y / 3 + 1); col++) {
				if (n == board[row][col]) {
					return false;
				}
			}
		}

		return true;
	}
}