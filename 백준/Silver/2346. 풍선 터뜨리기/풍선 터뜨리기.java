import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int capacity = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		Deque<Balloon> deque = new ArrayDeque<>();

		// 풍선(번호, 이동값)
		for (int i = 0; i < capacity; i++) {
			deque.offer(new Balloon(i + 1, Integer.parseInt(st.nextToken())));
		}

		while (!deque.isEmpty()) {
			Balloon cur = deque.pollFirst();
			bw.write(cur.idx + " ");

			if (deque.isEmpty()) {
				break;
			}

			// 쪽지 확인
			int move = cur.move;

			if (move > 0) {
				// 오른쪽 이동
				// 3 2 1 -3 -1
				// 2 1 -3 -1 1
				// 1 -3 -1 1 2
				for (int r = 0; r < move - 1; r++) {
					deque.offerLast(deque.pollFirst());
				}
			} else {
				// 왼쪽으로 이동
				// 3 2 1 -3 -1
				// 2 1 -3 -1 3
				// 1 -3 -1 3 2

				// 절대값으로 계산
				move = (-move) % deque.size();
				for (int r = 0; r < move; r++) {
					deque.offerFirst(deque.pollLast());
				}
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static class Balloon {
		int idx;
		int move;

		Balloon(int idx, int move) {
			this.idx = idx;
			this.move = move;
		}
	}
}