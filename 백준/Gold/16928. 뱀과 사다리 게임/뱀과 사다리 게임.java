import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> ladder = new HashMap<>();
		Map<Integer, Integer> snake = new HashMap<>();
		boolean[] visited = new boolean[101];
		int[] cnt = new int[101];

		// 사다리
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// 뱀
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		cnt[1] = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			while (size-- > 0) {
				int now = q.poll();

				for (int i = 0; i < 6; i++) {
					int dice = now + i + 1;
					int move = dice;

					// 100번째칸 이상이면 통과
					if (move > 100) {
						continue;
					}

					// 이동한 칸에 뱀이 있는지 확인
					if (snake.containsKey(dice)) {
						move = snake.get(dice);
					}

					// 이동한 칸에 사다리가 있는지 확인
					if (ladder.containsKey(dice)) {
						move = ladder.get(dice);
					}

					if (!visited[move]) {
						visited[move] = true;
						cnt[move] = cnt[now] + 1;
						q.add(move);
					}
				}
			}

			if (visited[100]) {
				break;
			}
		}

		bw.write(cnt[100] + "");

		bw.flush();
		br.close();
		bw.close();
	}
}