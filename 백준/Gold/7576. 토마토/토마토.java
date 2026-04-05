import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		int[][] box = new int[col][row];
		int day = 0;

		Queue<int[]> q = new LinkedList<>();

		//box 배치
		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {
				int tomato = Integer.parseInt(st.nextToken());
				box[i][j] = tomato;

				if (tomato == 1) {
					q.add(new int[] {i, j});
				}
			}
		}

		// 모든 토마토의 위치를 확인하고
		// 그 주변을 전파 시키고 +1 일
		int[] dx = new int[] {-1, 1, 0, 0}; // 상 하 좌 우
		int[] dy = new int[] {0, 0, -1, 1}; // 상 하 좌 우

		while (!q.isEmpty()) {
			int start = q.size();
			boolean anymore = true;

			while (start-- > 0) {
				int[] cur = q.poll();

				int curX = cur[0];
				int curY = cur[1];

				// 상하좌우 전파하기
				for (int i = 0; i < 4; i++) {
					int x = curX + dx[i];
					int y = curY + dy[i];

					if (x < 0 || col <= x || y < 0 || row <= y) {
						continue;
					}
					// 전파되지 않은 익은 토마토라면
					if (box[x][y] == 0) {
						q.add(new int[] {x, y});
						box[x][y] = 1;
						anymore = false;
					}
				}
			}
			// 모든 토마토가 익었거나, 익을 수 있는 토마토가 없다면 종료
			if (anymore) {
				break;
			}
			day++;
		}

		boolean fail = false;

		for (int[] tomato : box) {
			for (int t : tomato) {
				if (t == 0) {
					fail = true;
					break;
				}
			}
		}

		bw.write((fail ? "-1" : day) + "");

		bw.flush();
		br.close();
		bw.close();
	}
}