import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int people = Integer.parseInt(st.nextToken());
		int winnerCount = Integer.parseInt(st.nextToken());

		// st = new StringTokenizer(br.readLine());

		int[] score = Arrays.stream(br.readLine().split(" "))
			.map(Integer::parseInt)
			.mapToInt(Integer::intValue)
			.toArray();

		for (int i = 0; i < people; i++) {
			for (int j = 0; j < people - 1 - i; j++) {
				if (score[j] < score[j + 1]) {
					int temp = score[j];
					score[j] = score[j + 1];
					score[j + 1] = temp;
				}
			}
		}

		bw.write(String.valueOf(score[winnerCount - 1]));

		br.close();
		bw.close();
	}
}