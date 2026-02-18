import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		// 총총 댄스 리스트
		Set<String> set = new HashSet<>();

		set.add("ChongChong");

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			String p1 = st.nextToken();
			String p2 = st.nextToken();

			if (set.contains(p1) || set.contains(p2)) {
				// 둘중 하나라도 set에 있으면
				set.add(p1);
				set.add(p2);
			}
		}

		bw.write(String.valueOf(set.size()));

		bw.flush();
		br.close();
		bw.close();
	}
}