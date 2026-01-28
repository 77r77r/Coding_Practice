import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		int distance_x, distance_y;

		distance_x = (x > width / 2) ? width - x : x;
		distance_y = (y > height / 2) ? height - y : y;

		bw.write((distance_x < distance_y ? distance_x : distance_y) + "");

		br.close();
		bw.close();
	}
}