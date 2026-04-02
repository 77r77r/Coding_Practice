import java.io.*;
import java.util.*;

class Main {
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> house = new ArrayList<>();
	static int count = 0;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();

			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		// 방문하지 않안 곳에서 연결된 집이 있는지 확인
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 방문하지 않은 1이면 방문
				if (!visited[i][j] && map[i][j] == 1) {
					count = 0;
					dfs(i, j);
					house.add(count);
				}
			}
		}

		Collections.sort(house);

		bw.write(house.size() + "\n");

		for (int h : house) {
			bw.write(h + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int x, int y) {
		if (map[x][y] == 0 || visited[x][y]) {
			return;
		}

		// 1인경우 집 크기 증가
		visited[x][y] = true;
		count++;

		// 더 방문할 곳이 없다는 걸 어떻게 판단하지?

		// 위쪽 확인
		if (0 < x && !visited[x - 1][y]) {
			dfs(x - 1, y);
		}

		// 우측 확인
		if (y + 1 < n && !visited[x][y + 1]) {
			dfs(x, y + 1);
		}

		// 좌측
		if (y > 0 && !visited[x][y - 1]) {
			dfs(x, y - 1);
		}

		// 아래
		if (x + 1 < n && !visited[x + 1][y]) {
			dfs(x + 1, y);
		}
	}

}