import java.io.*;
import java.util.*;

class Main {
	static boolean[][] visited;
	static int[] target = new int[2];

	static int size;
	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		int repeat = Integer.parseInt(br.readLine());
		int[] board;

		while (repeat-- > 0) {
			size = Integer.parseInt(br.readLine());
			visited = new boolean[size][size];

			String[] line = br.readLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);

			// 목표
			line = br.readLine().split(" ");
			target[0] = Integer.parseInt(line[0]);
			target[1] = Integer.parseInt(line[1]);

			bw.write(bfs(x, y) + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();

		visited[x][y] = true;
		q.add(new int[] {x, y});

		int count = 0;

		while (!q.isEmpty()) {
			int move = q.size();

			for (int i = 0; i < move; i++) {
				int[] point = q.poll();
				int pointX = point[0];
				int pointY = point[1];

				if (pointX == target[0] && pointY == target[1]) {
					return count;
				}

				// 위치 이동 확인
				for (int k = 0; k < 8; k++) {
					int nextX = pointX + dx[k];
					int nextY = pointY + dy[k];

					// 범위 확인
					if (nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) {
						continue;
					}

					if (!visited[nextX][nextY]) {
						visited[nextX][nextY] = true;
						q.add(new int[] {nextX, nextY});
					}
				}
			}
			count++;
		}

		return count;
	}
}