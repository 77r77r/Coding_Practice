import java.io.*;
import java.util.*;

class Main {
	static int row;
	static int col;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());

			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int count = 0;    // 지렁이 수

			map = new int[col][row];
			visited = new boolean[col][row];

			// 배추 심기
			while (k-- > 0) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[x][y] = 1;
			}

			for (int i = 0; i < col; i++) {
				for (int j = 0; j < row; j++) {
					// 배추가 있는 곳에 방문하지 않으면
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}

			bw.write(count + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int x, int y) {
		// 방문했거나, 배추가 없으면 return
		if (visited[x][y] || map[x][y] == 0) {
			return;
		}

		// 방문
		visited[x][y] = true;

		// 상하좌우 배추와 방문 여부 확인
		if ((x + 1 < col) && !visited[x + 1][y]) {
			dfs(x + 1, y);
		}

		if ((0 < x) && !visited[x - 1][y]) {
			dfs(x - 1, y);
		}

		if ((y + 1 < row) && !visited[x][y + 1]) {
			dfs(x, y + 1);
		}

		if ((0 < y) && !visited[x][y - 1]) {
			dfs(x, y - 1);
		}
	}
}