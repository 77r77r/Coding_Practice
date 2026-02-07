import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());

		int[][] points = new int[size][2];

		// 좌표 저장
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());

			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(points, (a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});

		for (int[] point : points) {
			bw.write(point[0] + " " + point[1] + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}