import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] num = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		List<Integer>[] graph = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			graph[left].add(right);
			num[right]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (num[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			bw.write(cur+ " ");

			for (int next : graph[cur]) {
				num[next]--;

				if (num[next] == 0) {
					queue.add(next);
				}
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}