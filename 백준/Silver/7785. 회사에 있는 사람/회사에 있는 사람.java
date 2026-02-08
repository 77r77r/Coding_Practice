import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String type = st.nextToken();

			if ("enter".equals(type)) {
				set.add(name);
			} else {
				set.remove(name);
			}
		}

		List<String> list = new ArrayList<>();
		list.addAll(set);

		list.sort(Comparator.reverseOrder());

		for (String n : list) {
			bw.write(n + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}