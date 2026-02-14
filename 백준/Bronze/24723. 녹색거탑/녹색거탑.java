import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int height = Integer.parseInt(br.readLine());
		int count = 1;

		// 블럭 1층당 내려오는 방법 2가지
		for (int i = 0; i < height; i++) {
			count *= 2;
		}

		bw.write(String.valueOf(count));

		bw.flush();
		br.close();
		bw.close();
	}
}