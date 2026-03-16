import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		String sentence = br.readLine();
		int repeat = Integer.parseInt(br.readLine());

		while (repeat-- > 0) {
			st = new StringTokenizer(br.readLine());

			String target = st.nextToken();
			int startIdx = Integer.parseInt(st.nextToken());
			int endIdx = Integer.parseInt(st.nextToken()) + 1;

			String temp = sentence.substring(startIdx, endIdx) + "1";

			int count = temp.split(target).length;

			bw.write(count - 1 + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}