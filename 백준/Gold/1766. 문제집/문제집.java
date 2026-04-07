import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] order = new int[n + 1];
		List<Integer>[] graph = new List[n + 1];
		boolean[] visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			order[b]++;
		}

		for (int i = 1; i <= n; i++) {
			int cur = 0;

			for (int j = 1; j <= n; j++) {
				if (!visited[j] && order[j] == 0) {
					cur = j;
					break;
				}
			}

			visited[cur] = true;
			bw.write(cur + " ");

			for (int next : graph[cur]) {
				order[next]--;
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}