import java.io.*;
import java.util.*;

class Main {
	static int n, sum;
	static int[][] ability;
	static int[] member;
	static int min = Integer.MAX_VALUE;

	static int[] select;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		ability = new int[n][n];
		member = new int[n / 2];
		select = new int[n / 2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		makeTeam(0, 0);

		bw.write(String.valueOf(min));

		bw.flush();
		br.close();
		bw.close();
	}

	static void makeTeam(int depth, int start) {
		if (depth == n / 2) {
			// member 능력치의 합 구하기
			sum = 0;

			// start 팀 능력치
			for (int i = 0; i < member.length; i++) {
				for (int j = 0; j < member.length; j++) {
					if (i == j) {
						continue;
					}
					int p1 = member[i] - 1;
					int p2 = member[j] - 1;

					sum += ability[p1][p2];
				}
			}

			// 링크 팀 구하기
			int[] link = new int[n / 2];
			boolean[] inMember = new boolean[n + 1];

			for (int i = 0; i < member.length; i++) {
				inMember[member[i]] = true;
			}

			int k = 0;

			for (int i = 1; i <= n; i++) {
				if (!inMember[i]) {
					link[k++] = i;
				}
			}

			// 링크 팀 능력치
			for (int i = 0; i < link.length; i++) {
				for (int j = 0; j < link.length; j++) {
					if (i == j) {
						continue;
					}
					int p1 = link[i] - 1;
					int p2 = link[j] - 1;

					sum -= ability[p1][p2];
				}
			}

			// 능력치 최소차
			min = Math.min(min, Math.abs(sum));

			return;
		}

		// 팀 나누기
		for (int i = start; i < n; i++) {
			member[depth] = i + 1;
			makeTeam(depth + 1, i + 1);
		}
	}
}