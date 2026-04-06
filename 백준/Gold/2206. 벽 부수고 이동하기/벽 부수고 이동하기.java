import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());

		int[][] map = new int[col + 1][row + 1];
		boolean[][][] visited = new boolean[col + 1][row + 1][2];
		int[][][] move = new int[col + 1][row + 1][2];

		for (int i = 1; i <= col; i++) {
			String line = br.readLine();
			for (int j = 1; j <= row; j++) {
				map[i][j] = line.charAt(j - 1) - '0';
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {1, 1, 0});
		visited[1][1][0] = true;
		move[1][1][0] = 1;

		// 상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		boolean finished = false;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			int curX = cur[0];
			int curY = cur[1];
			int wall = cur[2];

			if (curX == col && curY == row) {
				bw.write(move[curX][curY][wall] + "");
				finished = true;
				break;
			}

			// 상하좌우 이동
			for (int i = 0; i < 4; i++) {
				int x = curX + dx[i];
				int y = curY + dy[i];

				// 이동 가능 여부 확인
				if (x <= 0 || x > col || y <= 0 || y > row) {
					continue;
				}

				if (map[x][y] == 0 && !visited[x][y][wall]) {
					visited[x][y][wall] = true;
					move[x][y][wall] = move[curX][curY][wall] + 1;
					queue.add(new int[] {x, y, wall});
				}

				if (map[x][y] == 1 && wall == 0 && !visited[x][y][1]) {
					// 부수고 이동
					visited[x][y][1] = true;
					move[x][y][1] = move[curX][curY][0] + 1;
					queue.add(new int[] {x, y, 1});
				}
			}
		}

		if (!finished) {
			bw.write("-1");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}