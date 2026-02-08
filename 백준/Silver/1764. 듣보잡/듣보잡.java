import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int noHearPeople = Integer.parseInt(st.nextToken());
		int noSeePeople = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();
		List<String> names = new ArrayList<>();

		for (int i = 0; i < noHearPeople; i++) {
			set.add(br.readLine());
		}

		for (int i = 0; i < noSeePeople; i++) {
			String name = br.readLine();
			if (set.contains(name)) {
				names.add(name);
			}
		}

		names.sort(String::compareTo);

		bw.write(String.valueOf(names.size()));

		for (String name : names) {
			bw.write("\n" + name);
		}

		bw.flush();
		br.close();
		bw.close();
	}
}