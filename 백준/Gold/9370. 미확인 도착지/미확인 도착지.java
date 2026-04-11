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

	static int vertex;
	static List<Node>[] graph;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int repeat = Integer.parseInt(br.readLine());

		while (repeat-- > 0) {
			st = new StringTokenizer(br.readLine());

			// 교차로, 도로, 목적지 후보 수
			vertex = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			// 초기화
			graph = new List[vertex + 1];
			for (int i = 1; i <= vertex; i++) {
				graph[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());

			// 시작점, g <-> h필수
			int start = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			int ghDist = INF;

			for (int i = 1; i <= edge; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				// 양방향 도로
				graph[a].add(new Node(b, d));
				graph[b].add(new Node(a, d));

				// g와 h 교차로 길이 저장
				if ((a == g && b == h) || (a == h && b == g)) {
					ghDist = d;
				}
			}

			int[] sDist = find(start);
			int[] gDist = find(g);
			int[] hDist = find(h);

			List<Integer> list = new ArrayList<>();

			// 목적지 후보
			for (int i = 0; i < t; i++) {
				int gStart = INF;
				int hStart = INF;

				int target = Integer.parseInt(br.readLine());

				// s -> g -> h -> target
				gStart = sDist[g] + ghDist + hDist[target];

				// s -> h -> g -> target
				hStart = sDist[h] + ghDist + gDist[target];

				// 최단거리인지 확인
				if (sDist[target] == gStart || sDist[target] == hStart) {
					list.add(target);
				}
			}

			// 오름차순 정렬 조건
			Collections.sort(list);
			for (int l : list) {
				bw.write(l + " ");
			}
			bw.newLine();
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static int[] find(int n) {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		int[] dist = new int[vertex + 1];

		Arrays.fill(dist, INF);

		pq.add(new Node(n, 0));
		dist[n] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.weight > dist[cur.to]) {
				continue;
			}

			for (Node next : graph[cur.to]) {
				int road = dist[cur.to] + next.weight;

				if (road < dist[next.to]) {
					dist[next.to] = road;
					pq.add(new Node(next.to, road));
				}
			}
		}

		return dist;
	}
}