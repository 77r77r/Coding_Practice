import java.io.*;
import java.util.*;

class Main {
	static List<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		graph = new List[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		// 간선 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			graph[n1].add(n2);
			graph[n2].add(n1);
		}

		// 정렬
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		dfs(v);

		sb.append("\n");

		Arrays.fill(visited, false);
		bfs(v);

		bw.write(sb.toString());

		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int node) {
		visited[node] = true;
		sb.append(node + " ");

		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();

		Arrays.fill(visited, false);

		visited[node] = true;
		q.add(node);
		sb.append(node + " ");

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 0; i < graph[cur].size(); i++) {
				int x = graph[cur].get(i);

				if (!visited[x]) {
					visited[x] = true;
					q.add(x);
					sb.append(x + " ");
				}
			}
		}
	}
}