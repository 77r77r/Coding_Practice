import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int[] pointX = new int[3];
		int[] pointY = new int[3];

		int realX = 0;
		int realY = 0;

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			pointX[i] = x;
			pointY[i] = y;
		}

		if (pointX[0] == pointX[1]) {
			realX = pointX[2];
		} else if (pointX[0] == pointX[2]) {
			realX = pointX[1];
		} else {
			realX = pointX[0];
		}

		if (pointY[0] == pointY[1]) {
			realY = pointY[2];
		} else if (pointY[0] == pointY[2]) {
			realY = pointY[1];
		} else {
			realY = pointY[0];
		}

		bw.write(realX + " " + realY);

		br.close();
		bw.close();
	}
}