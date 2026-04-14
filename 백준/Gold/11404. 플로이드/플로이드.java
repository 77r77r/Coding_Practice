import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		// 도시 - 정점
		int n = Integer.parseInt(br.readLine());
		// 버스 - 간선
		int m = Integer.parseInt(br.readLine());

		int[][] dist = new int[n + 1][n + 1];
		final int INF = 1_000_000_000;

		// 초기화
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dist[i], INF);
			// 자기 자신
			dist[i][i] = 0;
		}

		// 간선 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 더 짧은 거리 입력
			dist[a][b] = Math.min(dist[a][b], c);
		}

		// 최단 거리 구하기
		for (int k = 1; k <= n; k++) {	// 경유지
			for (int i = 1; i <= n; i++) {	// 출발
				for (int j = 1; j <= n; j++) {	// 도착
					/**
					 * A: dist[i][k] + dist[k][j] < dist[i][j]   → 갱신해야 함
					 * B: dist[i][j] <= dist[i][k] + dist[k][j] → 갱신하면 안 됨
					 */
					// dist[a] <= dist[b] + w(b,a) : 더 짧다는 거
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] == INF) {
					bw.write("0 ");
				} else {
					bw.write(dist[i][j] + " ");
				}
			}
			bw.newLine();
		}

		bw.flush();
		br.close();
		bw.close();
	}
}