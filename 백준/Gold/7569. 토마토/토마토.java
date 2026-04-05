import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		int[][][] box = new int[height][col][row];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < col; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < row; k++) {
					int t = Integer.parseInt(st.nextToken());
					box[i][j][k] = t;
					if (t == 1) {
						queue.add(new int[] {i, j, k});
					}
				}
			}
		}

		// 위 아래 왼쪽 오른쪽 앞 뒤
		int[] dx = {-1, 1, 0, 0, 0, 0};
		int[] dy = {0, 0, -1, 1, 0, 0};
		int[] dz = {0, 0, 0, 0, -1, 1};

		int day = 0;

		while (!queue.isEmpty()) {
			int repeat = queue.size();
			boolean anymore = true;

			while (repeat-- > 0) {
				int[] cur = queue.poll();

				int curZ = cur[0];    // 층
				int curX = cur[1];
				int curY = cur[2];

				for (int i = 0; i < 6; i++) {
					int nextX = curX + dx[i];
					int nextY = curY + dy[i];
					int nextZ = curZ + dz[i];

					if (nextX < 0 || col <= nextX ||
						nextY < 0 || row <= nextY ||
						nextZ < 0 || height <= nextZ) {
						continue;
					}

					if (box[nextZ][nextX][nextY] == 0) {
						box[nextZ][nextX][nextY] = 1;
						queue.add(new int[]{nextZ, nextX, nextY});
						anymore = false;
					}
				}
			}
			if (anymore) {
				break;
			}
			day++;
		}

		boolean fail = false;

		for (int[][] floor : box) {
			for (int[] tomato : floor) {
				for (int t : tomato) {
					if (t == 0) {
						fail = true;
					}
				}
			}
		}

		bw.write((fail ? "-1" : day) + "");

		bw.flush();
		br.close();
		bw.close();
	}
}