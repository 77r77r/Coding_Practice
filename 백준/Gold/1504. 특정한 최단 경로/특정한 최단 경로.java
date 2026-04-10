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

	static List<Node>[] graph;
	static int vertex;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		vertex = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());

		graph = new List[vertex + 1];
		for (int i = 1; i <= vertex; i++) {
			graph[i] = new ArrayList<>();
		}
		// dist = new int[vertex + 1];

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int target1 = Integer.parseInt(st.nextToken());
		int target2 = Integer.parseInt(st.nextToken());

		// 1번 ~ target1 과 2까지의 최단거리 확인
		int[] startDist = find(1);
		int[] dist1 = find(target1);
		int[] dist2 = find(target2);

		int one = INF;
		int two = INF;
		int answer = -1;

		if (startDist[target1] != INF && dist1[target2] != INF && dist2[vertex] != INF) {
			one = startDist[target1] + dist1[target2] + dist2[vertex];
		}

		if (startDist[target2] != INF && dist2[target1] != INF && dist1[vertex] != INF) {
			two = startDist[target2] + dist2[target1] + dist1[vertex];
		}

		if (one != INF || two != INF) {
			answer = Math.min(one, two);
		}

		bw.write(answer + "");

		bw.flush();
		br.close();
		bw.close();
	}

	static int[] find(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

		int[] dist = new int[vertex + 1];
		Arrays.fill(dist, INF);

		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.weight > dist[cur.to]) {
				continue;
			}

			for (Node next : graph[cur.to]) {
				int distance = dist[cur.to] + next.weight;

				if (distance < dist[next.to]) {
					dist[next.to] = distance;
					pq.add(new Node(next.to, distance));
				}
			}
		}

		return dist;
	}
}