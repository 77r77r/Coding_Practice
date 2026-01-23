import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		boolean[][] arrs = new boolean[100][100];
		int cnt = 0;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int w = x; w < x + 10; w++) {
				for (int h = y; h < y + 10; h++) {
					if (!arrs[w][h]) {
						arrs[w][h] = true;
						cnt++;
					}
				}
			}
		}

		bw.write(String.valueOf(cnt));

		br.close();
		bw.close();
	}
}