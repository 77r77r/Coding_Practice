import java.io.*;
import java.util.*;

class Main {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] order;
	static int count = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		order = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		// 간선 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		// 내림차순 정렬
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}

		bfs(r);

		for (int i = 1; i <= n; i++) {
			bw.write(order[i] + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();

		// 방문 초기화
		Arrays.fill(visited, false);

		visited[node] = true;
		order[node] = count++;
		q.add(node);

		while (!q.isEmpty()) {
			int u = q.poll();

			for (int next : graph[u]) {
				if (!visited[next]) {
					visited[next] = true;
					order[next] = count++;
					q.add(next);
				}
			}
		}
	}
}