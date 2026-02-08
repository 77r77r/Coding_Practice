import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int input = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < input; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		int check = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < check; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (set.contains(num)) {
				bw.write("1 ");
			} else {
				bw.write("0 ");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}