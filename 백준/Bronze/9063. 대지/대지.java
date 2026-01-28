import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int maxX = x, minX = x, maxY = y, minY = y;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			if (maxX < x) {
				maxX = x;
			}

			if (minX > x) {
				minX = x;
			}

			if (maxY < y) {
				maxY = y;
			}

			if (minY > y) {
				minY = y;
			}
		}

		int width = maxX - minX;
		int height = maxY - minY;

		bw.write(width * height + "");

		br.close();
		bw.close();
	}
}