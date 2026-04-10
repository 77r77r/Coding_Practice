import java.io.*;
import java.util.*;

class Main {
	static class Node {
		int to;
		int weight;

		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		pq.add(new Node(n, 0));

		int[] dist = new int[100001];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[n] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.weight > dist[cur.to]) {
				continue;
			}

			// 짧으면 갱신
			int n1 = cur.to + 1;
			int n2 = cur.to - 1;
			int n3 = cur.to * 2;

			if (n1 <= 100000 && dist[cur.to] + 1 < dist[n1]) {
				dist[n1] = dist[cur.to] + 1;
				pq.add(new Node(n1, dist[cur.to] + 1));
			}

			if (n2 >= 0 && n2 <= 100000 && dist[cur.to] + 1 < dist[n2]) {
				dist[n2] = dist[cur.to] + 1;
				pq.add(new Node(n2, dist[cur.to] + 1));
			}

			if (n3 <= 100000 && dist[cur.to] < dist[n3]) {
				dist[n3] = dist[cur.to];
				pq.add(new Node(n3, dist[cur.to]));
			}
		}

		bw.write(dist[k] + "");

		bw.flush();
		br.close();
		bw.close();
	}
}