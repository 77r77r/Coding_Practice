import java.io.*;
import java.util.*;

class Main {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int vertex = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());

		graph = new ArrayList[vertex + 1];
		for (int i = 1; i <= vertex; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[vertex + 1];

		// 간선 입력
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		dfs(1);

		bw.write(String.valueOf(count));

		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int node) {
		visited[node] = true;

		for (int next : graph[node]) {
			if (!visited[next]) {
				count++;
				dfs(next);
			}
		}
	}
}