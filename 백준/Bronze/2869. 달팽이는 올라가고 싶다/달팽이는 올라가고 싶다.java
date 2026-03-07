import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		int day = 1;

		if (height > up) {
			// 남은 거리 = up 일 때 문제 -> - down 필요 없음
			// (height - up + (up - down) - 1) / (up - down);
			day += (height - down - 1) / (up - down);
		}

		bw.write(String.valueOf(day));

		br.close();
		bw.close();
	}
}