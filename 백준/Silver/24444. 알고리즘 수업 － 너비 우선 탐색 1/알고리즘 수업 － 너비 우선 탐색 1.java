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

		// 간선
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		// 오름차순 정렬
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		bfs(r);

		for (int o = 1; o <= n; o++) {
			bw.write(order[o] + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();

		// 자신을 제외하고 방문하지 않았다고 세팅
		Arrays.fill(visited, false);
		// for (int i = 1; i < graph.length; i++) {
		// 	visited[i] = false;
		// }

		visited[node] = true;
		q.add(node);
		order[node] = count++;

		while (!q.isEmpty()) {
			int u = q.poll();

			for (int i = 0; i < graph[u].size(); i++) {
				int v = graph[u].get(i);

				if (!visited[v]) {
					visited[v] = true;
					order[v] = count++;
					q.add(v);
				}
			}
		}
	}
}