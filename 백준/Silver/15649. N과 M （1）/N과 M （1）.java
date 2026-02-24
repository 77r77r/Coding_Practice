import java.io.*;
import java.util.*;

class Main {
	static int target, step;
	static boolean[] used;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		target = Integer.parseInt(st.nextToken());
		step = Integer.parseInt(st.nextToken());

		used = new boolean[target + 1];
		result = new int[step];

		pick(0);

		System.out.print(sb.toString());

		bw.flush();
		br.close();
		bw.close();
	}

	private static void pick(int depth) {
		/**
		 * void back_tracking(int count) {
		 * 	if (현재 상태가 마지막까지 도달한 경우){
		 * 		정답 카운팅;
		 * 		return;
		 *        }
		 *
		 * 	for (가능한 모든 경우에 대해){
		 * 		// 조건을 만족하는지 검사
		 * 		if (조건을 만족하는 경우){
		 * 			상태값 저장;
		 * 			back_tracking(count + 1);
		 * 			상태값 원복;
		 *        }
		 *    }
		 * }
		 */

		// 종료 조건
		if (depth == step) {
			for (int i = 0; i < step; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= target; i++) {
			// 이미 사용된 값이면 통과
			if (used[i]) {
				continue;
			}

			used[i] = true;
			result[depth] = i;
			pick(depth + 1);
			used[i] = false;
		}
	}
}
