import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 넓이양수, 둘레 최대
		int sideMax = Integer.parseInt(st.nextToken());
		int sideA = Integer.parseInt(st.nextToken());
		int sideB = Integer.parseInt(st.nextToken());

		if (sideMax < sideA) {
			int temp = sideA;
			sideA = sideMax;
			sideMax = temp;
		}

		if (sideMax < sideB) {
			int temp = sideB;
			sideB = sideMax;
			sideMax = temp;
		}

		while (sideMax >= sideA + sideB) {
			sideMax--;
		}

		bw.write(sideMax + sideA + sideB + "");

		br.close();
		bw.close();
	}
}