import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int size = Integer.parseInt(st.nextToken());
		int checkSize = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();

		for (int i = 0; i < size; i++) {
			set.add(br.readLine());
		}

		int count = 0;

		for (int i = 0; i < checkSize; i++) {
			if (set.contains(br.readLine())) {
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		br.close();
		bw.close();
	}
}