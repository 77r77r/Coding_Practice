import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int k = Integer.parseInt(br.readLine());
		List<Integer>[] graph;

		final int RED = 1;
		final int BLUE = -1;

		while (k-- > 0) {
			boolean checkBipartite = true;

			st = new StringTokenizer(br.readLine());

			int vertex = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());

			int[] color = new int[vertex + 1];

			graph = new List[vertex + 1];
			for (int i = 1; i <= vertex; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < edge; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				graph[u].add(v);
				graph[v].add(u);
			}

			// 정렬
			for (int i = 1; i <= vertex; i++) {
				Collections.sort(graph[i]);
			}

			// 각 정점 탐색
			for (int i = 1; i <= vertex; i++) {

				// 그래프 아니면 정지
				if (!checkBipartite) {
					break;
				}

				// 방문 안했으면 번갈아가면서 색칠
				if (color[i] == 0) {
					Queue<Integer> q = new LinkedList<>();

					q.add(i);
					color[i] = RED;

					while (!q.isEmpty() && checkBipartite) {
						int cur = q.poll();

						// 인접한 정점 방문
						for (int next : graph[cur]) {
							// 방문하지 않았으면다른색으로 색칠
							if (color[next] == 0) {
								color[next] = color[cur] * -1;
								q.add(next);
							} else if (color[next] == color[cur]) {
								// 같은색이면 아님
								checkBipartite = false;
								break;
							}
						}
					}
				}
			}
			bw.write(checkBipartite ? "YES" : "NO");
			bw.newLine();
		}

		bw.flush();
		br.close();
		bw.close();
	}
}