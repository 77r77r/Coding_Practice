import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(br.readLine());

		Set<Integer> set = new HashSet<>();
		int answer = 0;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (set.contains(x - num)) {
				answer++;
			} else {
				set.add(num);
			}
		}

		bw.write(answer + "");

		bw.flush();
		br.close();
		bw.close();
	}
}